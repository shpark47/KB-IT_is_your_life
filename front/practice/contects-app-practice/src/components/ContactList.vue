<template>
  <div class="contact-list mt-3">
    <table class="table">
      <thead>
        <tr>
          <th>이름</th>
          <th>성별</th>
          <th>나이</th>
          <th>이메일</th>
          <th>Github ID</th>
          <th>관리</th>
        </tr>
      </thead>
      <tbody>
        <ContactItem
          v-for="contact in contacts"
          :key="contact.id"
          :contact="contact"
          @delete-contact="$emit('delete-contact', $event)"
        />
      </tbody>
    </table>
  </div>
</template>

<script>
import ContactItem from './ContactItem.vue';
export default {
  components: {
    ContactItem,
  },
  props: {
    contacts: {
      type: Object,
      required: true,
    },
  },
};
</script>
