<script setup>
import { RouterLink, RouterView } from 'vue-router';
</script>

<template>
  <div class="app-wrapper">
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark shadow-sm">
      <div class="container-fluid">
        <RouterLink class="navbar-brand fw-bold" to="/">
          <i class="fas fa-wallet text-warning me-2"></i>MyBudget
        </RouterLink>
        <div class="navbar-nav">
          <RouterLink class="nav-link" to="/">
            <i class="fas fa-chart-pie me-1"></i> 대시보드
          </RouterLink>
          <RouterLink class="nav-link" to="/transactions">
            <i class="fas fa-list me-1"></i> 거래내역
          </RouterLink>
        </div>
      </div>
    </nav>
    <main class="container-fluid py-4">
      <RouterView />
    </main>
  </div>
</template>
