import { defineStore } from "pinia";

import { type RemovableRef, useSessionStorage } from "@vueuse/core"

import type { Truck } from "../../types/Truck/Truck";

export const useTruckStore = defineStore("trucks", () => {

    const trucks : RemovableRef<Truck[]> = useSessionStorage<Truck[]>("trucks", [] as Truck[])


    const getTrucks : ComputedRef<RemovableRef<Truck[]>> = computed(() => trucks)

    return {
        getTrucks
    }
}, {
    persist:false
})