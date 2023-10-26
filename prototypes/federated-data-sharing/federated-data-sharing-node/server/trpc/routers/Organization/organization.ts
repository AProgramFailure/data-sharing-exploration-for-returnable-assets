import { z } from "zod";
import { publicProcedure, router } from "../../trpc";

type OrganizationResponse = {
    message: string,
    success: boolean,
    payload: Organization[] | Organization | null
}

type Organization = {
    id?: number,
    name: string,
    organization_type: string,
    location_id: number,
    order_id: number,
    user_id: number,
    security : "private" | "public" | "subscribe",
}

type ShallowOrganization = Omit<Organization,
    "location_id"
    | "order_id"
    | "user_id">

export const organizationRouter = router({
    getOrganizations: publicProcedure
    .query( ({ ctx }) => {
        const fetchInstitutions = ctx.db.prepare(`
        SELECT * FROM organization
        `)
        const organizations = fetchInstitutions.all()
        return {
            organizations
        }
    }),
    getSubscribedOrganizations: publicProcedure
    .input(
        z.object({
            user_id: z.number(),
            organization_id: z.number()

        })
    )
    .query( ({ input, ctx }) => {

        const query = ctx.db.prepare(`
            SELECT * FROM organization o
            INNER JOIN organization_node n ON o.organization_id = n.organization_id
            INNER JOIN node_subscribers ns ON n.node_id = ns.subscribed_node_id
            WHERE o.organization_id = ? AND ( o.security = 'public' OR o.security = 'subscribe' )

        `).bind(input.organization_id).all()

        const response : OrganizationResponse = {
            message: "Fetched all nodes subscbrided to input node",
            success: false,
            payload: query as Organization[]
        }
        return {
            response
        }
    }),
    addOrganization : publicProcedure
    .input(
        z.object({
            name: z.string(),
            organization_type: z.string(),
            security: z.literal("private").or(z.literal("subscribe")).or(z.literal("public"))
        })
    )
    .query( ({ input, ctx }) => {
        let response : OrganizationResponse = {
            message: "error occured before db transaction",
            success: false,
            payload: null
        }

        const newOrganization : ShallowOrganization = {
            name: input.name,
            organization_type: input.organization_type,
            security: input.security
        }

        const _insertOrganization = ctx.db.prepare(`
            INSERT INTO organization (name, organization_type, security) VALUES (?, ?, ?)
        `).run(newOrganization.name, newOrganization.organization_type, newOrganization.security)

        const getInsertedOrganization = ctx.db.prepare(`
            SELECT * FROM organization o WHERE o.name = '${newOrganization.name}'
        `).get()

        response = {
            message: "Successfully Added an Invenotry",
            success: true,
            payload: getInsertedOrganization as Organization
        }

        return {
            response
        }
    })

})