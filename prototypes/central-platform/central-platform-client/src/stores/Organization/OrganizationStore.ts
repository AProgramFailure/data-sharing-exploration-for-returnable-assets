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
      const { data } = await useAsyncData<Organization>("organizations", () => $fetch("http://127.0.0.1:8080/api/prod/organization", {
          method: "POST",
          headers: {
            "Content-Type": "application/json",
            Authorization: "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJtb2RAdHdlbnRlLmRldiIsImlhdCI6MTY5Njc5NTM0MywiZXhwIjoxNjk2ODgxNzQzfQ.JFgaBUOHQx0FGlaSgM59m5jlj-GZpJDCKaymkdnCYdw",
          },
          body: {
            email: "mod@twente.dev",
            type: "info",
          },
        })
      );

      if(data.value){
        organizations.value.push(data.value)
      }
      console.log(organizations)
    }

    return {
      getOrganizations,
      organizations,
      fetchOrganizations,
    };
  }
);
