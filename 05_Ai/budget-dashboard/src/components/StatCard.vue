<script setup>
defineProps({
  title: String,
  value: [String, Number],
  icon: String,
  variant: { type: String, default: 'balance' },
});
</script>

<template>
  <div class="card stat-card h-100">
    <div class="card-body d-flex align-items-center">
      <div :class="['icon-circle', 'bg-' + variant, 'me-3']">
        <i :class="icon"></i>
      </div>
      <div>
        <div class="text-muted small">{{ title }}</div>
        <div class="fs-4 fw-bold">{{ value }}</div>
      </div>
    </div>
  </div>
</template>
