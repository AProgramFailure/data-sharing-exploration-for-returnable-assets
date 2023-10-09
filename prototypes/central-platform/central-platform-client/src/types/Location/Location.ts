import { Inventory } from "../Inventory/Inventory"

export type Location = {
    address: string,
    latitude: string,
    longitude: string,
    inventory: Inventory[]
    sourceOrders: []
    destinationOrders: []
}