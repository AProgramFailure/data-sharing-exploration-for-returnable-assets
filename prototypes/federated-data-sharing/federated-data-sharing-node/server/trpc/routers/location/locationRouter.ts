import { z } from "zod"
import { publicProcedure, router } from "../../trpc"

export const locationRouter = router({
    getLocations: publicProcedure
    .input(
        z.object({
            email: z.string().email()
        })
    )
    .query(({ input, ctx }) => {
        return {
            locations: []
        }
    })
})