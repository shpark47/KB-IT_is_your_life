// Vue Router 라이브러리에서 필요한 함수들을 가져옴
// createRouter: Vue 라우터 인스턴스를 생성하는 함수
// createWebHistory : Html5 History Api를 사용하여 URL 경로를 관리하는 함수

// 페이지 컴포넌트 가져오기
// @ : src 폴더를 의미하는 별칭(alias)
// -> vite.config.js에 작성됨
import MembersFooter from '@/components/members/MembersFooter.vue';
import MembersLeft from '@/components/members/MembersLeft.vue';
import Home from '@/pages/Home.vue';
import MemberInfo from '@/pages/MemberInfo.vue';
import Members from '@/pages/Members.vue';
import { createRouter, createWebHistory } from 'vue-router';

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  // routes : URL 주소와 컴포넌트를 연결해놓은 설정 목록
  routes: [
    {
      path: '/', // '/' 주소로 요청이 오면
      component: Home, // import한 Home 컴포넌트
      name: 'home',
    },
    {
      path: '/members', // 해당 URL일 때
      components: {
        default: Members,
        left: MembersLeft,
        footer: MembersFooter,
      }, // 보여줄 컴포넌트
      name: 'members', // 라우터를 이름으로 부르기 위한 옵션
    },
    // 동적 라우트 패턴
    // -> URL에 따라 값이 바뀌는 라우트
    // (\\d+) : 숫자만 허용(정규표현식)
    {
      path: '/members/:id(\\d+)',
      component: MemberInfo,
      name: 'members/id',
    },
  ],
});

export default router;
