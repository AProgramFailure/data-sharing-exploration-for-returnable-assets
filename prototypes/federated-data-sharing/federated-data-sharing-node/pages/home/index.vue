<script setup lang="ts">

    const { $trpcClient } = useNuxtApp();

    const { data } = await $trpcClient.institutions.getInstitutions.useLazyQuery({
        email: "umairl@gmail.com"
    })

    const isSidemenuOpen : Ref<boolean> = ref<boolean>(false);
    const isModalOpen : Ref<boolean> = ref<boolean>(false);


</script>

<template>
    <div class="h-full">
        <LazyModal
        :is-modal-open="isModalOpen"
        @update:open="isModalOpen = $event">
            <h1>Hello how you doing</h1>
        </LazyModal>
        <LazySlideover
        :is-slide-open="isSidemenuOpen"
        @update:slide-open="isSidemenuOpen = $event"
        >
            <h1>Hello</h1>
        </LazySlideover>
        <NuxtPage />
    </div>

</template>