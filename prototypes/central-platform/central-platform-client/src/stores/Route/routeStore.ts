import { defineStore } from "pinia";

import { type RemovableRef, useSessionStorage } from "@vueuse/core"

import type { Route } from "../../types/Route/Route"

export const useRouteStore = defineStore("routes", () => {

    const routes : RemovableRef<Route[]> = useSessionStorage<Route[]>("routes", [] as Route[])


    const getRoutes: ComputedRef<RemovableRef<Route[]>> = computed( () => routes);

    return {
        getRoutes
    }
}, {
    persist: false
})