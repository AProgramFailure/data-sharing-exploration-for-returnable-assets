import { Organization } from "../Organization/Organization"

export type User = {
    id: string,
    access_token: string,
    refresh_token: string,
    email: string,
    first_name: string,
    last_name: string,
    organization: Organization
}