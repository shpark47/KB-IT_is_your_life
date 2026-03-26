<template>
  <li
    class="list-group-item"
    :class="{ 'list-group-item-success': todoitem.completed }"
  >
    <!-- :class="{클래스명 : 조건}" : 조건이 true면 클래스 추가 -->

    <!-- <input type="checkbox" class="pointer me-3" v-model="todoitem.completed" /> -->
    <!-- 객체 props에 v-mdoel을 쓰면 부모 데이터도 같이 바뀐다. 
    -> 하지만 props는 읽기 전용이 원칙이라서 권장 X 
    -> 해결 : 자식 컴포넌트에서 $emit으로 부모에게 알려서 바꾸자!
    -->
    <input
      type="checkbox"
      class="pointer me-3"
      :checked="todoitem.completed"
      @click="$emit('checkbox-completed', todoitem.id)"
    />

    <span class="pointer" :class="{ 'todo-done': todoitem.completed }">
      {{ todoitem.todo }}
      {{ todoitem.completed ? '(완료)' : '' }}
      <!-- 삼항연산자 : 조건식 ? true : false -->
    </span>
    <span
      class="float-end badge bg-secondary pointer"
      @click="$emit('delete-todo', todoitem.id)"
      >삭제</span
    >
  </li>
</template>
<script>
export default {
  name: 'TodoListItem',
  // props : 부모 컴포넌트에서 전달된 데이터 수신
  props: {
    todoitem: { type: Object, required: true },
  },
};
</script>
