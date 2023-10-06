import type { Location } from "../Location/Location"
import type { Order } from "../Order/Order"
import type { Privacy } from "../Privacy/Privacy"
import type { User } from "../User/User"

export type Organization = {
    id: string,
    name: string,
    organizationType: string,
    locations: Location[],
    orders: Order[],
    users: User
} & Privacy