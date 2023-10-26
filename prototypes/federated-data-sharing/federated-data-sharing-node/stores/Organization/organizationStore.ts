import { defineStore } from "pinia"
import { useSessionStorage, type RemovableRef } from "@vueuse/core"
import { useToast } from "vue-toastification";

import { useRandomString } from "#imports";

import type { Organization } from "~/types/Organization/Organization";


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

    async function addDummy(){
        toast.info('Preparing dummy node')

        console.log()
        const dummy = await organizations.addOrganization.useQuery({
            name: useRandomString(10),
            organization_type: "brewery",
            security: "public"
        })
        toast.success("Dummy node successfully created")
    }

    return {
        getOrganizations, addSampleOrg, addDummy
    }
}, {
    persist: true
})