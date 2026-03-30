<template>
  <div class="row">
    <div class="col">
      <ul class="list-group">
        <TodoListItem
          v-for="todoitem in sortedTodoList"
          :key="todoitem.id"
          :todoitem="todoitem"
          @check-completed="$emit('check-completed', $event)"
          @delete-todo="$emit('delete-todo', $event)"
          @update-btn="$emit('update-btn', $event)"
          @update-todo="$emit('update-todo', $event)"
          @cancel-update="$emit('cancel-update', $event)"
          @update-pin="$emit('update-pin', $event)"
        />
      </ul>
    </div>
  </div>
</template>
<script setup>
import { computed } from 'vue';
import TodoListItem from './TodoListItem.vue';
const props = defineProps(['todolist']);

const sortedTodoList = computed(() => {
  return [...props.todolist].sort((a, b) => {
    if (a.isPinned !== b.isPinned) {
      return a.isPinned ? -1 : 1;
    }
    if (a.completed !== b.completed) {
      return a.completed ? 1 : -1;
    }
    return b.id - a.id;
  });
});
</script>
