import type { Location } from "../Location/Location"
import type { Order } from "../Order/Order"
import type { Privacy } from "../Privacy/Privacy"

export type Organization = {
    id: number,
    name: string,
    organizationType: string,
    locations: Location[],
    secret_key: string,
    orders: Order[],
} & Privacy