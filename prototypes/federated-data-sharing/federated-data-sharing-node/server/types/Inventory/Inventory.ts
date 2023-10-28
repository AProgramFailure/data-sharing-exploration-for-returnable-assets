export type InventoryResponse = {
    message: string,
    success: boolean,
    payload: Inventory[] | Inventory | null
}

export type DBInventory = {
    invenotry_id: number,
    inventory_name: string,
    item_type: string,
    quantity: number,
    security : "private" | "public" | "subscribe",
    location_id: number
}

export type Inventory = DBInventory