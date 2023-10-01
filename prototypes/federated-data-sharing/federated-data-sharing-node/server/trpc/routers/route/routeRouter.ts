import { z } from 'zod'
import { publicProcedure, router } from "../../trpc";

export const routerRouter = router({
    getRoutes: publicProcedure
    .input(
        z.object({
            email: z.string().email()
        })
    )
    .query(({ input, ctx }) => {
        return {
            routes: []
        }
    })
})