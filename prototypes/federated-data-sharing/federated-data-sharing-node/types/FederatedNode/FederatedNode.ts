import { Privacy } from "../Privacy/Privacy";

export type Node = {
    id: string,
    secret_key: string,
    subscribers: Node[],
} & Privacy