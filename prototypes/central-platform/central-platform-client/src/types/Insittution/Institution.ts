import type { Location } from "../Location/Location"

export type Institution = {
    id: string,
    name: string,
    locations: Location[]
}