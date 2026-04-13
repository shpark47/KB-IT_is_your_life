<template>
  <div>
    <h2>TodoList 테스트(Composition API)</h2>
    <hr />
    할일 추가:<input type="text" v-model="todo" />

    <button @click="addTodoHandler">추가</button>
    <hr />
    <ul>
      <li v-for="todoItem in todoList">
        <span style="cursor: pointer" @click="toggleDone(todoItem.id)">
          {{ todoItem.todo }} {{ todoItem.done ? '(완료)' : '' }}
        </span>
        &nbsp;&nbsp;&nbsp;

        <button @click="deleteTodo(todoItem.id)">삭제</button>
      </li>
    </ul>
    <div>완료된 할일 수 : {{ doneCount }}</div>
  </div>
</template>
<script setup>
import { useTodoListStore } from '@/stores/todoList.js';
import { ref, computed } from 'vue';
const todo = ref('');
const todoListStore = useTodoListStore();
const { todoList, addTodo, deleteTodo, toggleDone } = todoListStore;

//변수에 넣었다가 출력하는 경우에는 computed()해줌. --> 바로 출력하는 경우 필요없음.
const doneCount = computed(() => todoListStore.doneCount); //todoListStore.doneCount;

const addTodoHandler = () => {
  addTodo(todo.value);
  todo.value = '';
};
</script>
