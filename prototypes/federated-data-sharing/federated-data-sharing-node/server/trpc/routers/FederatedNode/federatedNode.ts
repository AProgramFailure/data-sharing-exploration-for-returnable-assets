import { z } from 'zod';
import { publicProcedure, router } from '../../trpc';

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
    })
})