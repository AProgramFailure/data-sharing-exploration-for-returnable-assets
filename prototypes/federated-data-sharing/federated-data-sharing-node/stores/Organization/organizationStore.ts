import { defineStore } from "pinia"
import { useSessionStorage, type RemovableRef } from "@vueuse/core"
import { useToast } from "vue-toastification";

import { Organization } from "~/types/Organization/Organization";

export const useOrganizationStore = defineStore("organization", () => {
    const { $trpcClient } = useNuxtApp();
    const { organizations } =  $trpcClient
    const toast = useToast();

    const client_organizations : RemovableRef<Organization[]> =
        useSessionStorage<Organization[]>("organization", [] as Organization[])

    const getOrganizations: ComputedRef<RemovableRef<Organization[]>> = computed(() => client_organizations)


    function addSampleOrg() : void {
        for(let i = 0 ; i < 10; i++)
        client_organizations.value.push({
            id: 1,
            name: `Jumbo ${i}`,
            organizationType: "brewery",
            users: [],
            orders: [],
            locations: [],
            security: 'public'
        })
    }

    return {
        getOrganizations, addSampleOrg
    }
}, {
    persist: true
})