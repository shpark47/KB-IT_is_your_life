<template>
  <div class="row">
    <div class="col">
      <ul class="list-group">
        <TodoListItem
          v-for="todoitem in todolist"
          :key="todoitem.id"
          :todoitem="todoitem"
        />
      </ul>
    </div>
  </div>
</template>
<script>
import TodoListItem from './TodoListItem.vue';

export default {
  name: 'TodoList',
  components: {
    TodoListItem,
  },
  props: ['todolist'],
};
</script>
