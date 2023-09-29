import { z } from "zod"
import { publicProcedure, router } from "../../trpc"

export const orderRouter = router({
    getOrders: publicProcedure
    .input(
        z.object({
            email: z.string().email()
        })
    )
    .query(({ input, ctx }) => {
        return {
            orders: []
        }
    })
})