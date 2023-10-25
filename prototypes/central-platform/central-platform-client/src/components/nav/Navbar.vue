<script lang="ts" setup>
import { useToast } from "vue-toastification";

const route = useRoute();
function logOut() {
  const toast = useToast();

  const userToken = useCookie("userToken");
  userToken.value = null;

  setTimeout(() => {
      toast.info("Logged out");
    }, 600);
  navigateTo("/");
}
</script>

<template>
  <div
    class="w-full h-16 flex flex-row items-center justify-between bg-emerald-500 p-4"
  >
    <h1 class="text-white font-semibold text-[16px] flex-1 text-center">
      DASHBOARD - {{ route.name?.toString().toUpperCase() }}
    </h1>
    <button
      v-if="useCookie('userToken').value"
      @click="logOut"
      class="text-white font-semibold text-[16px] border border-white px-4 py-2 rounded-lg"
    >
      Logout
    </button>
  </div>
</template>
