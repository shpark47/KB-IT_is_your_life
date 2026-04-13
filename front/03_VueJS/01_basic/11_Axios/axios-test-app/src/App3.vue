<template>
  <div>
    <h2>콘솔 확인하기</h2>
  </div>
</template>

<script setup>
import axios from 'axios';

const listUrl = '/api/todos';
const todoUrlPrefix = 'api/todos/';

// 전체 목록을 조회한 후 한 건씩 순차적으로 순회하면서 조회하기
const requestAPI = async () => {
  let response = await axios.get(listUrl);
  let todoList = response.data;
  console.log('## 전체 목록 : ', todoList);

  for (let i in todoList) {
    response = await axios.get(todoUrlPrefix + todoList[i].id);
    console.log(`## ${parseInt(i) + 1} 번째 Todo : `, response.data);
  }
};

requestAPI(); // 함수 호출
</script>

<style scoped></style>
