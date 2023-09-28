<script lang="ts" setup>

    const route = useRoute();

</script>


<template>
    <div class="w-full h-12 flex flex-row items-center justify-center bg-emerald-500">
        <h1 class="text-white font-semibold text-[16px]">DASHBOARD - {{ route.name?.toString().toUpperCase() }}</h1>
    </div>
</template>