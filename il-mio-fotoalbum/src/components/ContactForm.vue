<template>
  <div>
    <h2>Contattaci</h2>
    <form @submit.prevent="submitForm" class="contact-form">
      <div>
        <label for="email">Email:</label>
        <input type="email" id="email" v-model="email" required />
      </div>
      <div>
        <label for="message">Messaggio:</label>
        <textarea id="message" v-model="message" required></textarea>
      </div>
      <button type="submit" class="btn btn-primary">Invia</button>
    </form>
  </div>
</template>

<script>
import axios from 'axios';
export default {
  name: 'ContactForm',
  data() {
    return {
      email: '',
      message: ''
    };
  },
  methods: {
    submitForm() {
      const formData = {
        email: this.email,
        text: this.message
      };

      axios
        .post('http://localhost:8080/api/v1/messaggi', formData)
        .then(response => {
          console.log('Messaggio inviato con successo');
          // Effettua altre operazioni dopo l'invio del messaggio, se necessario

          // Esegui la redirezione alla homepage
          this.$router.push('/');
        })
        .catch(error => {
          console.error(error);
          // Gestisci l'errore di invio del messaggio, se necessario
        });
    }
  }
};
</script>

<style scoped>
/* Stili specifici per il componente ContactForm */
.contact-form {
  max-width: 400px;
  margin: 0 auto;
}

.contact-form label {
  display: block;
  margin-bottom: 5px;
}

.contact-form input[type="email"],
.contact-form textarea {
  width: 100%;
  padding: 8px;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
  margin-bottom: 10px;
}

.contact-form textarea {
  height: 150px;
}

.contact-form button[type="submit"] {
  display: block;
  padding: 8px 12px;
  background-color: #007bff;
  color: #fff;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}
</style>
