<script setup lang="ts">
import { storeToRefs } from 'pinia';
    import { useDatabase } from '~/database/database';
    import { useConnectionStore } from "~/stores/connection/connectionStore"

    const db = useDatabase();

    db.create<{
        key: string,
        subject: number
    }>("testing")
    const connStore = useConnectionStore();

    onMounted(() => {
        setTimeout(async () => {
            await connStore.authenticate()
        },300)
    })
    const { database } = storeToRefs(db)
    const { connections } = storeToRefs(connStore)

    const connectToEdge = async () => {
        await connStore.connect({ address: "127.0.0.1", port: 3000})

    }
</script>

<template>
    <div class="w-full h-full overflow-hidden flex flex-row">
        <div class="w-3/12 shadow-lg h-full flex flex-col items-center justify-start pt-4">
            <div class="bg-neutral-800 rounded-lg shadow-xl h-[700px] w-11/12 flex flex-col items-center justify-start p-6 ">
                <h1 class="text-emerald-500 font-semibold text-[20px] pb-4">Connections</h1>
                <div @click="connectToEdge()" class="bg-white text-black">click me</div>
                <div class="w-full h-full overflow-y-auto no-scrollbar flex flex-col items-center justify-start gap-3">
                    <div
                    v-for="(connection, index) in connections"
                    :key="index"
                    class="flex flex-col items-start justify-between gap-2 bg-transparent w-full border border-emerald-400/20 rounded-md p-2 group text-white/50 hover:border-emerald-400 transition duration-300"
                    >
                        <h1 class="flex flex-row gap-2 items-center justify-start bg-neutral-900 py-2 px-2 rounded font-semibold h-full text-center w-full group-hover:text-white duration-300 transition">
                            IID: {{ connection.server.institution.id }}
                        </h1>
                        <h1 class="flex flex-row gap-2 items-center justify-start bg-neutral-900 py-2 px-2 rounded font-semibold h-full text-center w-full group-hover:text-white duration-300 transition">
                            OID: {{ connection.server.origin.id }}
                        </h1>
                    </div>
                </div>
            </div>
        </div>
        <div class="w-6/12 h-full flex flex-col items-center justify-start pt-4">
            <div class="flex flex-col bg-neutral-800 h-[800px] w-full gap-2 p-4 overflow-y-scroll no-scrollbar">
                <div
                v-for="(table, index) in database.tables"
                :key="index"
                class="w-full border border-emerald-400/20 rounded-md p-4 hover:border-emerald-400 transition duration-300 text-white"
                >
                    <h1 class="text-[20px]">Table: {{ table.name }}</h1>
                    <button>click</button>
                </div>

            </div>
        </div>
        <div class="w-3/12 h-full flex flex-col items-center justify-start pt-4">

        </div>
    </div>
</template>

<style scoped>
.no-scrollbar::-webkit-scrollbar {
    display: none;
}

.no-scrollbar {
    -ms-overflow-style: none;
    scrollbar-width: none;
}
</style>