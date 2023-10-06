import { defineStore } from "pinia"
import { useSessionStorage, type RemovableRef } from "@vueuse/core"
import { useToast } from "vue-toastification";

import { Organization } from "~/types/Organization/Organization";

export const useOrganizationStore = defineStore("organization", () => {
    const { $trpcClient } = useNuxtApp();
    const toast = useToast();

    const organizations : RemovableRef<Organization[]> =
        useSessionStorage<Organization[]>("organization", [] as Organization[])

    const getOrganizations: ComputedRef<RemovableRef<Organization[]>> = computed(() => organizations)


    return {
        getOrganizations
    }
}, {
    persist: true
})