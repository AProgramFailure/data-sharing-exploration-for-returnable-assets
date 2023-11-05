<script lang="ts" setup>
import type { UserOrganizationApplication } from "../types/UserOrganizationApplication/UserOrganizationApplication.ts";

definePageMeta({
  middleware: "auth",
});

const userOrganizationApplications = ref<UserOrganizationApplication[]>([]);

async function fetchUserOrganizationApplications() {
  const { data } = await useAsyncData<UserOrganizationApplication[]>(
    "userOrganizationApplications",
    () =>
      $fetch("http://localhost:8080/api/admin/user-assign-request", {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
          Authorization: "Bearer " + useCookie("userToken").value,
        },
        body: {
          type: "info",
        },
      })
  );

  if (data.value) {
    userOrganizationApplications.value = data.value;
  }
}

await fetchUserOrganizationApplications();
</script>

<template>
  <ul class="p-5 flex flex-col bg-neutral-900 rounded-lg text-white">
    <ul class="p-3 mt-2 bg-neutral-800 rounded-lg text-white">
      <li
        v-for="(
          userOrganizationApplication, index
        ) in userOrganizationApplications"
        :key="index"
        class="mt-2 p-2 bg-neutral-700 rounded-lg"
      >
        {{ userOrganizationApplication }}
      </li>
    </ul>
  </ul>
</template>
