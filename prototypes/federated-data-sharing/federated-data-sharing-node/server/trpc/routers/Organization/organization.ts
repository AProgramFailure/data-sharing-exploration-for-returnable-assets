import { z } from "zod"
import { publicProcedure, router } from "../../trpc";

export const organizationRouter = router({
    getInstitutions: publicProcedure
    .query( ({ input, ctx }) => {
        const fetchInstitutions = ctx.db.prepare(`
        SELECT * FROM organization
        `)
        const organizations = fetchInstitutions.all()
        return {
            organizations
        }
    })
})