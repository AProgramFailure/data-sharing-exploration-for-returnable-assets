import { Organization } from "../Organization/Organization";
import { Privacy } from "../Privacy/Privacy";

export type FederatedNode = {
    id: string,
    secret_key: string,
    subscribers: Node[],
    owner: Organization,
} & Privacy