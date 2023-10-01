import { defineStore } from "pinia";

import { type RemovableRef, useSessionStorage } from "@vueuse/core";

import type { User, UserCredentials } from "~/types/User/User";

export const useUserStore = defineStore(
  "user",
  () => {
    const user: RemovableRef<User> = useSessionStorage<User>(
      "user",
      {} as User
    );

    const getUser = computed(() => user);

    async function authenticate(credentials: UserCredentials): Promise<void> {
      const { data } = await useAsyncData<{
        access_token: string;
        refresh_token: string;
        user: User;
      }>("user", () =>
        $fetch("127.0.0.1:8080/api/v1/auth/authenticate", {
          method: "POST",
          headers: {
            "Content-Type": "application/json",
          },
          body: credentials,
        })
      );

      if (data) {
        if (data.value?.access_token) {
          user.value.token = data.value?.access_token;
        }
        user.value = data.value?.user;
      }
    }

    return {
      getUser,
      authenticate,
      user,
    };
  },
  {
    persist: false,
  }
);
