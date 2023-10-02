<script lang="ts" setup>
    import { HomeIcon, CircleStackIcon, ChartPieIcon, AdjustmentsHorizontalIcon } from "@heroicons/vue/24/solid"
</script>

<template>
    <nav class=" absolute left-1/2 -translate-x-1/2 bottom-10 w-96 h-16 bg-emerald-500 flex flex-row items-center justify-evenly rounded-md">
        <NuxtLink to="/home" class="bg-ransparent text-white border-2 border-transparent rounded-md hover:bg-emerald-400 hover:border-emerald-300 transition duration-500 p-2">
            <HomeIcon class="w-8" />
        </NuxtLink>
        <NuxtLink to="/database" class="bg-ransparent text-white border-2 border-transparent rounded-md hover:bg-emerald-400 hover:border-emerald-300 transition duration-500 p-2">
            <CircleStackIcon class="w-8" />
        </NuxtLink>
        <NuxtLink to="/dashboard" class="bg-ransparent text-white border-2 border-transparent rounded-md hover:bg-emerald-400 hover:border-emerald-300 transition duration-500 p-2">
            <ChartPieIcon class="w-8" />
        </NuxtLink>
        <div class="bg-ransparent text-white border-2 border-transparent rounded-md hover:bg-emerald-400 hover:border-emerald-300 transition duration-500 p-2">
            <AdjustmentsHorizontalIcon class="w-8" />
        </div>
    </nav>
</template>