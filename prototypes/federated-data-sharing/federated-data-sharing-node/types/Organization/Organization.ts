import { Location } from "../Location/Location"
import { Order } from "../Order/Order"
import { Privacy } from "../Privacy/Privacy"

export type Organization = {
    id: string,
    name: string,
    organizationType: string,
    locations: Location[],
    orders: Order[]
} & Privacy