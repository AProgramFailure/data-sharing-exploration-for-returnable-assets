import { z } from "zod";
import { publicProcedure, router } from "../../trpc";

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
    })
})