import { defineStore } from "pinia"


export const useUserStore = defineStore("user", () => {

},{
    persist: {
        storage: sessionStorage
    }
})