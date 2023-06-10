<script>
import axios from 'axios';

export default {
  name: 'ContactForm',
  data() {
    return {
      email: '',
      message: '',
      showModal: false
    };
  },
  methods: {
    toggleModal() {
      this.showModal = !this.showModal;
      if (!this.showModal) {
        this.email = '';
        this.message = '';
      }
    },
    submitForm() {
      const formData = {
        email: this.email,
        text: this.message
      };

      axios
        .post('http://localhost:8080/api/v1/messaggi', formData)
        .then(response => {
          console.log('Messaggio inviato con successo');

          // Esegui la redirezione alla homepage solo se necessario
          if (this.$route.path !== '/') {
            this.$router.push('/');
          }
        })
        .catch(error => {
          console.error(error);
          console.log('Messaggio non inviato');
        });

      this.toggleModal(); // Nascondi la modale dopo l'invio del messaggio
    }
  }
};
</script>

<template>
  <div>
    <div class="contact-button" v-if="!showModal">
      <button class="btn" @click="toggleModal">Contattaci</button>
    </div>
    <div class="modal" v-if="showModal">
      <div class="modal-content">
        <span class="close" @click="toggleModal">&times;</span>
        <h2>Contattaci</h2>
        <form @submit.prevent="submitForm" class="contact-form">
          <div class="form-group">
            <label for="email">Email:</label>
            <input type="email" id="email" v-model="email" required />
          </div>
          <div class="form-group">
            <label for="message">Messaggio:</label>
            <textarea id="message" v-model="message" required></textarea>
          </div>
          <button type="submit" class="btn btn-primary">Invia</button>
        </form>
      </div>
    </div>
  </div>
</template>



<style scoped>
.contact-button {
  text-align: right;
}

.modal {
  position: fixed;
  z-index: 9999;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  display: flex;
  align-items: center;
  justify-content: center;
  background-color: rgba(0, 0, 0, 0.4);
}

.modal-content {
  background-color: #fefefe;
  padding: 20px;
  border: 1px solid #888;
  max-width: 400px;
  width: 90%;
  max-height: 90%;
  overflow: auto;
}

.close {
  color: #aaa;
  position: absolute;
  top: 10px;
  right: 10px;
  font-size: 28px;
  font-weight: bold;
  cursor: pointer;
}

.close:hover {
  color: #000;
}

.contact-form {
  margin-top: 20px;
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
