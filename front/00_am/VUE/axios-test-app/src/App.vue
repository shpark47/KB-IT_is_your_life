<template>
  <div>콘솔 확인.</div>
</template>

<script setup>
// axios로 json-server로 접속해서 todos의 crud작업을 해보려고 함.
import axios from 'axios';

// axios 함수
const requestAPI = () => {
  // const url = 'http://localhost:3000/todos/2';
  const url = '/api/todos/2';
  // let result = axios.get(url);
  // console.log(result);
  // axios.get(url).then(get 한 이후 결과를 처리할 내용).catch(에러가 발생했을 때 처리할 내용);
  axios
    .get(url)
    .then((response) => {
      console.log(response.data);
    })
    .catch((e) => {
      console.log(e);
    });
};

const requestAPI2 = async () => {
  const url = '/api/todos/22';
  // 원격으로 http를 연결할 때는 네트워크로 연결하므로 에러가 발생할 가능성이 크다.
  // 에러 처리도 같이 해주면 좋음.
  // async~await인 경우에는 try~catch로 해주고.
  // then인 경우에는 catch만 붙여주면됨
  try {
    // 에러 발생할 여지가 큰 코드를 넣어줌
    let response = await axios.get(url);
    console.log(response.data);
  } catch (e) {
    // try 안에서 에러가 발생하면 catch함수 자동으로 호출
    console.log(e);
  }
};

// 함수 호출
// requestAPI();
requestAPI2();
</script>

<style scoped></style>
