<script lang="ts" setup>
    import "leaflet/dist/leaflet.css";
    import { LMap, LTileLayer, LMarker, LPopup } from "@vue-leaflet/vue-leaflet";
    import { PointExpression } from "leaflet";
    import { useOrganizationStore } from "~/stores/Organization/organizationStore";

    import type { Organization } from "~/types/Organization/Organization";

    const router = useRoute()
    const organizationStore = useOrganizationStore();

    const { getOrganizationById } = organizationStore

    definePageMeta({
        name: "Federated - Map"
    })

    useHead({
        title: "Federated - Map"
    })

    onBeforeMount(() => {

        let address = ""
        let port = 0
        if (process.client) {
            const location = window.location.href
            address = location.substring(7,16)
            port = Number(location.substring(17,21))
        }
        getOrganizationById(Number(router.params.id))
    })

    let zoom = ref(7);
    let center = ref<PointExpression>([52.1926, 5.2913]);
</script>

<template>
    <div>
        <div class="h-screen w-full relative">
            <l-map
                ref="map"
                v-model:zoom="zoom"
                v-model:center="center"
                :useGlobalLeaflet="false"
            >
                <l-tile-layer
                url="https://tiles.stadiamaps.com/tiles/alidade_smooth_dark/{z}/{x}/{y}{r}.png"
                layer-type="base"
                name="Locations map"
                ></l-tile-layer>
            </l-map>
        </div>
    </div>
</template>