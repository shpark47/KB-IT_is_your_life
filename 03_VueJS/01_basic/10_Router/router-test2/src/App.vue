<template>
  <div class="container">
    <Header />

    <!-- RouterView 태그 : 라우터 화면 컴포넌트가 들어갈 자리 -->
    <RouterView />
  </div>
</template>

<!-- <script setup>
import Header from './components/Header.vue';
</script> -->

<script>
import Header from './components/Header.vue';
export default {
  components: { Header },
  setup() {
    // setup() : 컴포넌트 로직을 작성하는 함수
    // 템플릿에서 사용할 데이터나 함수는 반환(return)해야 한다.
  },
};
</script>

<style>
@import url('https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css');
.container {
  text-align: center;
  margin-top: 10px;
}
.fa {
  padding: 5px;
  width: 30px;
  text-align: center;
  text-decoration: none;
  margin: 5px 2px;
}
.fa-facebook {
  background: #3b5998;
  color: white;
}
.fa-youtube {
  background: #bb0000;
  color: white;
}
.fa-instagram {
  background: #125688;
  color: white;
}
</style>
