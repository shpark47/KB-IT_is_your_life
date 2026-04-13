<template>
  <div class="row">
    <div class="col p-3">
      <router-link class="btn btn-primary" to="/todos/add">
        할일 추가
      </router-link>
    </div>
  </div>
  <div class="row">
    <div class="col">
      <ul class="list-group">
        <TodoItem v-for="todoItem in todoList" :key="todoItem.id" :todoItem />
      </ul>
    </div>
  </div>
</template>
<script setup>
import TodoItem from '@/components/TodoItem.vue';
import { inject } from 'vue';
// TodoItem 컴포넌트 임포트

// 부모 todoList를 얻어와 todoList 변수에 담기
const todoList = inject('todoList');
</script>
