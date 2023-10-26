export type User = {
    user_id: number,
    password: string,
    email: string,
    first_name: string,
    last_name: string,
    organization_id: number
}

export type MinifiedUser = Omit<User, "user_id">

export type UserCredentials = Omit<MinifiedUser, "first_name" | "last_name" | "organization_id">