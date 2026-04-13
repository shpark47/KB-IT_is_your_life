<template>
  <li
    class="list-group-item"
    :class="{ 'list-group-item-success': todoitem.completed }"
  >
    <span class="pointer me-3" @click="updatePin">{{
      todoitem.isPinned ? '📌' : '📍'
    }}</span>
    <input
      type="checkbox"
      class="pointer me-3"
      :checked="todoitem.completed"
      @click="checkCompleted"
    />
    <span
      v-if="todoitem.isEditing == false"
      class="pointer"
      :class="todoitem.completed ? 'todo-done' : ''"
      @click="checkCompleted"
    >
      {{ todoitem.todo }} {{ todoitem.completed ? '(완료)' : '' }}
    </span>
    <input
      v-else
      ref="editInput"
      :value="todoitem.todo"
      @keyup.enter="updateTodo"
      @keyup.esc="cancelUpdate"
      @blur="cancelUpdate"
    />
    <span class="float badge bg-success pointer" @click="updateBtn">수정</span>
    <span class="float-end badge bg-secondary pointer" @click="deleteTodo"
      >삭제</span
    >
  </li>
</template>
<script setup>
import { nextTick, ref } from 'vue';

const props = defineProps({
  todoitem: {
    type: Object,
    required: true,
  },
});

const emits = defineEmits([
  'check-completed',
  'delete-todo',
  'update-btn',
  'update-todo',
  'cancel-update',
  'update-pin',
]);

const checkCompleted = () => {
  emits('check-completed', props.todoitem.id);
};
const deleteTodo = () => {
  emits('delete-todo', props.todoitem.id);
};

const editInput = ref(null);

const updateBtn = () => {
  emits('update-btn', props.todoitem.id);
  nextTick(() => {
    editInput.value.focus();
  });
};

const updateTodo = (e) => {
  if (e.target.value.trim().length == 0) {
    alert('빈칸으로 수정할 수 없습니다.');
  } else {
    emits('update-todo', { id: props.todoitem.id, todo: e.target.value });
  }
};

const cancelUpdate = () => {
  emits('cancel-update', props.todoitem.id);
};

const updatePin = () => {
  emits('update-pin', props.todoitem.id);
};
</script>
