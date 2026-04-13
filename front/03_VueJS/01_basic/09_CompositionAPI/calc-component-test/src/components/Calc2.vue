<template>
  <div>
    X : <input type="text" v-model.number="x" /> <br />
    Y : <input type="text" v-model.number="y" /> <br />
    <button @click="calcAdd(x, y)">계산</button> <br />
    <div>결과 : {{ result }}</div>
  </div>
</template>
<script>
import { ref } from 'vue';
export default {
  name: 'Calc2',
  setup() {
    /* ref()
      - 원시 타입 데이터를 반응형 데이터로 변환
      - 원시 타입 데이터를 반환하는 것이 아니라 객체를 반환함

      - script 태그 내부 : ref는 객체이므로 .value로 접근해야 함
      - template 태그 내부 : Vue가 자동으로 .value를 해석하므로 생략 가능
    */

    const x = ref(10);
    const y = ref(20);
    const result = ref(30);
    const calcAdd = (num1, num2) => {
      result.value = num1 + num2;
    };
    return { x, y, result, calcAdd };
  },
};
</script>
