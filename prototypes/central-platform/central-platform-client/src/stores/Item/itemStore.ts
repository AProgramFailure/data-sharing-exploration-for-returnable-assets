import { defineStore } from "pinia"
import { useSessionStorage, type RemovableRef} from "@vueuse/core"

import type { Item } from "~/types/Item/Item"


export const useItemStore = defineStore("items", () => {

    // ref -> state -> data
    const items : RemovableRef<Item[]> = useSessionStorage<Item[]>("items", [] as Item[])

    // computed -> getters -> access information

    const getItems : ComputedRef<RemovableRef<Item[]>> = computed(() => items)

    // function -> mutattion -> do some kind of logic
    async function fetchItems(){
        const { data } = await useAsyncData<Item[]>("items", () => $fetch("localhost:8080/api/prod/items", {
            body: {
                email: "",
                roles: [],
                type: "info"
            }
        }))

        items.value = data.value

    }

    return {
        getItems, fetchItems
    }

}, {
    persist: true
})