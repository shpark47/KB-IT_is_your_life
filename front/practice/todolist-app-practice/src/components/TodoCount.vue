<template>
  <div class="container text-center">
    <div class="row">
      <div class="col">
        전체 todo 개수 : <b>{{ todolist.length }}</b>
      </div>
      <div class="col">
        완료 todo 개수 : <b style="color: blue">{{ completedTodo }}</b>
      </div>
      <div class="col">
        미완료 todo 개수 : <b style="color: red">{{ uncompletedTodo }}</b>
      </div>
    </div>
  </div>
</template>
<script setup>
import { computed } from 'vue';

const props = defineProps({
  todolist: {
    type: Array,
    required: true,
  },
});

const completedTodo = computed(() => {
  return props.todolist.filter((item) => item.completed).length;
});
const uncompletedTodo = computed(() => {
  return props.todolist.filter((item) => item.completed === false).length;
});
</script>
