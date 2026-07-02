<script setup>
// username 문자열 props 받음
defineProps({ username: String });
</script>
<template>
  <!-- 네비게이션 항목 -->
  <li class="nav-item">
    <!-- 프로필 페이지로 이동하는 링크 -->
    <router-link class="nav-link" to="/auth/profile">
      <!-- 사용자 아이콘 -->
      <i class="fa-solid fa-user"></i>
      <!-- 사용자 이름 표시 -->
      {{ username }}
    </router-link>
  </li>
</template>
