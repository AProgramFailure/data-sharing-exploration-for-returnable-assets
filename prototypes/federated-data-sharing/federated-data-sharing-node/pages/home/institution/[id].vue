<script lang="ts" setup>
    import "leaflet/dist/leaflet.css";
    import { LMap, LTileLayer, LMarker, LPopup } from "@vue-leaflet/vue-leaflet";
    import { PointExpression } from "leaflet";


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