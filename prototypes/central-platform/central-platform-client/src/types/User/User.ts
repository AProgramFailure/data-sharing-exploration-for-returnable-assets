export type UserCredentials = {
    email: string,
    password: string
}

export type User = {
    id: string,
    firstname: string,
    lastname: string,
    institutionId: string,
    role : string[],
    token: string

} & UserCredentials
