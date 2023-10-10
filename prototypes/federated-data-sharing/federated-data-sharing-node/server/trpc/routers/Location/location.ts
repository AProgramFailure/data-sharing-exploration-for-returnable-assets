import { z } from "zod";
import { publicProcedure, router } from "../../trpc";

export const locationRouter = router({
    getLocations: publicProcedure
    .query( ({ ctx }) => {
        const fetchLocations = ctx.db.prepare(`
        SELECT * FROM location
        `)
        const locations = fetchLocations.all();
        return {
            locations
        }
    })
})