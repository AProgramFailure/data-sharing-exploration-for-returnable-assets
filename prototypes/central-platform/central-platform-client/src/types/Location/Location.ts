import type { Institution } from "../Insittution/Institution"
import { Item } from "../Item/Item"

export type Location = {
    address: string,
    institution: Institution
    latitude: string,
    longitude: string,
    emptyItems: Item[]
}