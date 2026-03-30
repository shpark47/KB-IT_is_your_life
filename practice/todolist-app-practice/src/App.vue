<template>
  <div id="app" class="container">
    <div class="card card-body bg-light">
      <div class="title">:: Todolist App</div>
    </div>
    <div class="card card-default panel-borderless">
      <div class="card-body">
        <InputTodo @add-todo="addTodo" />
        <TodoCount :todolist="todoList" />
        <TodoList
          :todolist="todoList"
          @check-completed="checkCompleted"
          @delete-todo="deleteTodo"
          @update-btn="updateBtn"
          @update-todo="updateTodo"
          @cancel-update="cancelUpdate"
          @update-pin="updatePin"
        />
      </div>
    </div>
  </div>
</template>

<script setup>
import TodoList from './components/TodoList.vue';
import InputTodo from './components/InputTodo.vue';
import TodoCount from './components/TodoCount.vue';
import { reactive } from 'vue';
let ts = new Date().getTime();
const todoList = reactive([
  {
    id: ts,
    todo: '자전거 타기',
    completed: false,
    isEditing: false,
    isPinned: false,
  },
  {
    id: ts + 1,
    todo: '딸과 공원 산책',
    completed: true,
    isEditing: false,
    isPinned: false,
  },
  {
    id: ts + 2,
    todo: '일요일 애견 카페',
    completed: false,
    isEditing: false,
    isPinned: false,
  },
  {
    id: ts + 3,
    todo: 'Vue 원고 집필',
    completed: false,
    isEditing: false,
    isPinned: false,
  },
]);

const addTodo = (todo) => {
  todoList.push({
    id: new Date().getTime(),
    todo: todo,
    completed: false,
    isEditing: false,
    isPinned: false,
  });
};

const checkCompleted = (id) => {
  let i = todoList.findIndex((item) => id === item.id);
  // TodoList.vue에서 넘겨받은 id로 todoList 배열에서 맞는 첫번째 id를 찾아서 i에 몇번째 배열에 있는지 변수저장
  todoList[i].completed = !todoList[i].completed;
  todoList[i].isPinned = false;
};

const deleteTodo = (id) => {
  let i = todoList.findIndex((item) => id === item.id);
  todoList.splice(i, 1);
};

const updateBtn = (id) => {
  let i = todoList.findIndex((item) => id === item.id);
  todoList[i].isEditing = true;
};

const updateTodo = (data) => {
  let i = todoList.findIndex((item) => data.id === item.id);
  todoList[i].isEditing = false;
  todoList[i].completed = false;
  todoList[i].todo = data.todo;
};

const cancelUpdate = (id) => {
  let i = todoList.findIndex((item) => id === item.id);
  todoList[i].isEditing = false;
};

const updatePin = (id) => {
  let i = todoList.findIndex((item) => id === item.id);
  todoList[i].isPinned = !todoList[i].isPinned;
};
</script>
