import type { Privacy } from "../Privacy/Privacy"

export type Inventory = {
    invenotry_id: number,
    invenotry_name: string,
    item_type: string,
    quantity: number,
    location_id: number,
} & Privacy