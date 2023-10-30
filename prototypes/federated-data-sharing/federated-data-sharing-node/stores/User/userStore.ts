import { defineStore } from "pinia"
import { useToast } from "vue-toastification";
import { type RemovableRef, useSessionStorage } from "@vueuse/core"

import { useOrganizationStore } from "../Organization/organizationStore";

import type { MinifiedUser, User, UserCredentials } from "~/types/User/User";

export const useUserStore = defineStore("user", () =>{

    const { $trpcClient } = useNuxtApp();
    const toast = useToast()
    const organizationStore = useOrganizationStore();

    const { users } = $trpcClient
    const { getOrganizations } = organizationStore

    const user : RemovableRef<User> = useSessionStorage<User>("user", {} as User)

    const getUser : ComputedRef<RemovableRef<User>> = computed(() => user)

    async function register( user_details : MinifiedUser) {
        toast.info("Registering Instance.")
        const { data } = await users.register.useQuery({
            email: user_details.email,
            password: user_details.password,
            name: user_details.name,
            secret_key: user_details.secret_key
        })

        if(data.value?.response.payload?.organization){
            user.value = data.value?.response.payload?.user

            getOrganizations.value = []
            getOrganizations.value.push(data.value?.response.payload?.organization)
            getOrganizations.value.push(...data.value?.response.payload.organization_subscribers)
        }

        toast.success("Successfully Registered in the system!")
        navigateTo("/home")
    }

    async function authenticate( credentials : UserCredentials) {
        toast.info("Attempting to Authenticate.")
        const { data } = await users.authenticate.useQuery({
            email: credentials.email,
            password: credentials.password
        })

        user.value = data.value?.response.payload?.user
        toast.success("Successfully Authenticated!")
        navigateTo("/home")
    }


    return {
        getUser, register, authenticate
    }
}, {
    persist: true
})

