import { z } from "zod";
import { publicProcedure, router } from "../../trpc";

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
    })
})