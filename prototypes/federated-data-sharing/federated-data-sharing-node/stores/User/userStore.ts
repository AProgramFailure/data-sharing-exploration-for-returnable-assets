import { defineStore } from "pinia"
import { type RemovableRef, useSessionStorage } from "@vueuse/core"

import type { User } from "~/types/User/User";

export const useUserStore = defineStore("user", () =>{

    const { $trpcClient } = useNuxtApp();

    const user : RemovableRef<User> = useSessionStorage<User>("user", {} as User)

    const getUser : ComputedRef<RemovableRef<User>> = computed(() => user)

    async function fetchUser() : Promise<void> {
    }

    return {
        getUser, fetchUser
    }
}, {
    persist: true
})

