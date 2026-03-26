<template>
  <div id="app" class="container">
    <div class="card card-body bg-light">
      <div class="title">:: Todolist App</div>
    </div>
    <div class="card card-default panel-borderless">
      <div class="card-body">
        <InputTodo @addTodo="addTodo" />

        <!-- 목록 컴포넌트
             props를 이용해서 todoList를 자식 컴포넌트로 전달 
        -->
        <TodoList
          :todolist="todoList"
          @delete-todo="deleteTodo"
          @toggle-completed="toggleCompleted"
        />
        <!-- :todolist -> 자식에게 todolist라는 속성으로 todoList(데이터) 전달 -->
        <!-- @delete-todo : 자식으로부터 delete-todo라는 이벤트가 감지되면 
            "deleteTodo" : 해당 메소드를 호출한다.
        -->
        <!-- deleteTodo ==  deleteTodo($event) 
         -> 미작성 시 Vue 내부적으로 추가-->
      </div>
    </div>
  </div>
</template>
<script>
import TodoList from './components/TodoList.vue';
import InputTodo from './components/InputTodo.vue';
let ts = new Date().getTime();
export default {
  name: 'App',
  components: { InputTodo, TodoList },
  data() {
    return {
      // props로 전달할 부모 데이터
      todoList: [
        { id: ts, todo: '자전거 타기', completed: false },
        { id: ts + 1, todo: '딸과 공원 산책', completed: true },
        { id: ts + 2, todo: '일요일 애견 카페', completed: false },
        { id: ts + 3, todo: 'Vue 원고 집필', completed: false },
      ],
    };
  },
  methods: {
    // 할일 삭제
    deleteTodo(id) {
      //console.log(id);

      // id가 일치하는 요소의 index를 찾아 변수에 담기
      let index = this.todoList.findIndex((ele) => id === ele.id);
      //console.log(index);

      // splice(시작index, 삭제개수)
      this.todoList.splice(index, 1);
    },
    // 체크 박스 선택
    toggleCompleted(id) {
      // console.log(id);

      // 배열.findIndex((item) => 조건) : 조건이 true가 되는 첫 번째 요소의 index 반환
      // 없는 경우 -1 반환
      let index = this.todoList.findIndex((item) => id === item.id);
      // ==  (동등 비교) : 값만 비교
      // === (동일 비교) : 값 + 타입까지 비교
      //console.log(index);

      //console.log(this.todoList[index]);
      //console.log(this.todoList[index].completed);
      //console.log(!this.todoList[index].completed);
      // !true/false : true -> false, false -> true로 변경

      // 기존의 completed값을 반대로 변경
      this.todoList[index].completed = !this.todoList[index].completed;
      //console.log(this.todoList[index].completed);
    },

    /**
     * 할일 추가
     * @param todo InputTodo에서 전달된 todo(할일 내용)
     */
    addTodo(todo) {
      //console.log(todo);
      this.todoList.push({
        id: Date.now(),
        todo: todo,
        completed: false,
      });
    },
  },
};
</script>
