import Vue from 'vue'
import Vuex from 'vuex'
import axios from 'axios'

Vue.use(Vuex);

export default new Vuex.Store({
  state: {
    shortUrl: ''
  },
  getters: {
    getShortUrl(state) {
      return state.shortUrl;
    }
  },
  mutations: {
    setShortUrl(state, shortUrl) {
      state.shortUrl = shortUrl;
    }
  },
  actions: {
    async getShortUrl(state, payload){
      let response = await axios.post("http://localhost:8000/shortUrl", payload);
      state.commit('setShortUrl', response.data);
    }
  }
})
