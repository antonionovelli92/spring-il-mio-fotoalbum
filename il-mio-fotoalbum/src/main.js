import { createApp } from 'vue';
import router from './router';  // Importa l'istanza del router corretta
import App from './App.vue';
import 'bootstrap/dist/css/bootstrap.min.css';

const app = createApp(App);
app.use(router);  // Utilizza il router

app.mount('#app');
