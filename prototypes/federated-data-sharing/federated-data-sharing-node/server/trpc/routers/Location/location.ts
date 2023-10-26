import { z } from "zod";
import { publicProcedure, router } from "../../trpc";

type LocationResponse = {
    message: string,
    success: boolean,
    payload: Location[] | Location | null
}

type Location = {
    id?: number,
    name: string,
    address: string,
    latitude: string,
    longitude: string,
    security : "private" | "public" | "subscribe",
    organization_id?: number
}


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
    }),
    getLocationsByOrganizationId: publicProcedure
    .input(
        z.object({
            organiation_id: z.number(),
            user_id: z.number()
        })
    )
    .query( ({ input, ctx }) => {

        const locations = ctx.db.prepare(`
            SELECT * FROM inventory i
            INNER JOIN organization o ON i.inventory_id = o.organization_id
            INNER JOIN user_table ut ON u.organization_id = o.prganization_id
            WHERE o.organization_id = ? AND ut.user_id = ?
        `).bind(input.organiation_id, input.user_id).all();


        const response : LocationResponse = {
            message: "Fecthed all locations for an organization",
            success: true,
            payload: locations as Location[]
        }
        return {
            response
        }
    }),
    addLocation: publicProcedure
    .input(
        z.object({
            name: z.string(),
            address: z.string(),
            latitude: z.string(),
            longitude: z.string(),
            security: z.literal("private").or(z.literal("subscribe")).or(z.literal("public")),
            organization_id: z.number()
        })
    )
    .query( ({ input, ctx }) => {
        let response : LocationResponse = {
            message: "error occured before db transaction",
            success: false,
            payload: null
        }

        const newLocation : Location = {
            name: input.name,
            address: input.address,
            latitude: input.latitude,
            longitude: input.longitude,
            security: input.security,
            organization_id: input.organization_id
        }

        const _insertLocation = ctx.db.prepare(`
        INSERT INTO location (name, address, latitude, longitude, security, organization_id) VALUES (?, ?, ?, ?, ?, ?);
        `).bind(newLocation.name, newLocation.address, newLocation.latitude, newLocation.longitude, newLocation.security, newLocation.organization_id).run()

        const getInsertedLocation = ctx.db.prepare(`
        SELECT * FROM location WHERE name = ${newLocation.name}
        `)

        const location = getInsertedLocation.get();

        response = {
            message: "Successfully Added a Location",
            success: true,
            payload: location as Location
        }

        return {
            response
        }
    })
})