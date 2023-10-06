<script lang="ts" setup>

    const route = useRoute();
</script>

<template>
    <div>
        <h1 class="text-white">Institution name</h1>
        <h1 class="text-white font-semibold"> {{ route.fullPath }} </h1>
    </div>
</template>