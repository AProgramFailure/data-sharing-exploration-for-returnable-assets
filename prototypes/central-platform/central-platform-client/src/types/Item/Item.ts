export type Item = {
    id: string
    name: string,
    type: "CRATE" | "BOTTLE" | "PALETTE" | "KEG",
    capacity: number,
    barcode: string
}