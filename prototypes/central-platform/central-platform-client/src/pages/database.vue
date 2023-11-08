<script lang="ts" setup>
import type { OrganizationAccessDTO } from "../types/OrganizationAccess/OrganizationAccess.ts";

definePageMeta({
  middleware: "auth",
});

const ownOrganizationAccess = ref<OrganizationAccessDTO | null>(null);
const externalOrganizationAccesses = ref<OrganizationAccessDTO[]>([]);

//TODO convert to store
async function fetchOwnOrganizationAccess() {
  const { data } = await useAsyncData<OrganizationAccessDTO>(() =>
    $fetch("http://localhost:8080/api/admin/organization-access/own", {
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
    ownOrganizationAccess.value = data.value;
  }
}

async function fetchExternalOrganizationAccesses() {
  const { data } = await useAsyncData<OrganizationAccessDTO[]>(() =>
    $fetch("http://localhost:8080/api/admin/organization-access/external", {
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
    externalOrganizationAccesses.value = data.value;
  }
}

//TODO convert to store
if (useCookie("userRole").value == "ADMIN") {
  await fetchOwnOrganizationAccess();
  await fetchExternalOrganizationAccesses();
}
</script>

<template>
  <div v-if="useCookie('userRole').value == 'ADMIN'" class="text-white">
    <h1 class="pl-5 mt-5 text-lg">Organization Access</h1>
    {{ ownOrganizationAccess }}
    <br><br>
    {{ externalOrganizationAccesses }}
  </div>
  <div v-else>
    <h1 class="pl-5 mt-5 text-lg">
      Organization Access insights require admin privileges.
    </h1>
  </div>
</template>
