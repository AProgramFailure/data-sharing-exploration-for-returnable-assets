import { defineStore, storeToRefs } from "pinia";

import { useUserStore } from "../user/userStore";
import { type RemovableRef, useSessionStorage } from "@vueuse/core";

import type { Institution } from "../../types/Insittution/Institution";

export const useInstitutionStore = defineStore(
  "institutions",
  () => {
    const institutions: RemovableRef<Institution[]> = useSessionStorage<
      Institution[]
    >("institutions", [] as Institution[]);

    const userStore = useUserStore();
    const { user } = storeToRefs(userStore);

    async function awaitData() {
      const { data } = await useAsyncData<Institution[]>("dataname", () =>
        $fetch("127.0.0.1:8080/api/prod/institution", {
          method: "GET",

          headers: {
            "Content-Type": "application/json",
            Authentication: "Bearer " + user.value.token,
          },

          body: {
            type: "info",
            email: user.value.email,
          },
        })
      );

      console.log(data);

      if (data) {
        institutions.value = data.value;
      }
    }

    const getInstitution: ComputedRef<RemovableRef<Institution[]>> = computed(
      () => institutions
    );

    return {
      awaitData,
      getInstitution,
      institutions,
    };
  },
  {
    persist: false,
  }
);
