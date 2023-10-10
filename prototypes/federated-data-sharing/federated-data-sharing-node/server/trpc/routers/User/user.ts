import { z } from "zod";
import { publicProcedure, router } from "../../trpc";

export const userRouter = router({
    getUsers: publicProcedure
    .query( ({ ctx }) => {
        const fetchUsers = ctx.db.prepare(`
        SELECT * FROM _user
        `)
        const users = fetchUsers.all();
        return {
            users
        }
    })
})