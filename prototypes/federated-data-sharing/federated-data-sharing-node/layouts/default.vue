<script setup lang="ts">

    const isSidemenuOpen : Ref<boolean> = ref<boolean>(false);
</script>

<template>
    <div>
        <div class=" w-full flex flex-col max-h-screen">
            <div class="w-full flex flex-row overflow-hidden">
                <LazySidebar />
                <LazyNuxtPage class="w-full bg-neutral-900 min-h-screen h-full"/>
                <LazyControllbar
                @update:slide="isSidemenuOpen = true" />
                <LazySlideover
                :is-slide-open="isSidemenuOpen"
                @update:slide-open="isSidemenuOpen = $event"
                />
            </div>
        </div>
    </div>
</template>