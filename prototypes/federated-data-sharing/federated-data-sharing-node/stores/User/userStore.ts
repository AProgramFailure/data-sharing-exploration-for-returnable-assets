import { defineStore } from "pinia"
import { type RemovableRef, useSessionStorage } from "@vueuse/core"

import type { MinifiedUser, User, UserCredentials } from "~/types/User/User";

export const useUserStore = defineStore("user", () =>{

    const { $trpcClient } = useNuxtApp();
    const { users } = $trpcClient

    const user : RemovableRef<User> = useSessionStorage<User>("user", {} as User)

    const getUser : ComputedRef<RemovableRef<User>> = computed(() => user)

    async function register( user_details : MinifiedUser) {
        const { data } = await users.register.useQuery({
            email: user_details.email,
            password: user_details.password,
            first_name: user_details.first_name,
            last_name: user_details.last_name
        })

        user.value = data.value?.response.payload
        user.value.password = "";
        navigateTo("/home")
    }

    async function authenticate( credentials : UserCredentials) {
        const { data } = await users.authenticate.useQuery({
            email: credentials.email,
            password: credentials.password
        })

        user.value = data.value?.response.payload
        user.value.password = "";
        navigateTo("/home")
    }


    return {
        getUser, register, authenticate
    }
}, {
    persist: true
})

