<script>
import { RouterLink, RouterView } from 'vue-router';
import Header from '../src/components/Header.vue';

export default {
  name: 'App',
  components: {
    RouterLink,
    RouterView,
    Header,
  }
};
</script>

<template>
  <div>
    <Header />
    <router-view></router-view>
  </div>
</template>


<style scoped>
/* Stili specifici per l'applicazione */
</style>
