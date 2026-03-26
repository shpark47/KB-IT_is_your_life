<template>
  <li
    class="list-group-item"
    :class="{ 'list-group-item-success': todoitem.completed }"
  >
    <input type="checkbox" class="pointer me-3" :checked="todoitem.completed" />
    <span class="pointer" :class="todoitem.completed ? 'todo-done' : ''">
      {{ todoitem.todo }} {{ todoitem.completed ? '(완료)' : '' }}
    </span>
    <span class="float-end badge bg-secondary pointer">삭제</span>
  </li>
</template>
<script>
export default {
  name: 'TodoListItem',
  props: {
    todoitem: {
      type: Object,
      required: true,
    },
  },
};
</script>
