import { z } from "zod";
import { publicProcedure, router } from "../../trpc";

import type {Organization, OrganizationResponse, BatchOrganizationResponse, ShallowOrganization} from "../../../types/Organization/Organization"

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

        `).bind(input.organization_id).all() as Organization[]

        const response : BatchOrganizationResponse = {
            message: "Fetched all nodes subscbrided to input node",
            success: false,
            payload: query
        }
        return {
            response
        }
    }),
    addOrganization : publicProcedure
    .input(
        z.object({
            name: z.string(),
            secret_key: z.string().min(20),
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
            security: input.security,
            secret_key: input.secret_key
        }

        const insert_organization = ctx.db.prepare(`
            INSERT INTO organization (name, secret_key, organization_type, security) VALUES (?, ?, ?, ?)
        `).run(newOrganization.name, newOrganization.secret_key, newOrganization.organization_type, newOrganization.security)

        const getInsertedOrganization = ctx.db.prepare(`
            SELECT * FROM organization o WHERE o.name = '${newOrganization.name}'
        `).get() as Organization

        const insert_node = ctx.db.prepare(`
            INSERT INTO federated_node ( name, security ) VALUES ( ?, ? )
        `).run( newOrganization.name, newOrganization.security)

        const _link_node_to_organiation = ctx.db.prepare(`
            INSERT INTO organization_node ( node_id, organization_id ) VALUES ( ?, ? )
        `).run( insert_node.lastInsertRowid, insert_organization.lastInsertRowid)

        response = {
            message: "Successfully Added Node to Network",
            success: true,
            payload: getInsertedOrganization
        }

        return {
            response
        }
    })

})