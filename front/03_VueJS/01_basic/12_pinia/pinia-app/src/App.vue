<template>
  <div>
    <h1>Pinia 상태관리 예제</h1>
    <h2>좋아요 수 : {{ likeStore.like }}</h2>
    <h2>좋아요 수 5배 증가 : {{ likeStore.fivetimes }}</h2>
    <Like />
    <hr />
    <Counter />
  </div>
</template>

<script setup>
import Like from '@/components/Like.vue';
import { useLikeStore } from '@/stores/01_basic/like';
import Counter from './components/Counter.vue';

const likeStore = useLikeStore();
</script>

<style scoped></style>
