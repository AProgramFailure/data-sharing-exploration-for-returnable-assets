import { defineStore } from "pinia"
import { useSessionStorage, type RemovableRef } from "@vueuse/core"
import { useToast } from "vue-toastification";

import type { Inventory } from "~/types/Inventory/Inventory"

export const useInventoryStore = defineStore("inventory", () => {

    const { $trpcClient } = useNuxtApp();
    const toast = useToast();

    const inventories : RemovableRef<Inventory[]> =
        useSessionStorage<Inventory[]>("inventories", [] as Inventory[])

    const getInventories : ComputedRef<RemovableRef<Inventory[]>> = computed(() => inventories)

    return {
        getInventories
    }
}, {
    persist: true
})