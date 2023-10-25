<script setup lang="ts">

    import { useOrganizationStore } from '~/stores/Organization/organizationStore';

    const organizationStore = useOrganizationStore();

    const { addSampleOrg } =  organizationStore
    const isModalOpen : Ref<boolean> = ref<boolean>(false);
</script>

<template>
    <div>

        <div
        @click="isModalOpen = !isModalOpen"
        class="w-10 h-4">
            Hello
        </div>
        <div
        class="text-white"
        @click="addSampleOrg"
        >
            Add Sample Data
        </div>
        <LazyModal :is-modal-open="isModalOpen"
            @update:open="isModalOpen = $event"
            >
                <div class="flex flex-col justify-center items-center">
                    <h1>Connect to Node</h1>

                </div>
        </LazyModal>
    </div>
</template>