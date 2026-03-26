<template>
  <div class="row">
    <div class="col">전체 todo 개수 : {{ todolist.length }}</div>
    <div class="col">완료 todo 개수 : {{ completedTodo }}</div>
    <div class="col">미완료 todo 개수 : {{ uncompletedTodo }}</div>
  </div>
</template>
<script>
export default {
  name: 'TodoCount',
  props: {
    todolist: {
      type: Array,
      required: true,
    },
  },
  computed: {
    completedTodo() {
      return this.todolist.filter((item) => item.completed).length;
    },
    uncompletedTodo() {
      return this.todolist.filter((item) => item.completed === false).length;
    },
  },
};
</script>
