<template>
  <div class="card card-body">
    <h2>About</h2>
    <p>요청 경로 : {{ route.fullPath }}</p>
  </div>
</template>

<script>
import { useRoute } from 'vue-router';

export default {
  name: 'About',

  setup() {
    const route = useRoute();
    console.log(route);

    return { route };
  },
};
</script>

<style scoped></style>
