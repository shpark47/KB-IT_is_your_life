<template>
  <div class="m-3">
    <h3>존재하지 않는 경로</h3>

    <!-- 작성하기 -->
    <p>요청 경로 : {{ route.fullPath }}</p>
  </div>
</template>
<script setup>
import { useRoute } from 'vue-router';

const route = useRoute();
</script>
