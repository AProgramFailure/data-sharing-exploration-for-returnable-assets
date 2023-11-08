import { OrganizationDTO } from "../Organization/Organization"

export type OrganizationAccessDTO = {
    id: string,
    organizationDTO: OrganizationDTO,
    allowedOrganizations: OrganizationDTO[]
}