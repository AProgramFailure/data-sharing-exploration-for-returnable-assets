import type { Order } from "../Order/Order"
import { Privacy } from "../Privacy/Privacy"

export type OrderItem = {
    id: string,
    itemType: string,
    requestedQuantity: number,
    actualQuantity: number
    order: Order
} & Privacy