import { defineStore } from "pinia"
import { useSessionStorage, type RemovableRef } from "@vueuse/core"
import { useToast } from "vue-toastification";

import type { Order } from "~/types/Order/Order";

export const useOrderSotre = defineStore("order", () => {

    const { $trpcClient } = useNuxtApp();
    const toast = useToast();

    const orders : RemovableRef<Order[]> =
        useSessionStorage<Order[]>("orders", [] as Order[])

    const getOrders : ComputedRef<RemovableRef<Order[]>> = computed(() => orders)

    return {
        getOrders
    }
}, {
    persist: true
})