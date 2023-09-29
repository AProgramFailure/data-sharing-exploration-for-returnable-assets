// https://nuxt.com/docs/api/configuration/nuxt-config

export default defineNuxtConfig({
  devtools: { enabled: false },
  build: {
    transpile: ['trpc-nuxt', 'vue-toastification']
  },
  runtimeConfig: {
    public: {
      API_BASE_URL: process.env.API_ROUTE
    }
  },
  components: [
    {
      path: '~/components',
      pathPrefix: false,
    }
  ],
  imports: {
    dirs: ['stores', 'composables/**'],
  },
  modules: [
    '@vueuse/nuxt',
    '@nuxt/ui',
    [
      '@pinia/nuxt',
      {
          autoImports: ['defineStore', 'acceptHMRUpdate'],
      },
    ],
    '@pinia-plugin-persistedstate/nuxt',
  ],
  css: [
    '~/assets/css/main.css'
  ],
  postcss: {
    plugins: {
      tailwindcss: {},
      autoprefixer: {}
    }
  },
})
