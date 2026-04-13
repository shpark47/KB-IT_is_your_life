<template>
  <div>
    <h2>콘솔 확인하기</h2>
  </div>
</template>

<script setup>
import axios from 'axios';

// 에러 처리 예제
const requestAPI = () => {
  const url = '/api/todos2';
  axios
    .get(url)
    .then((resp) => console.log(resp.data))
    .catch((e) => {
      console.log('에러 캐치');
      if (e instanceof Error) {
        // 객체 instanceof 타입 : 객체가 특정 타입으로 만들어졌는지 확인하는 연산자
        console.log(e.message);
      }
    });
};

requestAPI(); // 함수 호출
</script>

<style scoped></style>
