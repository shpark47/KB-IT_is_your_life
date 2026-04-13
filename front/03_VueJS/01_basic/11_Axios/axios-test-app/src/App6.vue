<template>
  <div>
    <h2>콘솔 확인하기</h2>
  </div>
</template>

<script setup>
/* try-catch
  try{ } : 예외가 발생할 가능성이 있는 코드
  catch(e){ } : 예외 발생 시 수행할 코드
  finally{ } : 마지막에 무조건 수행
*/

import axios from 'axios';

// 에러 처리 예제
const requestAPI = async () => {
  try {
    // 에러 발생 시 즉시 종료 후 catch문으로 이동
    const url = '/api/todos2';
    let resp = await axios.get(url);
    console.log(resp.data);
  } catch (e) {
    console.log('에러 발생 시에만 수행');
    if (e instanceof Error) {
      // 객체 instanceof 타입 : 객체가 특정 타입으로 만들어졌는지 확인하는 연산자
      console.log(e.message);
    }
  } finally {
    console.log('finally는 무조건 수행');
  }
};

requestAPI(); // 함수 호출
</script>

<style scoped></style>
