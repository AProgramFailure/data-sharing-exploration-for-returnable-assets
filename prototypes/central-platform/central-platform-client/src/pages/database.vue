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

async function removeOrganizationAccess(accessId: string, organizationId: string ) {
  const { data } = await useAsyncData<string>(() =>
    $fetch(
      "http://localhost:8080/api/admin/organization-access/remove/" + organizationId,
      {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
          Authorization: "Bearer " + useCookie("userToken").value,
        },
        body: {
          type: "delete",
        },
      }
    )
  );
  console.log(data.value);
  if (data.value) {
    console.log("test");
    const updatedOrganizationAccesses = externalOrganizationAccesses.value.filter(
      (access) => access.id !== accessId
    );
    externalOrganizationAccesses.value = updatedOrganizationAccesses;
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
    <h1 class="pl-5 mt-5 text-lg">Data Access</h1>
    <div v-if="ownOrganizationAccess" class="pl-5 pr-5 mt-8 mb-12">
      <div class="pl-5 bg-neutral-800 rounded-lg p-4">
        <h2 class="text-lg text-emerald">Own Organization Access:</h2>
        <p>
          <strong>Organization Name:</strong>
          {{ ownOrganizationAccess.organization.name }}
        </p>
        <p class="mb-4">
          <i>Organization ID:</i> {{ ownOrganizationAccess.organization.id }}
        </p>
        <p class="mb-2">
          <strong>Access given by the following organizations:</strong>
        </p>
        <ul class="bg-neutral-700 rounded pt-3 pl-2 pr-2 pb-1">
          <li
            v-for="org in ownOrganizationAccess.allowedOrganizations"
            :key="org.id"
            class="bg-neutral-800 rounded p-2 mb-2"
          >
            <p>{{ org.name }}</p>
            <p><i>Organization ID:</i> {{ org.id }}</p>
          </li>
        </ul>
      </div>
    </div>

    <div
      v-if="externalOrganizationAccesses.length > 0"
      class="min-h-[400px] overflow-y-auto"
    >
      <h2 class="pl-5 mt-3 text-md text-emerald">
        External Organizations that received access:
      </h2>
      <div class="ml-5 mt-2">
        <button
          class="border border-emerald-500 text-emerald-500 hover:bg-emerald-500 hover:text-white px-4 py-2 rounded-md focus:outline-none focus:ring-2 focus:ring-green-500 transition-colors duration-300"
          @click=""
        >
          Add
        </button>
      </div>
      <div
        class="grid grid-cols-1 sm:grid-cols-2 md:grid-cols-3 lg:grid-cols-4 gap-4 p-5"
      >
        <div
          v-for="extAccess in externalOrganizationAccesses"
          :key="extAccess.id"
          class="bg-neutral-800 rounded-lg p-4"
        >
          <div class="bg-neutral-900 p-4 rounded">
            <p>
              {{ extAccess.organization.name }}
            </p>
            <p><i>Organization ID:</i> {{ extAccess.organization.id }}</p>
            <div class="flex space-x-4 mt-8 mb-2 rounded pb-2">
              <button
                class="border border-red-500 text-red-500 hover:bg-red-500 hover:text-white px-4 py-2 rounded-md focus:outline-none focus:ring-2 focus:ring-red-500 transition-colors duration-300"
                @click="removeOrganizationAccess(extAccess.id,extAccess.organization.id)"
              >
                Remove
              </button>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
  <div v-else>
    <h1 class="pl-5 mt-5 text-lg">
      Organization Access insights require admin privileges.
    </h1>
  </div>
</template>
