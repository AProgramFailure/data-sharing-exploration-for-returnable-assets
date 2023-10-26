import { z } from "zod";
import { publicProcedure, router } from "../../trpc";

type UserResponse = {
    message : string,
    success: boolean
    payload: User | null | unknown
}

type User = {
    id?: number,
    email: string,
    organization_id: number,
    first_name : string,
    last_name: string,
    password: string
}


export const userRouter = router({
    getUsers: publicProcedure
    .query( ({ ctx }) => {
        const fetchUsers = ctx.db.prepare(`
        SELECT user_id, email, first_name, last_name, organization_id FROM user_table
        `)
        const users = fetchUsers.all();
        return {
            users
        }
    }),
    getUser: publicProcedure
    .input(
        z.object({
            email: z.string().email()
        })
    )
    .query( ({ input, ctx }) => {
        const user = ctx.db.prepare(`SELECT * FROM user_table WHERE email = ?`).get(input.email)

        const response : UserResponse = {
            message: "Successfully Added an User",
            success: true,
            payload: user

        }

        return {
            response
        }
    }),
    register: publicProcedure
    .input(
        z.object({
            email: z.string().email(),
            password: z.string(),
            first_name: z.string(),
            last_name: z.string(),
            organization_id: z.number()
        })
    )
    .query( ({ input, ctx }) => {
        let response : UserResponse = {
            message: "error occured before db transaction",
            success: false,
            payload: null
        }
        const newUser: User = {
            email: input.email,
            password: input.password,
            first_name: input.first_name,
            last_name: input.last_name,
            organization_id: input.organization_id
        }

        const insertUser = ctx.db.prepare(`
        INSERT INTO user_table (email, first_name, last_name, password, organization_id) VALUES (?, ?, ?, ?, ?)
        `).bind(newUser.email, newUser.first_name, newUser.last_name, newUser.password, newUser.organization_id)

        insertUser.run()

        const user = ctx.db.prepare(`SELECT * FROM user_table WHERE email = ?`).get(input.email)

        response = {
            message: "Successfully Added an User",
            success: true,
            payload: user

        }

        return {
            response
        }
    }),
    authenticate: publicProcedure
    .input(
        z.object({
            email: z.string().email(),
            password: z.string().min(10)
        })
    )
    .query( ({ input, ctx }) => {
        let response : UserResponse = {
            message: "error occured before db transaction",
            success: false,
            payload: null
        }
        const user = ctx.db.prepare(`SELECT * FROM user_table WHERE email = ?`).get(input.email)
        response = {
            message: "Successfully Added an User",
            success: true,
            payload: user

        }
        return {
            response
        }
    })
})