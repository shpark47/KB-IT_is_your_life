<template>
  <div>
    <Calc />
    <hr />
    <Composition />
    <hr />
    <Options />
  </div>
</template>

<script>
import Calc from './components/Calc.vue';
import Composition from './components/Composition.vue';
import Options from './components/Options.vue';

export default {
  name: 'App',
  components: {
    Options,
    Composition,
    Calc,
  },
};
</script>

<style scoped></style>
