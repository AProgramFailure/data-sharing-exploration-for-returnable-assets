import { defineStore } from "pinia";

import { type RemovableRef, useSessionStorage } from "@vueuse/core";

import type { Institution } from "../../types/Insittution/Institution";


export const useInstitutionStore = defineStore("institutions", () => {

    const institutions : RemovableRef<Institution[]> = useSessionStorage<Institution[]>("institutions", [] as Institution[])


    const getInstitution : ComputedRef<RemovableRef<Institution[]>> = computed(() => institutions)

    return {
        getInstitution
    }
}, {
    persist: false
})