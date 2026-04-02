<template>
  <div class="mt-5">
    <img :src="member.photo" :alt="member.name" class="img" />
    <h4>{{ member.name }} - {{ member.role }}</h4>
    <p>{{ member.desc }}</p>
    <a
      :href="member.insta"
      v-if="member.insta && member.insta != ''"
      class="fa fa-instagram"
    ></a>
    <a
      :href="member.facebook"
      v-if="member.facebook && member.facebook != ''"
      class="fa fa-facebook"
    ></a>
    <a
      :href="member.youtube"
      v-if="member.youtube && member.youtube != ''"
      class="fa fa-youtube"
    ></a>
  </div>
</template>

<script setup>
import members from '@/members.json';

// 현재 컴포넌트와 관련된 세부정보를 얻어오기 위한 함수
// path, 전달된 파라미터 id 추출
import { useRoute } from 'vue-router';

// 전달된 id를 꺼내서 id로 json에서 개인정보 검색한 후 템플릿에 출력

const route = useRoute();
// 주소로 전달받은 파라미터는 항상 문자열로 인식
// json에 있는 id는 정수 전달받은 파라미터는 문자열
// 파라미터를 정수로 변경 -> parseInt(바꿀 값, 진수) 함수
const id = parseInt(route.params.id, 10);

// members 안에 있는 것들을 하나씩 꺼내 m에 넣고
// 한 사람에 대한 정보 객체리터럴인 m에 있는 id와 전달받은 파라미터가 같은지 확인하여
// 해당 객체 리터럴을 검색
const member = members.find((m) => m.id === id);
</script>

<style></style>
