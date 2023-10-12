import { z } from "zod";
import { publicProcedure, router } from "../../trpc";

type InventoryResponse = {
    message: string,
    success: boolean,
    payload: Inventory[] | null
}

type Inventory = {
    id?: number,
    inventory_name: string,
    item_type: string,
    quantity: number,
    location_id: number,
    security : "private" | "public" | "subscribe",
}

export const inventoryRouter = router({
    getInventory: publicProcedure
    .query( ({ ctx }) => {
        const fetchInventory = ctx.db.prepare(`
        SELECT * FROM invenotry
        `)
        const inventories = fetchInventory.all()
        return {
            inventories
        }
    }),
    addInventory: publicProcedure
    .input(
        z.object({
            item_type : z.string(),
            inventory_name : z.string(),
            quantity: z.number(),
            location_id: z.number(),
            security: z.literal("private").or(z.literal("subscribe")).or(z.literal("public"))
        })
    )
    .query( ({ input, ctx }) => {
        let response : InventoryResponse = {
            message: "error occured before db transaction",
            success: false,
            payload: null
        }
        const fetchLocation = ctx.db.prepare(`
        SELECT * FROM location WHERE location_id = ${input.location_id}
        `)

        const fetched_location = fetchLocation.all();

        if(fetched_location){
            const newInvenotry : Inventory = {
                item_type: input.item_type,
                inventory_name: input.inventory_name,
                quantity: input.quantity,
                location_id: input.location_id,
                security: input.security
            }

            const insertInventory = ctx.db.prepare<Inventory>(`
                INSERT INTO invenotry (item_type, inventory_name, quantity, security) VALUES (:item_type, :inventory_name, :quantity, :security );
            `)

            insertInventory.run(newInvenotry)

            const getInsertedInventory = ctx.db.prepare(`
            SELECT * FROM inventory WHERE inventory_name = ${newInvenotry.inventory_name}
            `)

            const inventory = getInsertedInventory.all()

            response = {
                message: "Successfully Added an Invenotry",
                success: true,
                payload: inventory as Inventory[]
            }
        }
        else {
            response = {
                message: "location not found",
                success: false,
                payload: null
            }
        }

        return {
            response
        }
    })
})