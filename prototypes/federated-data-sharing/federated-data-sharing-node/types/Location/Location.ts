import type { Inventory } from "../Inventory/Inventory"
import type { Privacy } from "../Privacy/Privacy"

export type Location = {
    id: number,
    name: string,
    address: string,
    latitude: string,
    longitude: string,
    inventory: Inventory[]
} & Privacy