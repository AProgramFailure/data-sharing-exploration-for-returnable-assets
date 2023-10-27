import { z } from "zod";
import { publicProcedure, router } from "../../trpc";

import type { UserResponse, User, UserAuthenticationResponse } from "../../../types/User/User";
import type { Organization } from "../../../types/Organization/Organization"

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
            name: z.string(),
            secret_key: z.string(),
        })
    )
    .query( ({ input, ctx }) => {
        let response : UserAuthenticationResponse = {
            message: "error occured before db transaction",
            success: false,
            payload: null
        }

        const fetchOrganization = ctx.db.prepare(`
            SELECT * FROM organization o WHERE o.secret_key = '${input.secret_key}'
        `).get() as Organization

        const name = input.name.split(" ")

        let newUser: User;

        if( name.length == 1){
            newUser = {
                email: input.email,
                password: input.password,
                name: input.name,
                organization_id: fetchOrganization.organization_id
            }
        }
        else {
            newUser = {
                email: input.email,
                password: input.password,
                name: ` ${name[0]} ${name[name.length - 1]}`,
                organization_id: fetchOrganization.organization_id
            }
        }


        const insertUser = ctx.db.prepare(`
        INSERT INTO user_table (email, name, password, organization_id) VALUES ( ?, ?, ?, ? )
        `).bind(newUser.email, newUser.name, newUser.password, newUser.organization_id).run()


        const subscribed_organiations = ctx.db.prepare(`
        SELECT * FROM organization o
        INNER JOIN organization_node n ON o.organization_id = n.organization_id
        INNER JOIN node_subscribers ns ON n.node_id = ns.subscribed_node_id
        WHERE o.organization_id = ? AND ( o.security = 'public' OR o.security = 'subscribe' )
        `).bind(fetchOrganization.organization_id).all() as Organization[]

        const user = ctx.db.prepare(`SELECT * FROM user_table WHERE email = ?`).get(input.email) as User

        response = {
            message: "Successfully Added an User",
            success: true,
            payload: {
                user: user,
                organization: fetchOrganization,
                organization_subscribers: subscribed_organiations
            }

        }

        return {
            response
        }
    }),
    authenticate: publicProcedure
    .input(
        z.object({
            email: z.string().email(),
            password: z.string()
        })
    )
    .query( ({ input, ctx }) => {
        let response : UserAuthenticationResponse = {
            message: "error occured before db transaction",
            success: false,
            payload: null
        }
        const user = ctx.db.prepare(`SELECT * FROM user_table WHERE email = ?`).get(input.email) as User

        const fetchOrganization = ctx.db.prepare(`
            SELECT * FROM organization o WHERE o.organization_id= '${user.user_id}'
        `).get() as Organization

        const subscribed_organiations = ctx.db.prepare(`
            SELECT * FROM organization o
            INNER JOIN organization_node n ON o.organization_id = n.organization_id
            INNER JOIN node_subscribers ns ON n.node_id = ns.subscribed_node_id
            WHERE o.organization_id = ? AND ( o.security = 'public' OR o.security = 'subscribe' )
        `).bind(fetchOrganization.organization_id).all() as Organization[]


        response = {
            message: "Successfully Added an User",
            success: true,
            payload: {
                user: user,
                organization: fetchOrganization,
                organization_subscribers: subscribed_organiations
            }

        }
        return {
            response
        }
    })
})