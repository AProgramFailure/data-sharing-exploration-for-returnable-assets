<script lang="ts" setup>
    import { PlusIcon } from "@heroicons/vue/24/solid"
</script>

<template>
    <div>
        <aside class="h-screen w-[400px] bg-neutral-900 border-r-2 border-neutral-700 flex flex-row justify-center items-center overflow-hidden">
            <div class="w-[110px] h-full overflow-y-scroll no-scrollbar">
                <div class="flex flex-col justify-start items-center py-2 gap-2">
                    <NuxtLink
                    v-for="(shortcut, index) in 10"
                    :key="index"
                    :to="`/home/institution/${index}`"
                    class="border-2 bg-transparent border-emerald-300/20 hover:border-emerald-300 transition-colors duration-500 rounded-md w-[70px] h-[70px] min-w-[70px] flex flex-col items-center justify-center select-none text-white"
                    >
                    hi
                    </NuxtLink>
                    <button
                    class="border-2 bg-transparent border-emerald-300/20 hover:border-emerald-300 transition-colors duration-500 rounded-md w-[70px] h-[70px] min-w-[70px] flex flex-col items-center justify-center select-none text-white"
                    >
                        <PlusIcon class="group-hover:text-neutral-900 w-6 text-neutral-400 transition-colors duration-500" />
                    </button>

                </div>
            </div>
            <div class="w-full h-full flex flex-col items-center justify-between border-l-2 border-neutral-700">
                <div class="w-full h-full pb-10 overflow-hidden">
                    <div class=" border-b-2 border-neutral-700 h-10 w-full flex flex-col items-center justify-center">
                        <h1 class="font-semibold text-md select-none text-white">
                            Locations
                        </h1>
                    </div>

                    <div class="w-full h-full flex flex-col justify-start gap-2 mt-1 pt-1 overflow-y-scroll no-scrollbar">
                        <div
                        v-for="(item, index) in 20"
                        :key="index"
                        >
                        </div>
                    </div>
                </div>
            </div>
        </aside>
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
