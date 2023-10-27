import { Organization } from "../Organization/Organization"

export type User = {
    user_id?: number,
    email: string,
    organization_id: number,
    name : string,
    password: string
}

export type BasicResponse = {
    message : string,
    success: boolean
}

export type UserResponse = {
    payload: User | null | unknown
} & BasicResponse

export type UserAuthenticationResponse = {
    payload: {
        user: User,
        organization: Organization
        organization_subscribers: Organization[]
    } | null
} & BasicResponse