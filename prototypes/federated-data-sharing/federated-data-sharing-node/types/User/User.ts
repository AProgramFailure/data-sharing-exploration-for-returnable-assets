import { Organization } from "../Organization/Organization"

export type User = {
    user_id: number,
    email: string,
    name: string,
    organization_id: number
}

export type MinifiedUser = Omit<
    User,
     "user_id"
     | "organization_id"
> & {
    secret_key : string,
    password: string
}

export type UserCredentials = Omit<
    MinifiedUser,
    "first_name"
    | "last_name"
    | "organization_id"
> & {
    secret_key : string
}

export type UserAuthResponse =  {
    user: User
    organization: Organization
}