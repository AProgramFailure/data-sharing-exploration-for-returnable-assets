export type Item = {
    id: string
    name: string,
    type: "create" | "bottle" | "pallete" | "keg",
    capacity: number,
    barcode: string
}