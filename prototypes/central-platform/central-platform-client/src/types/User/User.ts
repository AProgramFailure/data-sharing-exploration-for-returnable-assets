export type UserCredentials = {
    email: string,
    password: string
}

export type User = {
    id: string,
    firstname: string,
    lastname: string,
    institution: string,
    role : string[],
    token: string

} & UserCredentials
