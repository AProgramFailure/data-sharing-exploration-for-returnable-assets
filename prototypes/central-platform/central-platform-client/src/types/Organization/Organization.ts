import type { Location } from "../Location/Location"

export type Organization = {
    id: string,
    name: string,
    organizationType: string,
    locations: Location[]
}