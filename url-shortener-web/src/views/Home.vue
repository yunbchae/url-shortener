<template>
  <div class="home">
    <Background />
    <SearchBar />
    <ResultBar />
  </div>
</template>

<script>
import Background from '@/components/Background.vue'
import SearchBar from '@/components/SearchBar.vue'
import ResultBar from '@/components/ResultBar.vue'

export default {
  name: 'home',
  components: {
    Background,
    SearchBar,
    ResultBar
  }
}
</script>
