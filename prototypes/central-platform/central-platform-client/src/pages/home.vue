<script lang="ts" setup>
import "leaflet/dist/leaflet.css";
import { LMap, LTileLayer, LMarker, LPopup } from "@vue-leaflet/vue-leaflet";
import { PointExpression } from "leaflet";
import L from "leaflet";
import { useOrganizationStore } from "~/stores/Organization/OrganizationStore";
import { Inventory } from "~/types/Inventory/Inventory";

const organizationStore = useOrganizationStore();
const { getOrganizations } = organizationStore;

const isLoading = ref(true);

onMounted(async () => {
  setTimeout(async () => {
    await organizationStore.fetchOrganizations();
    isLoading.value = false;
  });
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
          inventory: location.inventory,
        });
      }
    }
  }
  return locations;
});

let zoom = ref(7);
let center = ref<PointExpression>([52.1926, 5.2913]);

const calculateTotalInventory = (inventory: Inventory[]) => {
  return inventory.reduce((total, item) => total + item.quantity, 0);
};

function createMarkerIcon(totalQuantity: number) {
  const color =
    totalQuantity < 50
      ? "green"
      : totalQuantity < 100
      ? "yellow"
      : totalQuantity < 150
      ? "orange"
      : "red";

  const svgIcon = `<svg xmlns="http://www.w3.org/2000/svg" width="24" height="32" viewBox="0 0 24 32">
    <path d="M12 2C6.478 2 2 6.478 2 12c0 8 10 18 10 18s10-10 10-18c0-5.522-4.478-10-10-10zm0 18c-2.209 0-4-1.791-4-4s1.791-4 4-4 4 1.791 4 4-1.791 4-4 4z" fill="${color}" stroke="white" stroke-width="2" />
  </svg>`;

  return L.divIcon({
    className: "custom-marker-icon",
    html: svgIcon,
    iconSize: [24, 32],
    iconAnchor: [12, 32],
  });
}
</script>

<template>
  <div class="max-h-[calc(100vh-4rem)] w-full flex overflow-hidden select-none">
    <aside
      class="w-1/4 my-1 mr-1 px-6 py-4 flex flex-col bg-neutral-900 text-emerald-400 rounded-r-lg overflow-y-auto"
    >
      <!-- <span class="mt-4 text-neutral-200 font-semibold">Lorem Ipsum</span>
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
      </div> -->
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
          :icon="createMarkerIcon(calculateTotalInventory(location.inventory))"
        >
          <l-popup>
            <div>
              <strong>{{ location.name }}</strong>
            </div>
            <div>{{ location.address }}</div>
            <div>
              Total Inventory: {{ calculateTotalInventory(location.inventory) }}
            </div>
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
            <div v-if="isLoading" class="text-white">Loading...</div>
            <div class="text-white" v-else>
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
                    v-for="(location, locationIndex) in filteredLocations(
                      index
                    )"
                    :key="locationIndex"
                    class="mt-2"
                  >
                    <ul
                      class="p-5 flex flex-col bg-neutral-900 rounded-lg text-white"
                    >
                      <li>{{ location.address }}</li>
                      <ul class="p-3 mt-2 bg-neutral-800 rounded-lg text-white">
                        <li
                          v-for="(
                            inventory, inventoryIndex
                          ) in location.inventory"
                          :key="inventoryIndex"
                        >
                          Item: {{ inventory.itemType }} <br>
                          Quantity: {{ inventory.quantity  }}
                        </li>
                      </ul>
                    </ul>
                  </li>
                </ul>
              </li>
            </div>
          </ul>
        </div>
      </div>
    </div>
  </div>
</template>
