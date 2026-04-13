import { createRouter, createWebHistory } from 'vue-router';
import Home from '@/pages/Home.vue';
import About from '@/pages/About.vue';
import Members from '@/pages/Members.vue';
import Videos from '@/pages/Videos.vue';
import AboutSetup from '@/pages/AboutSetup.vue';
import AboutComp from '@/pages/AboutComp.vue';
import MemberInfo from '@/pages/MemberInfo.vue';

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: Home,
    },
    {
      path: '/about',
      name: 'about',
      component: AboutComp,
    },
    {
      path: '/members',
      name: 'members',
      component: Members,
    },
    {
      path: '/members/:id',
      name: 'memberInfo',
      component: MemberInfo,
    },
    {
      path: '/videos',
      name: 'videos',
      component: Videos,
    },
  ],
});

export default router;
