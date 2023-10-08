<script lang="ts" setup>
import "leaflet/dist/leaflet.css";
import { LMap, LTileLayer, LMarker, LPopup } from "@vue-leaflet/vue-leaflet";
import { PointExpression } from "leaflet";
import { useOrganizationStore } from "~/stores/Organization/OrganizationStore";
import { Organization } from "~/types/Organization/Organization";
import { storeToRefs } from "pinia";

const organizationStore = useOrganizationStore();

const { getOrganizations } = organizationStore

onBeforeMount(async () => {
  await organizationStore.fetchOrganizations();
});

const showLocations = ref(Array(getOrganizations.value.length).fill(false));

const toggleLocations = (index: number) => {
  showLocations.value[index] = !showLocations.value[index];
};

const filteredLocations = (index: number) => {
  if (showLocations.value[index]) {
    return getOrganizations.value[index].locations;
  } else {
    return [];
  }
};

const mapLocations = computed(() => {
  const locations = [];
  for (let i = 0; i < getOrganizations.value.length; i++) {
    if (showLocations.value[i]) {
      for (const location of getOrganizations.value[i].locations) {
        locations.push({
          name: getOrganizations.value[i].name,
          lat: location.latitude,
          lon: location.longitude,
          address: location.address,
          itemCount: location.inventory.length,
        });
      }
    }
  }
  return locations;
});

let zoom = ref(7);
let center = ref<PointExpression>([52.1926, 5.2913]);
</script>

<template>
  <div class="max-h-[calc(100vh-4rem)] w-full flex overflow-hidden select-none">
    <aside
      class="w-1/4 my-1 mr-1 px-6 py-4 flex flex-col bg-neutral-900 text-emerald-400 rounded-r-lg overflow-y-auto"
    >
      <span class="mt-4 text-neutral-200 font-semibold">Lorem Ipsum</span>
      <span class="mt-1 text-3xl font-semibold">€ 0</span>

      <button
        class="mt-8 flex border-2 border-transparent items-center py-4 px-3 text-white rounded-lg bg-emerald-500 shadow focus:outline-none hover:bg-emerald-400 hover:border-emerald-300 transition duration-500"
      >
        <svg class="h-5 w-5 fill-current mr-2 ml-3" viewBox="0 0 24 24">
          <path d="M19 13h-6v6h-2v-6H5v-2h6V5h2v6h6v2z"></path>
        </svg>

        <span>Lorem ipsum</span>
      </button>

      <div class="mt-12 flex items-center">
        <span>Lorem ipsum</span>
        <button class="ml-2 focus:outline-none">
          <svg class="h-5 w-5 fill-current" viewBox="0 0 256 512">
            <path
              d="M224.3 273l-136 136c-9.4 9.4-24.6 9.4-33.9
                            0l-22.6-22.6c-9.4-9.4-9.4-24.6
                            0-33.9l96.4-96.4-96.4-96.4c-9.4-9.4-9.4-24.6 0-33.9L54.3
                            103c9.4-9.4 24.6-9.4 33.9 0l136 136c9.5 9.4 9.5 24.6.1
                            34z"
            ></path>
          </svg>
        </button>
      </div>

      <div class="mt-4 flex justify-center capitalize text-emerald-600">
        <NuxtLink to="/database">see all</NuxtLink>
      </div>
    </aside>
    <div
      class="mr-6 w-1/2 mt-8 py-2 flex-shrink-0 flex flex-col h-[calc(100vh-4rem)] bg-neutral-800 rounded-lg text-white border-2 border-transparent hover:border-emerald-500 transition duration-500"
    >
      <l-map
        ref="map"
        v-model:zoom="zoom"
        v-model:center="center"
        :style="{ height: '100%', width: '100%' }"
        :useGlobalLeaflet="false"
      >
        <l-tile-layer
          url="https://tiles.stadiamaps.com/tiles/alidade_smooth_dark/{z}/{x}/{y}{r}.png"
          layer-type="base"
          name="Locations map"
        ></l-tile-layer
        ><l-marker
          v-for="(location, locationIndex) in mapLocations"
          :key="locationIndex"
          :lat-lng="[parseFloat(location.lat), parseFloat(location.lon)]"
        >
          <l-popup>
            <div>
              <strong>{{ location.name }}</strong>
            </div>
            <div>{{ location.address }}</div>
            <div>Items Count: {{ location.itemCount }}</div>
          </l-popup>
        </l-marker>
      </l-map>
    </div>
    <div
      class="w-1/4 pt-8 pb-2 flex-shrink-0 flex flex-col h-[calc(100vh-4rem)] bg-neutral-900 rounded-l-lg transition duration-500 ease-in-out overflow-y-auto"
    >
      <div
        class="mr-6 py-1 flex flex-col bg-neutral-800 border-2 border-transparent hover:border-emerald-500 transition duration-500 rounded-lg"
      >
        <div>
          <ul class="pt-1 pb-2 px-3 overflow-y-auto">
            <li
              class="mt-2"
              v-for="(organization, index) in getOrganizations"
              :key="index"
            >
              <a
                class="p-5 flex flex-col bg-neutral-100 rounded-lg"
                href="#"
                @click="toggleLocations(index)"
              >
                <div
                  class="flex items-center justify-between font-semibold capitalize text-gray-700"
                >
                  <span>{{ organization.name }}</span>
                  <span>{{
                    showLocations[index] ? "Hide Locations" : "Show Locations"
                  }}</span>
                </div>
              </a>
              <ul>
                <li
                  v-for="(location, locationIndex) in filteredLocations(index)"
                  :key="locationIndex"
                  class="mt-2"
                >
                  <ul
                    class="p-5 flex flex-col bg-neutral-900 rounded-lg text-white"
                  >
                    <li>{{ location.address }}</li>
                    <li>Items Count: {{ location.inventory.length }}</li>
                  </ul>
                </li>
              </ul>
            </li>
          </ul>
        </div>
      </div>
    </div>
  </div>
</template>
