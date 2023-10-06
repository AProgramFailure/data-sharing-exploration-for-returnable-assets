import type { Location } from "../Location/Location"
import type { Privacy } from "../Privacy/Privacy"

export type Inventory = {
    id: string,
    itemType: string,
    quantity: number,
    location: Location,
} & Privacy