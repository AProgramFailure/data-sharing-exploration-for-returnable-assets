import type { Order } from "../Order/Order"
import type { Privacy } from "../Privacy/Privacy"

export type OrderItem = {
    id: number,
    itemType: string,
    requestedQuantity: number,
    actualQuantity: number
    order: Order
} & Privacy