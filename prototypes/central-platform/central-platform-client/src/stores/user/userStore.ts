import { defineStore } from "pinia";

import { type RemovableRef, useSessionStorage } from "@vueuse/core";

import type { User, MinifiedUser, UserCredentials } from "~/types/User/User";

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
            maxAge: 86400,
          });
          userToken.value = data.value.access_token;
        }
      }
    }

    async function register(newUser: MinifiedUser): Promise<void> {
      const { data } = await useAsyncData<{
        access_token: string;
        refresh_token: string;
        user: User;
      }>("user", async () =>
      await $fetch("http://localhost:8080/api/auth/register", {
          method: "POST",
          headers: {
            "Content-Type": "application/json",
          },
          body: {
            email: newUser.email,
            firstname: newUser.firstName,
            lastname: newUser.lastName,
            password: newUser.password,
            role: "USER",
          },
        })
      );

      if (data) {
        if (data.value?.access_token) {
          user.value = data.value.user;
          const userToken = useCookie("userToken", {
            secure: true,
            sameSite: "strict",
            maxAge: 86400,
          });
          userToken.value = data.value.access_token;
          // Automatically create a request for the user to join chosen organization
          await $fetch("http://localhost:8080/api/user/user-assign-request/new", {
            method: "POST",
            headers: {
              "Content-Type": "application/json",
              Authorization: "Bearer " + userToken.value,
            },
            body: {
              type: "create",
              role: "USER",
              organizationId: newUser.organizationId,
            },
          });
        }
      }
    }

    return {
      getUser,
      authenticate,
      register,
      user,
    };
  },
  {
    persist: false,
  }
);
