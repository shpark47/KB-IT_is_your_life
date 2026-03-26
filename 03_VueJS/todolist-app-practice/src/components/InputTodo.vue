<template>
  <div class="row mb-3">
    <div class="col">
      <div class="input-group">
        <input
          type="text"
          class="form-control"
          placeholder="할일을 여기에 입력!"
          v-model="todo"
          @keyup.enter="addTodoHanlder"
        />
        <button class="btn btn-primary" type="button" @click="addTodoHanlder">
          추가
        </button>
      </div>
    </div>
  </div>
</template>
<script>
export default {
  name: 'InputTodo',
  data() {
    return { todo: '' };
  },
  methods: {
    addTodoHanlder() {
      // 할일이 3글자 이상인 경우에만
      if (this.todo.length >= 3) {
        // 부모 컴포넌트에 이벤트 전달(방출)
        this.$emit('addTodo', this.todo);
        this.todo = ''; // input 초기화
        return; // 메소드 종료 == 밑에 코드 수행 X
      }

      alert('할 일은 3글자 이상 입력해주세요.');
    },
  },
  emits: ['addTodo'],
  // 이벤트 방출 검사
  // -> 부모 컴포넌트로 전달되는 이벤트가
  //    addTodo가 맞는지 검사
};
</script>
