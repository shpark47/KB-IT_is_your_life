<template>
  <div>
    <h2>콘솔 확인하기</h2>
  </div>
</template>

<script setup>
import axios from 'axios';

const BASEURL = '/api/todos';

const requestAPI = async () => {
  let todoList = [];

  try {
    let data = { todo: '복습', desc: '이해' };

    // post 요청 : 데이터 추가

    const resp = await axios.post(BASEURL, data);

    console.log(resp.data);
  } catch (e) {
    console.log(e);
  }
};

requestAPI(); // 함수 호출
</script>

<style scoped></style>
