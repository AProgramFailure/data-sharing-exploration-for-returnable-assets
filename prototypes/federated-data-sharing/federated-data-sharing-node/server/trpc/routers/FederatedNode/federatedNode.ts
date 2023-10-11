import { z } from 'zod';
import { publicProcedure, router } from '../../trpc';

type FederatedNodeResponse = {
    message: string,
    success: boolean,
    payload: FederatedNode[] | null
}

type FederatedNode = {
    node_id?: number,
    first_name: string,
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

    addNode : publicProcedure
    .input(
        z.object({
            first_name: z.string(),
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
        SELECT * FROM organization WHERE organization_id = ${input.owner}
        `)
        const owner_organization = fetchOrganization.all()

        if(owner_organization){
            const newNode : FederatedNode = {
                first_name: input.first_name,
                owner: input.owner,
                security: input.security
            }
            const insertNode = ctx.db.prepare<FederatedNode>(`
                INSTER INTO federated_node (first_name, owner, security) VALUES (:first_name, :owner, :security);
            `)

            insertNode.run(newNode);


            const getInsertedNode = ctx.db.prepare(`
            SELECT * FROM federated_node WHERE first_name = ${newNode.first_name}
            `)

            const node = getInsertedNode.all()

            response = {
                message: "Successfully Added New Node",
                success: true,
                payload: node as FederatedNode[]
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