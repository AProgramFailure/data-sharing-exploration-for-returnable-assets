import { Order } from "../Order/Order"
import { Location } from "../Location/Location"

export type OrganizationResponse = {
    message: string,
    success: boolean,
    payload: Organization | null
}

export type BatchOrganizationResponse = {
    message: string,
    success: boolean,
    payload: Organization[] | null
}

export type DBOrganization = {
    organization_id: number,
    name: string,
    organization_type: string,
    secret_key: string,
    security : string,
}
export type Organization = DBOrganization & {
    locations: Location[],
    orders: Order[]
}


export type ShallowOrganization = Omit<DBOrganization,"organization_id">
