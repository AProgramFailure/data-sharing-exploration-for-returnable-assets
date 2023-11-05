<script setup lang="ts">
    import { storeToRefs } from 'pinia';
    import { useOrganizationStore } from '~/stores/Organization/organizationStore';
    import { RemovableRef } from '@vueuse/core';

    import type { Organization } from '~/types/Organization/Organization';
    import type { Order } from '~/types/Order/Order';
    import type { Inventory } from '~/types/Inventory/Inventory';
    import type { Location } from '~/types/Location/Location';

    const organizationStore = useOrganizationStore();

    const { getOrganizations } = organizationStore;

    const isSidemenuOpen : Ref<boolean> = ref<boolean>(false);
    const selectedItem : Ref<unknown | null> = ref<unknown>();

    const organizations = getOrganizations
    const orders : Ref<Order[]> = ref<Order[]>([])
    const locations : Ref<Location[]> = ref<Location[]>([])

    organizations.value.forEach( (organization: Organization) => {
        orders.value.concat(organization.orders)
    })

    organizations.value.forEach( (organization: Organization) => {
        locations.value.concat(organization.locations)
    })

    function selectItem(item: unknown) {
        selectedItem.value = item
        isSidemenuOpen.value = !isSidemenuOpen.value
    }


    const dictionary : {
        name: string,
        key: RemovableRef<unknown>
    }[] = [
        {
            name: "Orders",
            key: orders
        },
        {
            name: "Organizations",
            key: organizations
        },
        {
            name: "Locations",
            key: locations
        }
    ]

    useHead({
        title: "Federated - Database"
    })

</script>

<template>
    <div>
        <div class="w-full h-screen flex flex-col items-center justify-start gap-6 p-4 overflow-y-scroll no-scrollbar">
            <div
            class="bg-neutral-800 w-full min-h-[25rem] p-3 rounded-md border-2 border-transparent hover:border-emerald-400 transition duration-500 relative flex flex-col items-start justify-evenly"
            >
            <h1 class="text-white font-semibold text-[18px]">Organizations</h1>
                <div class="h-60 bg-neutral-900 rounded-md w-full overflow-y-scroll no-scrollbar border-emerald-500/30 border-2 p-2 flex flex-col gap-2">
                    <div
                    class="bg-transparent rounded-md text-white  flex flex-row justify-between items-center p-4 font-semibold"
                    >
                        <h1>Name</h1>
                        <h1>Type</h1>
                        <h1>Security</h1>
                        <h1>ID</h1>
                    </div>
                    <div
                    class="bg-transparent rounded-md hover:bg-emerald-400 transition duration-500 text-white hover:text-neutral-900 flex flex-row justify-between items-center p-4 font-semibold"
                    v-for="(item, index) in organizations"
                    :key="index"
                    @click="selectItem(item)"
                    >
                    <h1>{{ item.name }} </h1>
                    <h1> {{ item.organization_type }} </h1>
                    <h1> {{ item.security }} </h1>
                    <h1>{{ item.organization_id }} </h1>
                    </div>
                </div>
            </div>

            <div
            class="bg-neutral-800 w-full min-h-[25rem] p-3 rounded-md border-2 border-transparent hover:border-emerald-400 transition duration-500 relative flex flex-col items-start justify-evenly"
            >
            <h1 class="text-white font-semibold text-[18px]">Locations</h1>
                <div class="h-60 bg-neutral-900 rounded-md w-full overflow-y-scroll no-scrollbar border-emerald-500/30 border-2 p-2 flex flex-col gap-2">
                    <div
                    class="bg-transparent rounded-md text-white  flex flex-row justify-between items-center p-4 font-semibold"
                    >
                        <h1>Name</h1>
                        <h1>Address</h1>
                        <h1>Security</h1>
                        <h1>OID</h1>
                        <h1>LID</h1>
                    </div>
                    <div
                    class="bg-transparent rounded-md hover:bg-emerald-400 transition duration-500 text-white hover:text-neutral-900 flex flex-row justify-between items-center p-4 font-semibold"
                    v-for="(item, index) in locations"
                    :key="index"
                    @click="selectItem(item)"
                    >
                        <h1>{{ item.name }} </h1>
                        <h1> {{ item.address }} </h1>
                        <h1> {{ item.security }} </h1>
                        <h1>{{ item.organization_id }} </h1>
                        <h1> {{ item.location_id }} </h1>
                    </div>
                </div>
            </div>

            <div
            class="bg-neutral-800 w-full min-h-[25rem] p-3 rounded-md border-2 border-transparent hover:border-emerald-400 transition duration-500 relative flex flex-col items-start justify-evenly"
            >
            <h1 class="text-white font-semibold text-[18px]"> Orders</h1>
                <div class="h-60 bg-neutral-900 rounded-md w-full overflow-y-scroll no-scrollbar border-emerald-500/30 border-2 p-2 flex flex-col gap-2">
                    <div
                    class="bg-transparent rounded-md text-white  flex flex-row justify-between items-center p-4 font-semibold"
                    >
                        <h1>Status</h1>
                        <h1>OID</h1>
                        <h1>Security</h1>
                        <h1>Source</h1>
                        <h1>Destination</h1>
                        <h1>Amount</h1>
                        <h1>ID</h1>

                    </div>
                    <div
                    class="bg-transparent rounded-md hover:bg-emerald-400 transition duration-500 text-white hover:text-neutral-900 flex flex-row justify-between items-center p-4 font-semibold"
                    v-for="(item, index) in orders"
                    :key="index"
                    @click="selectItem(item)"
                    >
                        <h1>{{ item.status }}</h1>
                        <h1>{{ item.organization_id}}</h1>
                        <h1>{{ item.security }}</h1>
                        <h1>{{ item.source_location_id }}</h1>
                        <h1>{{ item.destination_location_id}}</h1>
                        <h1>{{ item.ordered_items.length}}</h1>
                        <h1>{{ item.order_id}}</h1>
                    </div>
                </div>
            </div>
        </div>
        <LazySlideover
            title="Account Information"
            :is-slide-open="isSidemenuOpen"
            @update:slide-open="isSidemenuOpen = $event"
            >
                <h1> selected item: {{ selectedItem }}</h1>
        </LazySlideover>
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