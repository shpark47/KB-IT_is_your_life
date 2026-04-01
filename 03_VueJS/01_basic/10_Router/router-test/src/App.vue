<template>
  <div class="container">
    <Header />
    <router-view></router-view>
  </div>
</template>

<script setup>
import Header from './components/Header.vue';
</script>

<style scoped>
.container {
  text-align: center;
  margin-top: 10px;
}
</style>
