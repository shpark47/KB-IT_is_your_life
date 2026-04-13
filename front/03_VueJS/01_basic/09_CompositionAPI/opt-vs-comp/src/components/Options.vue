<template lang="">
  <div>
    <h3>Options API 적용</h3>

    <div>
      이름 :
      <input
        type="text"
        placeholder="입력 시 대문자로 변환"
        :value="name"
        @input="changeName($event.target.value)"
      />
      <!-- $event.target : 이벤트가 발생한 요소 -->
    </div>
    <hr />

    <h5>계산하기</h5>
    <div>
      X : <input type="text" v-model.number="x" /><br />
      Y : <input type="text" v-model.number="y" /><br />
      <button @click="calculateSum(x, y, 1)">X + Y</button>
      <p>X + Y = {{ sum }}</p>
    </div>

    <div>
      A : <input type="text" v-model.number="a" /><br />
      B : <input type="text" v-model.number="b" /><br />
      <button @click="calculateSum(a, b, 2)">A + B</button>
      <p>A + B = {{ sum2 }}</p>
    </div>
  </div>
</template>
<script>
export default {
  name: 'Options',
  data() {
    return {
      name: '',
      x: 3,
      y: 5,
      a: 4,
      b: 5,
      sum: 0,
      sum2: 0,
    };
  },

  methods: {
    changeName(inputName) {
      // console.log(inputName);
      // 문자열.toUpperCase() : 대문자로 변환
      // inputName.toUpperCase();
      this.name = inputName.toUpperCase();
    },

    // 계산용 메소드
    calculateSum(num1, num2, type) {
      if (type === 1) {
        // x + y 버튼 클릭 시
        this.sum = num1 + num2;
      } else {
        // a + b 버튼 클릭 시
        this.sum2 = num1 + num2;
      }
    },

    // calculateSum2(a, b) {
    //   this.result2 = a + b;
    // },
  },
};
</script>
<style lang=""></style>
