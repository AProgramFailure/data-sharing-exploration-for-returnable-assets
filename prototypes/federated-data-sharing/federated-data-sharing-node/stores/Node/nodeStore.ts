import { defineStore } from "pinia"
import { useSessionStorage, type RemovableRef } from "@vueuse/core"
import { useToast } from "vue-toastification";

import type { FederatedNode } from "~/types/FederatedNode/FederatedNode";

import { useInventoryStore } from "../Inventory/inventoryStore";
import { useLocationStore } from "../Location/locationStore";
import { useOrderSotre } from "../Order/orderStore";
import { useOrganizationStore } from "../Organization/organizationStore";

export const useFederatedNodeStore = defineStore("nodes", () => {

    const { $trpcClient } = useNuxtApp();
    const toast = useToast();

    const inventoryStore = useInventoryStore();
    const locationStore = useLocationStore();
    const orderStore = useOrderSotre();
    const organizationStore = useOrganizationStore()

    const federatedNodes : RemovableRef<FederatedNode[]> =
        useSessionStorage<FederatedNode[]>("federatedNodes", [] as FederatedNode[])

    const getFederatedNotes : ComputedRef<RemovableRef<FederatedNode[]>> = computed(() => federatedNodes)

    return {
        getFederatedNotes
    }
}, {
    persist: true
})