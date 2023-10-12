import { z } from "zod";
import { publicProcedure, router } from "../../trpc";

type OrderReponse = {
    message: string,
    success: boolean,
    payload: Order[] | null
}

type Order = {
    id?: number,
    organization_id: number,
    source_location_id: number,
    destination_location_d: number
    status: string,
    order_item_id: number,
    security : "private" | "public" | "subscribe",
}

export const orderRouter = router({
    getOrders: publicProcedure
    .query( ({ ctx }) => {
        const fetchOrders = ctx.db.prepare(`
        SELECT * FROM _order
        `)
        const orders = fetchOrders.all();
        return {
            orders
        }
    }),
    addOrder : publicProcedure
    .input(
        z.object({
            organization_id : z.number(),
            source_location_id: z.number(),
            destination_location_id: z.number(),
            status: z.string(),
            order_item_id: z.number(),
            security: z.literal("private").or(z.literal("subscribe")).or(z.literal("public"))
        })
    )
    .query( ({ input, ctx}) => {
        let response : OrderReponse = {
            message: "error occured before db transaction",
            success: false,
            payload: null
        }


        return {
            response
        }
    })
})