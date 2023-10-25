<script lang="ts" setup>
definePageMeta({
  middleware: 'auth'
})
</script>

<template>
    <div>
        <NuxtLink to="/home">
            go back home
        </NuxtLink>
    </div>
</template>