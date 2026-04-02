<template>
  <div class="modal">
    <div class="box">
      <div class="heading">
        {{ videoInfo.video.title }} - {{ videoInfo.video.category }}
      </div>
      <div class="player">
        <YoutubeVue3
          :videoid="videoInfo.video.id"
          :autoplay="1"
          :controls="1"
        ></YoutubeVue3>
      </div>
      <div>
        <div>
          <i class="fa fa-backward ml-2 pointer" @click="playPrev"></i>
          <i class="fa fa-stop ml-2 pointer" @click="stopVideo"></i>
          <i class="fa fa-forward ml-2 pointer" @click="playNext"></i>
        </div>
      </div>
    </div>
  </div>
</template>

<script setup>
import { inject, ref, reactive } from 'vue';
import { useRoute, useRouter, onBeforeRouteUpdate } from 'vue-router';
import { YoutubeVue3 } from 'youtube-vue3';

// 제목을 전달받은 id로 검색해서 출력
const videos = inject('videos');

// 전달받은 id 받을 목적
const route = useRoute();

// 이전, 이후 버튼 눌렀을 때 해당하는 id로 비디오플레이어를 다시 라우팅 하기 위함
// 주소는 route/index.js에 있어야함
// router-link태그와 같은 역할, js에서 라우팅을 하는 경우 router객체 사용
const router = useRouter();

// 전달받은 파라미터인 id를 가지고 해당 video 찾기
let videoInfo = reactive({
  video: videos.find((v) => v.id === route.params.id),
});
</script>

<style scoped>
.modal {
  display: block;
  position: fixed;
  z-index: 1;
  left: 0;
  top: 0;
  width: 100%;
  height: 100%;
  background-color: rgba(0, 0, 0, 0.4);
}

.box {
  background-color: white;
  margin: 80px auto;
  max-width: 500px;
  min-height: 350px;
  padding: 10px;
}

.box .heading {
  background: #33a17f;
  color: white;
  padding: 10px;
}

.pointer {
  cursor: pointer;
}
</style>
