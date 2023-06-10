<template>
  <div>
    <h1>Homepage Pubblica</h1>
    <div>
      <label for="filter">Filtra per titolo:</label>
      <input type="text" id="filter" v-model="filterText" />
    </div>
    <div v-if="loading">Caricamento...</div>
    <div v-else>
      <div v-for="foto in filteredFotoList" :key="foto.id" class="card">
        <img :src="foto.url" :alt="foto.titolo" class="card-img-top" />
        <div class="card-body">
          <h2 class="card-title">{{ foto.titolo }}</h2>
          <p class="card-text">{{ foto.descrizione }}</p>
        </div>
      </div>
    </div>
    <router-link to="/contact" class="btn btn-primary">Contattaci</router-link>
  </div>
</template>

<script>
import axios from 'axios';

export default {
  name: 'Home',
  data() {
    return {
      fotoList: [],
      filterText: '',
      loading: true
    };
  },
  mounted() {
    this.fetchFotoList();
  },
  methods: {
    fetchFotoList() {
      axios
        .get('http://localhost:8080/api/v1/foto', { params: { visible: true } })
        .then(response => {
          this.fotoList = response.data;
          this.loading = false;
        })
        .catch(error => {
          console.error(error);
        });
    }
  },
  computed: {
    filteredFotoList() {
      if (this.filterText) {
        return this.fotoList.filter(
          foto => foto.titolo.toLowerCase().includes(this.filterText.toLowerCase())
        );
      } else {
        return this.fotoList;
      }
    }
  }
};
</script>


<style scoped>
/* Stili specifici per il componente Home */
.card {
  width: 300px;
  margin-bottom: 20px;
  border: 1px solid #ccc;
  border-radius: 4px;
  padding: 10px;
}

.card-img-top {
  width: 100%;
  height: 200px;
  object-fit: cover;
}

.btn {
  display: inline-block;
  padding: 8px 12px;
  background-color: #007bff;
  color: #fff;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

.btn-primary {
  background-color: #007bff;
}

.btn-primary:hover {
  background-color: #0056b3;
}

input[type="text"],
input[type="email"],
textarea {
  width: 100%;
  padding: 8px;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
  margin-bottom: 10px;
}

textarea {
  height: 150px;
}
</style>