import { User } from "../User/User"

export type UserOrganizationApplication = {
    id: string,
    user: User
    organizationId: string
    status: string
    createdAt: string
    updatedAt: string
}

