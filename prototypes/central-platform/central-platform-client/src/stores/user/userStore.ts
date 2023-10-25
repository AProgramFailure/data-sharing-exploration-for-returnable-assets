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
        $fetch("http://localhost:8080/api/auth/authenticate", {
          method: "POST",
          headers: {
            "Content-Type": "application/json",
          },
          body: credentials,
        })
      );

      if (data) {
        if (data.value?.access_token) {
          user.value = data.value.user;
          const userToken = useCookie("userToken", {
            secure: true,
            sameSite: "strict",
            maxAge: 60,
          });
          userToken.value = data.value.access_token;
        }
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
