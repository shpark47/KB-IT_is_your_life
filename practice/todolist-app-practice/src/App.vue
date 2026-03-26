<template>
  <div id="app" class="container">
    <div class="card card-body bg-light">
      <div class="title">:: Todolist App</div>
    </div>
    <div class="card card-default panel-borderless">
      <div class="card-body">
        <InputTodo @add-todo="addTodo" />
        <TodoList
          :todolist="todoList"
          @check-completed="checkCompleted"
          @delete-todo="deleteTodo"
        />
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
      todoList: [
        { id: ts, todo: '자전거 타기', completed: false },
        { id: ts + 1, todo: '딸과 공원 산책', completed: true },
        { id: ts + 2, todo: '일요일 애견 카페', completed: false },
        { id: ts + 3, todo: 'Vue 원고 집필', completed: false },
      ],
    };
  },
  methods: {
    addTodo(todo) {
      this.todoList.push({
        id: new Date().getTime(),
        todo: todo,
        completed: false,
      });
    },

    checkCompleted(id) {
      let i = this.todoList.findIndex((item) => id === item.id);
      // TodoList.vue에서 넘겨받은 id로 todoList 배열에서 맞는 첫번째 id를 찾아서 i에 몇번째 배열에 있는지 변수저장
      this.todoList[i].completed = !this.todoList[i].completed;
    },

    deleteTodo(id) {
      let i = this.todoList.findIndex((item) => id === item.id);
      this.todoList.splice(i, 1);
    },
  },
};
</script>
