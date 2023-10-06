import { defineStore  } from "pinia";
import { useSessionStorage, type RemovableRef } from "@vueuse/core";
import { useToast } from "vue-toastification";

import type { Location } from "~/types/Location/Location";

export const useLocationStore = defineStore("location", () => {
    const { $trpcClient } = useNuxtApp();
    const toast = useToast();

    const locations : RemovableRef<Location[]> =
        useSessionStorage<Location[]>("locations", [] as Location[])

    const getLocations : ComputedRef<RemovableRef<Location[]>> = computed(() => locations)

    return {
        getLocations
    }
}, {
    persist: true
})