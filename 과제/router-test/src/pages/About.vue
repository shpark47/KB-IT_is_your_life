<template>
  <div class="card card-body">
    <h2>About</h2>
    <p>요청 경로 : {{ path }}</p>
  </div>
</template>

<script>
export default {
  name: 'About',
};
</script>
<script setup>
import { useRoute } from 'vue-router';

const route = useRoute();
const path = route.fullPath;
console.log(`요청 경로 : ${route}`);
</script>

<style scoped></style>
