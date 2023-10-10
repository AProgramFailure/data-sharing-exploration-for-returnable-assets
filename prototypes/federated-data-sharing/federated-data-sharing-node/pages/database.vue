<script setup lang="ts">
    import { storeToRefs } from 'pinia';
    import { useInventoryStore } from '~/stores/Inventory/inventoryStore';
    import { useFederatedNodeStore } from '~/stores/Node/nodeStore';
    import { useOrderSotre } from '~/stores/Order/orderStore';
    import { useOrganizationStore } from '~/stores/Organization/organizationStore';
    import { useLocationStore } from '~/stores/Location/locationStore';
    import { RemovableRef } from '@vueuse/core';

    const inventoryStore = useInventoryStore();
    const federatedNodeStore = useFederatedNodeStore();
    const orderStore = useOrderSotre();
    const organizationStore = useOrganizationStore();
    const locationStore = useLocationStore();

    const { getInventories } = inventoryStore;
    const { getFederatedNotes } = federatedNodeStore;
    const { getOrders } = orderStore;
    const { getOrganizations } = organizationStore;
    const { getLocations } = locationStore

    const dictionary : {
        name: string,
        key: RemovableRef<unknown>
    }[] = [
        {
            name: "Inventory",
            key: getInventories
        },
        {
            name: "Nodes",
            key: getFederatedNotes
        },
        {
            name: "Orders",
            key: getOrders
        },
        {
            name: "Organizations",
            key: getOrganizations
        },
        {
            name: "Locations",
            key: getLocations
        }
    ]

    defineEmits(["update:slide"])
</script>

<template>
    <div>
        <div class="w-full h-screen flex flex-col items-center justify-start gap-6 p-4 overflow-y-scroll no-scrollbar">
            <div
            v-for="(entry, index) in dictionary"
            :key="index"
            class="bg-neutral-800 w-full min-h-[20rem] p-3 rounded-md border-2 border-transparent hover:border-emerald-400 transition duration-500 relative flex flex-col items-start justify-evenly"
            >
            <h1 class="text-white font-semibold text-[18px]">{{ entry.name }}</h1>
                <div class="h-40 bg-neutral-900 rounded-md w-full overflow-y-scroll no-scrollbar">
                    <div
                    class="bg-transparent hover:bg-emerald-500 transition duration-500 text-white hover:text-neutral-900 h-10 flex flex-row justify-between items-center p-2 font-semibold"
                    v-for="(item, index) in 30"
                    :key="index"
                    >
                    <h1>{{ index }}</h1>
                    <h1>Some Name</h1>
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>

<style lang="scss" scoped>
.no-scrollbar::-webkit-scrollbar {
    display: none;
}

.no-scrollbar {
    -ms-overflow-style: none;
    scrollbar-width: none;
}
</style>