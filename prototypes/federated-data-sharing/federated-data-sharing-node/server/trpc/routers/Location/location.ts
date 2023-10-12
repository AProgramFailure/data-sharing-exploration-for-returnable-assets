import { z } from "zod";
import { publicProcedure, router } from "../../trpc";

type LocationResponse = {
    message: string,
    success: boolean,
    payload: Location[] | null
}

type Location = {
    id?: number,
    name: string,
    address: string,
    latitude: string,
    longitude: string,
    security : "private" | "public" | "subscribe",
    inventory_id?: number
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
    addLocation: publicProcedure
    .input(
        z.object({
            name: z.string(),
            address: z.string(),
            latitude: z.string(),
            longitude: z.string(),
            security: z.literal("private").or(z.literal("subscribe")).or(z.literal("public")),
            inventory_id: z.number()
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
            security: input.security
        }

        const insertLocation = ctx.db.prepare<Location>(`
        INSERT INTO invenotry (name, address, latitude, longitude, security) VALUES (:name, :address, :latitude, :longitude, :security );
        `)

        insertLocation.run(newLocation)

        const getInsertedLocation = ctx.db.prepare(`
        SELECT * FROM location WHERE name = ${newLocation.name}
        `)

        const location = getInsertedLocation.all();

        response = {
            message: "Successfully Added a Location",
            success: true,
            payload: location as Location[]
        }

        return {
            response
        }
    })
})