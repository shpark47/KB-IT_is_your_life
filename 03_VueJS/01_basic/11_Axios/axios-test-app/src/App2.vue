<template>
  <div>
    <h2>콘솔 확인하기</h2>
  </div>
</template>

<script setup>
import axios from 'axios';

const listUrl = '/api/todos';
const todoUrlPrefix = 'api/todos/';

// 4건의 목록을 조회한 후 첫 번째, 두 번째 할일 순차적으로 조회
const requestAPI = async () => {
  let todoList; // todo 목록을 담을 변수

  // 1. 전체 목록 조회
  // Promise가 끝날때까지 기다림
  let response = await axios.get(listUrl);
  todoList = response.data;
  console.log('## TodoList : ', todoList);

  // 2. 첫 번째 Todo 조회
  response = await axios.get(todoUrlPrefix + todoList[0].id);
  console.log('## 첫 번째 Todo : ', response.data);
  // Promise(pending) : 아직 결과가 안나온 상태
  // -> await로 기다려야함

  // 3. 두 번째 Todo 조회
  response = await axios.get(todoUrlPrefix + todoList[1].id);
  console.log('## 두 번째 Todo : ', response.data);
};

requestAPI(); // 함수 호출
</script>

<style scoped></style>
