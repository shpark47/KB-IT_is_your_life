<template>
  <tr>
    <td>{{ contact.name }}</td>
    <td>{{ contact.gender }}</td>
    <td>{{ contact.age }}</td>
    <td>{{ contact.email }}</td>
    <td>{{ contact.github }}</td>
    <td>
      <button
        class="btn btn-danger btn-sm"
        @click="$emit('delete-contact', contact.id)"
      >
        삭제
      </button>
    </td>
  </tr>
</template>

<script>
export default {
  name: 'ContactItem',
  props: {
    contact: {
      type: Object,
      required: true,
    },
  },
};
</script>
