import { z } from "zod";
import { publicProcedure, router } from "../../trpc";

export const itemRouter = router({
    getItems: publicProcedure
    .input(
        z.object({
            email: z.string().email()
        })
    )
    .query(({ input, ctx }) => {
        return {
            items: []
        }
    })
})