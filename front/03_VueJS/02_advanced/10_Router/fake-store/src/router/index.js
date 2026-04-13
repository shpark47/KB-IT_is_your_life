import ElectronicsPage from '@/pages/ElectronicsPage.vue';
import HomePage from '@/pages/HomePage.vue';
import JeweleryPage from '@/pages/JeweleryPage.vue';
import MensClothingPage from '@/pages/MensClothingPage.vue';
import WomensClothingPage from '@/pages/WomensClothingPage.vue';
import { createRouter, createWebHistory } from 'vue-router';

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      component: HomePage,
      name: 'home',
    },
    {
      path: '/electronics',
      component: ElectronicsPage,
      name: 'electronics',
    },
    {
      path: '/jewelery',
      component: JeweleryPage,
      name: 'jewelery',
    },
    {
      path: '/mensclothing',
      component: MensClothingPage,
      name: "men's clothing",
    },
    {
      path: '/womensclothing',
      component: WomensClothingPage,
      name: "women's clothing",
    },
  ],
});

export default router;
