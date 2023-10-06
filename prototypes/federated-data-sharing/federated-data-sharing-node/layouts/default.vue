<script setup lang="ts">

</script>

<template>
    <div>
        <div class=" w-full flex flex-col max-h-screen">
            <div class="w-full flex flex-row overflow-hidden">
                <LazySidebar />
                <LazyNuxtPage class="w-full bg-neutral-900 min-h-screen h-full"/>
                <LazyControllbar />
            </div>
        </div>
    </div>
</template>