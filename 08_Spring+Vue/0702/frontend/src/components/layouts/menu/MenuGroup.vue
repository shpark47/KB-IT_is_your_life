<script setup>
// 메뉴 항목 컴포넌트 import
import MenuItem from './MenuItem.vue';
// menus 배열 props 받음
const props = defineProps({
  menus: { Type: Array, required: true },
});
</script>
<template>
  <!-- 네비게이션 리스트 -->
  <ul class="navbar-nav">
    <!-- 메뉴 배열 반복 렌더링 -->
    <MenuItem v-for="menu in menus" :menu="menu" />
  </ul>
</template>
