import { defineStore } from "pinia"
import { type RemovableRef, useSessionStorage } from "@vueuse/core"


export const useUserStore = defineStore("user", () =>{

    const { $trpcClient } = useNuxtApp();


    async function fetchUser() : Promise<void> {
        const { data } = await $trpcClient.items.getItems.useQuery({
            email: "daniel@gmail.com"
        })
    }

    return {

    }
}, {
    persist: true
})

