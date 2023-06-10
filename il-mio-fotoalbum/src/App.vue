<template>
  <div>
    <nav>
      <router-link to="/">Home</router-link>
      <router-link to="/contact">Contattaci</router-link>
    </nav>
    <router-view></router-view>
  </div>
</template>

<script>
import { RouterLink, RouterView } from 'vue-router';

export default {
  name: 'App',
  components: {
    RouterLink,
    RouterView
  }
};
</script>

<style scoped>
/* Stili specifici per l'applicazione */
nav {
  background-color: #f1f1f1;
  padding: 10px;
  margin-bottom: 20px;
}

nav a {
  margin-right: 10px;
}
</style>
