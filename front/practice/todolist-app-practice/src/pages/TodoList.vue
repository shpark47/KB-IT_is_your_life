<template>
  <div class="row">
    <div class="col p-3">
      <router-link class="btn btn-primary" to="/todos/add">
        할일 추가
      </router-link>
    </div>
  </div>
  <div class="row">
    <div class="col">
      <ul class="list-group">
        <li class="list-group-item">
          <span class="pointer"> TodoItem 컴포넌트를 반복문을 이용하여 </span>
          <span class="float-end badge bg-secondary pointer m-1"> 편집</span>
          <span class="float-end badge bg-secondary pointer m-1"> 삭제</span>
        </li>
        <li class="list-group-item">
          <span class="pointer">todoList에 담긴 데이터로 화면에 보여주기</span>
          <span class="float-end badge bg-secondary pointer m-1"> 편집</span>
          <span class="float-end badge bg-secondary pointer m-1"> 삭제</span>
        </li>
        <li class="list-group-item">
          <span class="pointer">하단 주석 풀고 작성하기</span>
          <span class="float-end badge bg-secondary pointer m-1"> 편집</span>
          <span class="float-end badge bg-secondary pointer m-1"> 삭제</span>
        </li>
        <!-- <TodoItem/> -->
      </ul>
    </div>
  </div>
</template>
<script setup>
import { inject } from 'vue';
// TodoItem 컴포넌트 임포트

// 부모 todoList를 얻어와 todoList 변수에 담기
</script>
