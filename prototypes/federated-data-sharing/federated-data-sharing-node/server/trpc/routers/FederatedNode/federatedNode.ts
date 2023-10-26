import { z } from 'zod';
import { publicProcedure, router } from '../../trpc';

type FederatedNodeResponse = {
    message: string,
    success: boolean,
    payload: FederatedNode | null | unknown
}

type FederatedNode = {
    node_id?: number,
    name: string,
    owner: number,
    subscriber_id?: FederatedNode[],
    security : "private" | "public" | "subscribe",
}


export const federatedNodeRouter = router({
    getNodes : publicProcedure
    .query( ({ ctx }) => {
        const fetchNodes = ctx.db.prepare(`
        SELECT * FROM federated_node
        `)
        const nodes = fetchNodes.all()
        return {
            nodes
        }
    }),
    getNode: publicProcedure
    .input(
        z.object({
            name: z.string()
        })

    )
    .query( ({ input, ctx }) => {
        let response : FederatedNodeResponse = {
            message: "error occured before db transaction",
            success: false,
            payload: null
        };

        const node = ctx.db.prepare(`SELECT * FROM federated_node WHERE name = ?`).get(input.name)

        response = {
            message: "Successfully Fetched Node",
            success: true,
            payload: node

        }

        return {
            response
        }
    }),

    subscribe : publicProcedure
    .input(
        z.object({
            node_id: z.number(),
            name: z.string()
        })
    )
    .query( ({ input, ctx }) => {

        const subscribe = ctx.db.prepare(`UPDATE TABLE federated_node
        SET subscriber_id = ?
        WHERE name = ?
        ORDER BY name
        LIMIT 1
        `).bind(input.node_id, input.name)

        subscribe.run()

        const response : FederatedNodeResponse = {
            message: "Successfully Subscribed to Node",
            success: false,
            payload: null
        };
        return {
            response
        }
    }),

    addNode : publicProcedure
    .input(
        z.object({
            name: z.string(),
            owner: z.number().positive(),
            security: z.literal("private").or(z.literal("subscribe")).or(z.literal("public"))
        })
    )
    .query( ({ input, ctx }) => {
        let response : FederatedNodeResponse = {
            message: "error occured before db transaction",
            success: false,
            payload: null
        };

        const fetchOrganization = ctx.db.prepare(`
        SELECT * FROM federated_node WHERE name = ${input.name}
        `)
        const owner_organization = fetchOrganization.all()

        if(owner_organization){
            const newNode : FederatedNode = {
                name: input.name,
                owner: input.owner,
                security: input.security
            }
            const insertNode = ctx.db.prepare(`
                INSERT INTO federated_node (name, owner, security) VALUES (?, ?, ?)
            `).bind(newNode.name, newNode.owner, newNode.security)

            insertNode.run(newNode);


            const insertedNode = ctx.db.prepare(`SELECT * FROM federated_node WHERE name = ?`).get(input.name)

            response = {
                message: "Successfully Added New Node",
                success: true,
                payload: insertedNode
            }
        }
        else {
            response =  {
                message: "organization note found",
                success: false,
                payload: null
            }
        }

        return {
            response
        }
    })
})