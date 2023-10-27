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
            secret_key: "sdfsdfsdfsdfsd",
            users: [],
            orders: [],
            locations: [],
            security: 'public'
        })
    }

    async function addDummy( name: string, type: string, privacy: "public" | "private" | "subscribe" ){
        toast.info('Generating new Organization')

        const { data } = await organizations.addOrganization.useQuery({
            name: name,
            secret_key: useRandomString(20),
            organization_type: type,
            security: privacy
        })
        toast.success("Organization successfully Generated")

        toast.info(`Use code: ${data.value?.response.payload?.secret_key} to register`)
    }

    return {
        getOrganizations, addSampleOrg, addDummy
    }
}, {
    persist: true
})