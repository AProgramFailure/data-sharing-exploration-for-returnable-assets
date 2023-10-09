import type { Organization } from "../Organization/Organization"
import type { Location } from "../Location/Location"
import type { OrderItem } from "../OrderItem/OrderItem"
import type { Privacy } from "../Privacy/Privacy"

export type Order = {
    id: number,
    organization: Organization,
    sourceLocation: Location,
    destinationLocation: Location
    status: string,
    orderItems: OrderItem[]
} & Privacy