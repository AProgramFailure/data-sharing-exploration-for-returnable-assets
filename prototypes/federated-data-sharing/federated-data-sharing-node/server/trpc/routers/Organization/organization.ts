import { z } from "zod";
import { publicProcedure, router } from "../../trpc";

type OrganizationResponse = {
    message: string,
    success: boolean,
    payload: Organization[] | null
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
    .query( ({ input, ctx }) => {
        const fetchInstitutions = ctx.db.prepare(`
        SELECT * FROM organization
        `)
        const organizations = fetchInstitutions.all()
        return {
            organizations
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

        const insertOrganizationy = ctx.db.prepare<ShallowOrganization>(`
                INSERT INTO invenotry (name, organization_type, security) VALUES (:name, :organization_type, :security );
        `)

        insertOrganizationy.run(newOrganization)

        const getInsertedOrganization = ctx.db.prepare(`
            SELECT * FROM inventory WHERE inventory_name = ${newOrganization.name}
        `)

        const organization = getInsertedOrganization.all();

        response = {
            message: "Successfully Added an Invenotry",
            success: true,
            payload: organization as Organization[]
        }

        return {
            response
        }
    })

})