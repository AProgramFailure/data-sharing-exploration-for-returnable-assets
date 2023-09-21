import { Institution } from "../Insittution/Institution"
import { Item } from "../Item/Item"
import { Route } from "../Route/Route"

export type Order = {
    amount : Item[],
    institution: Institution,
    route: Route
}