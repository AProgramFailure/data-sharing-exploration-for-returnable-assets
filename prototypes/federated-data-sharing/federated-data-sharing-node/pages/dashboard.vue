<script setup lang="ts">

    import { useOrganizationStore } from '~/stores/Organization/organizationStore';

    const organizationStore = useOrganizationStore();

    const { addSampleOrg } =  organizationStore
    const isSidemenuOpen : Ref<boolean> = ref<boolean>(false);

    useHead({
        title: "Federated - Dashboard"
    })


    const content = ref({
        order: {
            title: "Orders",
            content: {
                organization_id: 0,
                source_location_id: 0,
                destination_location_id: 0,
                status: "",
                security: ""
            }
        },
        order_item: {
            title: "Items",
            content: [

            ]
        },
        inventory: {
            title: "Inventories",
            content: {
                item_type: "",
                inventory_name: "",
                quantity: 0,
                location_id: 0,
                security: ""
            }
        },
        location: {
            title: "Locations",
            content: {
                name: "",
                address: "",
                latitude: "",
                longitude: "",
                security: "",
                organization_id: 0
            }
        },
        node: {
            title: "Nodes",
            content: {
                name: "",
                owner: 0,
                security: ""
            }
        },
        user: {
            title: "Users",
            content: {
                email: "",
                password: "",
                name: "",
                secret_key: ""
            }
        },
        organization: {
            title: "Organizations",
            content: {
                name: "",
                type: "",
                security: ""
            }
        }
    })

    const selected_content = ref({})


    function select_property(property : {
        title: String,
        content: any
    }) {
        selected_content.value = property
        isSidemenuOpen.value = !isSidemenuOpen.value
    }
</script>

<template>
    <div>
        <div class="bg-neutral-900 min-h-screen flex items-start justify-center">
            <div class="bg-neutral-900 flex-1 flex flex-col">
                <!-- Navigation -->
                <div class="bg-neutral-900 px-2 lg:px-4 py-2 lg:py-10 sm:rounded-xl flex lg:flex-col justify-between">

                    <div class="mb-10 sm:mb-0 mt-10 grid gap-4 grid-cols-1 sm:grid-cols-2 md:grid-cols-3 lg:grid-cols-4">
                        <div
                        @click="select_property(content.node)"
                        class="relative group bg-neutral-800/60 py-10 sm:py-20 px-4 flex flex-col space-y-2 items-center rounded-md hover:bg-neutral-700 hover:smooth-hover transition duration-300">
                            <img class="w-20 h-20 object-cover object-center rounded-full" src="https://images.unsplash.com/photo-1547592180-85f173990554?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=1170&q=80" alt="cuisine" />
                            <h4 class="text-white text-2xl font-bold capitalize text-center">Nodes</h4>
                        </div>

                        <div
                        @click="select_property(content.organization)"
                        class="relative group bg-neutral-800/60 py-10 sm:py-20 px-4 flex flex-col space-y-2 items-center rounded-md hover:bg-neutral-700 hover:smooth-hover transition duration-300">
                            <img class="w-20 h-20 object-cover object-center rounded-full" src="https://images.unsplash.com/photo-1547592180-85f173990554?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=1170&q=80" alt="cuisine" />
                            <h4 class="text-white text-2xl font-bold capitalize text-center">Organization</h4>
                        </div>

                        <div
                        @click="select_property(content.location)"
                        class="relative group bg-neutral-800/60 py-10 sm:py-20 px-4 flex flex-col space-y-2 items-center rounded-md hover:bg-neutral-700 hover:smooth-hover transition duration-300">
                            <img class="w-20 h-20 object-cover object-center rounded-full" src="https://images.unsplash.com/photo-1547592180-85f173990554?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=1170&q=80" alt="cuisine" />
                            <h4 class="text-white text-2xl font-bold capitalize text-center">Location</h4>
                        </div>

                        <div
                        @click="select_property(content.inventory)"
                        class="relative group bg-neutral-800/60 py-10 sm:py-20 px-4 flex flex-col space-y-2 items-center rounded-md hover:bg-neutral-700 hover:smooth-hover transition duration-300">
                            <img class="w-20 h-20 object-cover object-center rounded-full" src="https://images.unsplash.com/photo-1547592180-85f173990554?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=1170&q=80" alt="cuisine" />
                            <h4 class="text-white text-2xl font-bold capitalize text-center">Inventory</h4>
                        </div>

                        <div
                        @click="select_property(content.order)"
                        class="relative group bg-neutral-800/60 py-10 sm:py-20 px-4 flex flex-col space-y-2 items-center rounded-md hover:bg-neutral-700 hover:smooth-hover transition duration-300">
                            <img class="w-20 h-20 object-cover object-center rounded-full" src="https://images.unsplash.com/photo-1547592180-85f173990554?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=1170&q=80" alt="cuisine" />
                            <h4 class="text-white text-2xl font-bold capitalize text-center">Order</h4>
                        </div>

                        <div
                        @click="select_property(content.order_item)"
                        class="relative group bg-neutral-800/60 py-10 sm:py-20 px-4 flex flex-col space-y-2 items-center rounded-md hover:bg-neutral-700 hover:smooth-hover transition duration-300">
                            <img class="w-20 h-20 object-cover object-center rounded-full" src="https://images.unsplash.com/photo-1547592180-85f173990554?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=1170&q=80" alt="cuisine" />
                            <h4 class="text-white text-2xl font-bold capitalize text-center">Orer Item</h4>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <LazySlideover
        title="Account Information"
        :is-slide-open="isSidemenuOpen"
        @update:slide-open="isSidemenuOpen = $event"
        >
            <div class="flex flex-col justify-center items-center">
                <h1 class="text-white"> {{ selected_content }} </h1>
            </div>
        </LazySlideover>
    </div>
</template>