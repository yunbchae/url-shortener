import Vue from 'vue'
import Vuex from 'vuex'
import axios from 'axios'

Vue.use(Vuex);

export default new Vuex.Store({
  state: {
    shortUrl: '',
    isUrl: true,
    isCopied: false
  },
  getters: {
    getShortUrl(state) {
      return state.shortUrl;
    },
    getIsUrl(state) {
      return state.isUrl;
    },
    getIsCopied(state) {
      return state.isCopied;
    }
  },
  mutations: {
    setShortUrl(state, shortUrl) {
      state.shortUrl = shortUrl;
    },
    setIsUrl(state, isUrl) {
      state.isUrl = isUrl;
    },
    setIsCopied(state, isCopied) {
      state.isCopied = isCopied;
    }
  },
  actions: {
    async getShortUrl(state, payload){
      let response = await axios.post("http://localhost:8000/shortUrl", payload);
      state.commit('setShortUrl', response.data);
      state.commit('setIsUrl', true);
    }
  }
})
