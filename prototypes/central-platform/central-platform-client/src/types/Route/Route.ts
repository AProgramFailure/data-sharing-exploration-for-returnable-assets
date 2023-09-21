import type { Truck } from "../Truck/Truck"
import type { Location } from "../Location/Location"

export type Route = {
    locations: Location[],
    truck: Truck[]
    isFull: boolean,
    isContainingReturnable: boolean
}