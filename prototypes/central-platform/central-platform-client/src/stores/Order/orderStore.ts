import { defineStore } from "pinia";

import { useSessionStorage, type RemovableRef } from "@vueuse/core"

import type { Order } from "../..//types/Order/Order";

export const useOrderStore = defineStore("orders", () => {

    const orders : RemovableRef<Order[]>  = useSessionStorage<Order[]>("orders ", [] as Order[])


    const getOrders : ComputedRef<RemovableRef<Order[]>> = computed(() => orders)


    return {
        getOrders
    }
}, {
    persist: false
})