<template>
  <div class="home">
    <h1 class="main-title">URL <span class="thin">Shortener</span></h1>
    <Background />
    <WrongUrlAlert />
    <SearchBar />
    <copySuccessAlert />
    <ResultBar />
  </div>
</template>

<script>
import Background from '@/components/Background.vue'
import SearchBar from '@/components/SearchBar.vue'
import ResultBar from '@/components/ResultBar.vue'
import WrongUrlAlert from '@/components/WrongUrlAlert.vue'
import CopySuccessAlert from '@/components/CopySuccessAlert.vue'

export default {
  name: 'home',
  components: {
    Background,
    SearchBar,
    ResultBar,
    WrongUrlAlert,
    CopySuccessAlert
  }
}
</script>

<style>
  .main-title {
    position: absolute;
    margin: 0;
    padding: 0;
    color: #f9f1e9;
    text-align: center;
    top: 3%;
    left: 3%;
  }

  .main-title {
    text-transform: uppercase;
    font-size: 3.5em;
    letter-spacing: 0.1em;
  }

  .main-title .thin {
    font-weight: 200;
  }
</style>