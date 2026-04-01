<template>
  <div class="card card-body">
    <h2>Member Info</h2>
    <div>
      경로 패턴 : /members/:id<br />
      요청 경로 : {{ route.fullPath }}<br />
      id값 : {{ route.params.id }}<br />
    </div>
  </div>
</template>

<script setup>
import { useRoute } from 'vue-router';

const route = useRoute();
</script>

<style scoped></style>
