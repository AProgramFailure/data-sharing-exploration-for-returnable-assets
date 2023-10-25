<script lang="ts" setup>

    import { useUserStore } from '~/stores/User/userStore';


    const userStore = useUserStore();
    const { register } = userStore

    definePageMeta({
        layout: "auth"
    })



    const email: Ref<string> = ref<string>('');
    const password: Ref<string> = ref<string>('');
    const first_name : Ref<string> = ref<string>('');
    const last_name  : Ref<string> = ref<string>('');


</script>

<template>
    <div class="max-h-screen">
        <section class="bg-trnasparent min-h-screen flex items-center justify-center">
            <div class="bg-neutral-800 p-5 flex rounded-2xl shadow-3xl border-4 border-emerald-300/10 max-w-3xl">
            <div class="md:w-1/2 px-5 pt-4">
                <div class="flex flex-row items-center justify-start gap-2">
                    <h2 class="text-3xl font-bold text-white">Register</h2>
                </div>
                <div class="mt-6">
                <div>
                    <label class="block text-neutral-300">Email Address</label>
                    <input
                    v-model="email"
                    type="email"
                    name=""
                    id=""
                    placeholder="Enter Email Address"
                    class="w-full px-4 py-3 rounded-lg bg-neutral-100 mt-2 border-4 border-transparent focus:border-emerald-400 focus:bg-white focus:outline-none transition duration-300 text-neutral-900" autofocus required>
                </div>

                <div class="mt-2">
                    <label class="block text-neutral-300">First Name</label>
                    <input
                    v-model="first_name"
                    type="email"
                    name=""
                    id=""
                    placeholder="Enter Email Address"
                    class="w-full px-4 py-3 rounded-lg bg-neutral-100 mt-2 border-4 border-transparent focus:border-emerald-400 focus:bg-white focus:outline-none transition duration-300 text-neutral-900" autofocus required>
                </div>

                <div class="mt-2">
                    <label class="block text-neutral-300">Last Name</label>
                    <input
                    v-model="last_name"
                    type="email"
                    name=""
                    id=""
                    placeholder="Enter Email Address"
                    class="w-full px-4 py-3 rounded-lg bg-neutral-100 mt-2 border-4 border-transparent focus:border-emerald-400 focus:bg-white focus:outline-none transition duration-300 text-neutral-900" autofocus required>
                </div>

                <div class="mt-2">
                    <label class="block text-neutral-300">Password</label>
                    <input
                    v-model="password"
                    type="password"
                    name=""
                    id=""
                    placeholder="Enter Password"
                    v-on:keyup.enter="register({
                        email: email,
                        password: password,
                        first_name: first_name,
                        last_name: last_name
                    })"
                    minlength="6"
                    class="w-full px-4 py-3 text-neutral-900 rounded-lg bg-neutral-100 mt-2 border-4 focus:border-emerald-400 transition duration-300 focus:bg-white focus:outline-none" required>
                </div>

                <div class="flex flex-row items-center justify-center mt-6">
                    <div
                    @click="register({
                            email: email,
                            password: password,
                            first_name: first_name,
                            last_name: last_name
                        })"
                    class="w-full block bg-emerald-500 hover:bg-emerald-400 focus:bg-emerald-600 text-white font-semibold rounded-l-md rounded-r-none transition duration-300 px-4 py-3 text-center cursor-pointer">Register</div>
                    <NuxtLink to="/" class="border-2 border-emerald-500 rounded-r-md p-[10px] text-white/40 hover:border-emerald-500 hover:bg-emerald-500 transition duration-300 hover:text-white">
                        <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" fill="currentColor" class="w-6 h-6">
                            <path fill-rule="evenodd" d="M12 1.5a5.25 5.25 0 00-5.25 5.25v3a3 3 0 00-3 3v6.75a3 3 0 003 3h10.5a3 3 0 003-3v-6.75a3 3 0 00-3-3v-3c0-2.9-2.35-5.25-5.25-5.25zm3.75 8.25v-3a3.75 3.75 0 10-7.5 0v3h7.5z" clip-rule="evenodd" />
                        </svg>
                    </NuxtLink>
                </div>
            </div>
        </div>

            <div class="w-1/2 md:block hidden ">
                <img src="https://images.unsplash.com/photo-1614741118887-7a4ee193a5fa?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1887&q=80" class="rounded-2xl" alt="page img">
            </div>

            </div>
        </section>
    </div>
</template>