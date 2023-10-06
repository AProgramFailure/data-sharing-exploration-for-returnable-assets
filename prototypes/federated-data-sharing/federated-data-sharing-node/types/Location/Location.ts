import type { Inventory } from "../Inventory/Inventory"
import type { Organization } from "../Organization/Organization"
import type { Privacy } from "../Privacy/Privacy"

export type Location = {
    id: string,
    name: string,
    address: string,
    latitude: string,
    longitude: string,
    organization: Organization,
    inventory: Inventory[]
} & Privacy