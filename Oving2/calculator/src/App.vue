<template>
  <div>
  <CalculatorBox />
  </div>
</template>

<script>
import CalculatorBox from "./components/CalculatorBox.vue";

export default {
  name: "App",
  components: {
    CalculatorBox,
  },
};
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
