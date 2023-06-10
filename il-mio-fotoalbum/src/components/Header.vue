

<script>
import { RouterLink } from 'vue-router';
import ContactForm from './ContactForm.vue';

export default {
  components: {
    RouterLink,
    ContactForm
  },
  data() {
    return {
      showModal: false
    };
  },
  methods: {
    goHome() {
      this.$router.push('/');
    },
    openModal() {
      this.showModal = true;
    }
  }
};
</script>
<template>
  <header class="header">
    <div class="logo" @click="goHome">
      <img src="https://cdn-icons-png.flaticon.com/512/2793/2793830.png" alt="" class="logo-image">
    </div>
    <!-- <div class="header-buttons">
      <router-link to="/" class="btn">Home</router-link>
      <button class="btn" @click.native="openModal">Contattaci</button>
    </div> -->
    <ContactForm :showModal="showModal" />
  </header>
</template>

<style scoped>
.header {
  display: flex;
  align-items: center;
  justify-content: space-between;
  padding: 10px;
  background-color: #f1f1f1;
}

.logo {
  cursor: pointer;
}

.logo-image {
  width: 50px;
  /* Imposta la larghezza desiderata per il logo */
  height: auto;
  /* L'altezza si adatterà in base all'aspetto originale */
}

.header-buttons {
  display: flex;
  gap: 10px;
}

.contact-link {
  padding: 8px 12px;
  color: #29292a;
  text-decoration: none;
  transition: color 0.3s;
}

.contact-link:hover {
  color: red;
}
</style>
