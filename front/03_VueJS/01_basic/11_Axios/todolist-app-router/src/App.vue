<template>
  <div class="container">
    <Header />
    <router-view />
  </div>
</template>
<script setup>
import { reactive, computed, provide } from 'vue';
import Header from '@/components/Header.vue';
import axios from 'axios';

const states = reactive({
  todoList: [],
});

const BASEURI = '/api/todos';

// 1. 컴포넌트 초기화될때 json-server로 연결해서 전체 목록 가지고 와야함
// 2. 백엔드 서버로부터 가지고 온 목록을 todoList에 넣어줘야함
// 3. 화면에 todoList목록을 보여줌

const fetchTodoList = async () => {
  // axios
  try {
    const response = await axios.get(BASEURI);
    if (response.status === 200) {
      console.log(response.data); // console 확인
      states.todoList = response.data;
    } else {
      alert('데이터 조회 실패');
    }
  } catch (error) {
    console.log(`예상치 못한 에러가 발생함 : ${error}`);
  }
};

fetchTodoList(); // 시작하자마자 함수 호출

const addTodo = async ({ todo, desc }) => {
  let payload = {
    id: new Date().getTime(),
    todo,
    desc,
    done: false,
  };

  try {
    const response = await axios.post(BASEURI, payload);
    if (response.status === 201) {
      await fetchTodoList();
    } else {
      console.log('데이터 입력 실패');
    }
  } catch (e) {
    console.log(e);
  }
  // states.todoList.push({ id: new Date().getTime(), todo, desc, done: false });
};
const updateTodo = ({ id, todo, desc, done }) => {
  let index = states.todoList.findIndex((todo) => todo.id === id);
  states.todoList[index] = { id, todo, desc, done };
};
const deleteTodo = (id) => {
  let index = states.todoList.findIndex((todo) => todo.id === id);
  states.todoList.splice(index, 1);
};
const toggleDone = (id) => {
  let index = states.todoList.findIndex((todo) => todo.id === id);
  states.todoList[index].done = !states.todoList[index].done;
};
provide(
  'todoList',
  computed(() => states.todoList),
);
provide('actions', { addTodo, deleteTodo, toggleDone, updateTodo });
</script>
