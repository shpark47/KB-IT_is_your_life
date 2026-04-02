<template>
  <div class="card card-body">
    <h2>Videos 영상리스트</h2>
    <ul class="list-group">
      <li v-for="v in videos" :key="v.id" class="list-group-item">
        {{ v.title }}
        <router-link :to="{ name: 'videos/id', params: { id: v.id } }">
          <span class="float-end badge bg-secondary">듣기</span>
        </router-link>
      </li>
    </ul>

    <!-- 중첩 되어서 들어갈 자리를 만들어야함 -->
    <router-view></router-view>
  </div>
</template>
<script>
import { inject } from 'vue';

export default {
  name: 'Videos',
  setup() {
    // App.vue에서 provide된 videos를 지정해서 가지고옴
    const videos = inject('videos');
    return { videos };
  },
};
</script>
<style></style>
