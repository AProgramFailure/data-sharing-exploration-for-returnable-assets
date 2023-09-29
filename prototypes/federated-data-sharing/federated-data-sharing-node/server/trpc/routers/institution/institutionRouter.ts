import { z } from 'zod'
import { publicProcedure, router } from "../../trpc";

export const institutionRouter = router({
    getInstitutions: publicProcedure
    .input(
        z.object({
            email: z.string().email()
        })
    )
    .query(({ input, ctx }) => {
        return {
            institutions: []
        }
    })
})