<template>
  <div class="row mb-3">
    <div class="col">
      <div class="input-group">
        <input
          type="text"
          class="form-control"
          v-model="todo"
          @keyup.enter="addTodo"
        />
        <button class="btn btn-primary" type="button" @click="addTodo">
          추가
        </button>
      </div>
    </div>
  </div>
</template>
<script setup>
import { ref } from 'vue';

const todo = ref('');
const emit = defineEmits(['add-todo']);
const addTodo = () => {
  if (todo.value.length >= 3) {
    emit('add-todo', todo.value);
    todo.value = '';
    return;
  }
  alert('할일은 3글자 이상 입력해주세요');
};
</script>
