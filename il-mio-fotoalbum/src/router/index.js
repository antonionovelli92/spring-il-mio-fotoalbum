import { createRouter, createWebHistory } from 'vue-router';
import Home from '../components/Home.vue';
import ContactForm from '../components/ContactForm.vue';

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    { path: "/", name: "Home", component: Home },
    { path: "/contact", name: "ContactForm", component: ContactForm },
  ],
});

export default router;
