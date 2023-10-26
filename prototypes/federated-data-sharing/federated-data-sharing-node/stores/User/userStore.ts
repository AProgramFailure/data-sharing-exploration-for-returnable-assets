import { defineStore } from "pinia"
import { useToast } from "vue-toastification";
import { type RemovableRef, useSessionStorage } from "@vueuse/core"

import type { MinifiedUser, User, UserCredentials } from "~/types/User/User";

export const useUserStore = defineStore("user", () =>{

    const { $trpcClient } = useNuxtApp();
    const toast = useToast()

    const { users } = $trpcClient

    const user : RemovableRef<User> = useSessionStorage<User>("user", {} as User)

    const getUser : ComputedRef<RemovableRef<User>> = computed(() => user)

    async function register( user_details : MinifiedUser) {
        toast.info("Registering Instance.")
        const { data } = await users.register.useQuery({
            email: user_details.email,
            password: user_details.password,
            first_name: user_details.first_name,
            last_name: user_details.last_name,
            organization_id: user_details.organization_id
        })
        user.value = data.value?.response.payload
        user.value.password = "";
        toast.success("Successfully Registered in the system!")
        navigateTo("/home")
    }

    async function authenticate( credentials : UserCredentials) {
        toast.info("Attempting to Authenticate.")
        const { data } = await users.authenticate.useQuery({
            email: credentials.email,
            password: credentials.password
        })

        user.value = data.value?.response.payload
        user.value.password = "";
        toast.success("Successfully Authenticated!")
        navigateTo("/home")
    }


    return {
        getUser, register, authenticate
    }
}, {
    persist: true
})

