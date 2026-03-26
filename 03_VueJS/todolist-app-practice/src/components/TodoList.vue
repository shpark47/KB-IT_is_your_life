<template>
  <div class="row">
    <div class="col">
      <ul class="list-group">
        <TodoListItem
          v-for="todoitem in todolist"
          :key="todoitem.id"
          :todoitem="todoitem"
          @delete-todo="$emit('delete-todo', $event)"
          @checkbox-completed="$emit('toggle-completed', $event)"
        />
        <!-- 이벤트 방출 시 전달되는 데이터는 $event로 수신 가능 -->
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
  // props : 부모 컴포넌트에서 전달된 데이터
  props: ['todolist'],
};
</script>
