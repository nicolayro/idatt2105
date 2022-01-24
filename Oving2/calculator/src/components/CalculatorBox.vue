<template>
  <div class="calculator-container">
    <!-- Title -->
    <div class="title-container">
      <img class="title" alt="Vue logo" src="../assets/logo.png" /> 
      <div class="title">Calculator</div>  
    </div>

    <!-- Calculator -->
    <Calculator />

  </div>
</template>

<script>
import Calculator from "./Calculator.vue";

export default {
  name: "CalculatorBox",
  components: {
    Calculator
  }
};

</script>

<style scoped>
img {
  height: 2.5rem;
  width: 2.5rem;
}

.calculator-container {
  border-radius: 15px;
  display: flex;
  flex-direction: column;
  width: 80%;
  margin: auto;
}

.title-container {
  display: flex;
  height: 3rem;
  margin: 0 auto 
}

.title {
  display: block;
  margin: auto 1rem;
  font-size: 2.5rem;
  font-weight: bold;
}

</style>