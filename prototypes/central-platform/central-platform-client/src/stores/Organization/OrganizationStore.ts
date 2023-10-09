import { defineStore } from "pinia";
import { useSessionStorage, type RemovableRef } from "@vueuse/core";

import type { Organization } from "~/types/Organization/Organization";

export const useOrganizationStore = defineStore(
  "organizations",
  () => {
    // ref -> state -> data
    const organizations: RemovableRef<Organization[]> = useSessionStorage<
      Organization[]
    >("organizations", [] as Organization[]);

    // computed -> getters -> access information
    const getOrganizations: ComputedRef<RemovableRef<Organization[]>> =
      computed(() => organizations);

    // function -> mutattion -> do some kind of logic
    async function fetchOrganizations() {
      const { data } = await useAsyncData<Organization[]>("organizations", () => $fetch("http://localhost:8080/api/prod/organization", {
          method: "POST",
          headers: {
            "Content-Type": "application/json",
            Authorization: "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJkc2ZhZHNmYWRzZiIsImlhdCI6MTY5Njg1MjI3OCwiZXhwIjoxNjk2OTM4Njc4fQ.5UDAWg10R-aFPx5nBCZU5jg2PNZVerq7t9nKD_bjiSw",
          },
          body: {
            email: "dsfadsfadsf",
            type: "info",
          },
        })
      );

      if(data.value){
        organizations.value = data.value
      }
    }

    return {
      getOrganizations,
      organizations,
      fetchOrganizations,
    };
  }
);
