
<script>
import Header from './Header.vue';
import axios from 'axios';
export default {
  name: 'Home',
  components: { Header },
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
<template>
  <div>
    <div class="container">
      <h1>FotoAlbum</h1>
      <div class="filter-container">
        <label for="filter">Filtra per titolo: </label>
        <input class="mx-2" type="text" id="filter" v-model="filterText" />
      </div>
      <div v-if="loading">Caricamento...</div>
      <div v-else>
        <div class="card-container d-flex justify-content-center">
          <div v-for="foto in filteredFotoList" :key="foto.id" class="card">
            <img :src="foto.url" :alt="foto.titolo" class="card-img-top" />
            <div class="card-body">
              <h2 class="card-title">{{ foto.titolo }}</h2>
              <p class="card-text">{{ foto.descrizione }}</p>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>


<style scoped>
.filter-container {
  margin-bottom: 20px;
}

.card-container {
  display: flex;
  flex-wrap: wrap;
  gap: 20px;
}

.card {
  width: 300px;
  margin-bottom: 20px;
  border: 1px solid #ccc;
  border-radius: 4px;
  padding: 10px;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
  transition: transform 0.3s ease;
}

.card:hover {
  transform: scale(1.05);
  cursor: pointer;
}

.card-img-top {
  width: 100%;
  height: 200px;
  object-fit: cover;
}
</style>
