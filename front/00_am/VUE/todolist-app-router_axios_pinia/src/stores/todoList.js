import axios from 'axios';
import { defineStore } from 'pinia';
import { computed, reactive } from 'vue';
import { onBeforeRouteUpdate, useRouter } from 'vue-router';

export const useTodoListStore = defineStore('todoList', () => {
  // axios
  const BASEURI = '/api/todos';
  const states = reactive({ todoList: [], isLoading: false });

  // 함수
  const router = useRouter();

  const fetchTodoList = async () => {
    try {
      let response = await axios.get(BASEURI);
      if (response.status == 200) {
        console.log(response.data);
        states.todoList = response.data;
      } else {
        console.log('데이터 전체 조회 실패');
      }
    } catch (e) {
      console.log('예상치 못한 에러가 발생함. 에러 정보는 ' + e);
    }
  };

  // fetchTodoList();

  const addTodo = async ({ todo, desc }) => {
    states.isLoading = true;

    try {
      let payload = {
        id: String(new Date().getTime()),
        todo,
        desc,
        done: false,
      };
      const response = await axios.post(BASEURI, payload);
      if (response.status === 201) {
        await fetchTodoList();
      } else {
        alert('Todo 추가 실패');
      }
    } catch (error) {
      alert('에러발생 :' + error);
    }
    states.isLoading = false;
  };

  const updateTodo = async ({ id, todo, desc, done }) => {
    states.isLoading = true;

    try {
      let payload = { id, todo, desc, done };
      const response = await axios.put(BASEURI + '/' + id, payload);
      if (response.status === 200) {
        await fetchTodoList();
      } else {
        alert('Todo 수정 실패');
      }
    } catch (error) {
      alert('에러발생 :' + error);
    }
    states.isLoading = false;
  };

  const deleteTodo = async (id) => {
    states.isLoading = true;
    try {
      const response = await axios.delete(BASEURI + '/' + id);
      if (response.status === 200) {
        await fetchTodoList();
        router.push('/todos');
      } else {
        alert('Todo 삭제 실패');
      }
    } catch (error) {
      alert('에러발생 :' + error);
    }
    states.isLoading = false;
  };

  const toggleDone = async (id) => {
    try {
      let todo = states.todoList.find((todo) => todo.id === id);
      todo.done = !todo.done;
      const payload = todo;
      const response = await axios.put(BASEURI + '/' + id, payload);
      if (response.status == 200) {
        await fetchTodoList();
      } else {
        alert('토글 변경 수행 중 에러 발생함.');
      }
    } catch (e) {
      alert('토글 변경 수행 중 예상치 못했던 에러 발생함. ');
    }
  };

  return { states, addTodo, updateTodo, deleteTodo, toggleDone, fetchTodoList };
});
