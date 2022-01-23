<template>
  <div class="calculator-container">
    <div class="title-container">
      <img class="title" alt="Vue logo" src="../assets/logo.png" /> 
      <div class="title">Calculator</div>  
    </div>
  </div>
</template>

<script>
export default {
  name: "CalculatorBox",
};

</script>

<style scoped>
img {
  height: 2.5rem;
  width: 2.5rem;
}

.calculator-container {
  border: solid 2px;
  border-radius: 15px;
  display: flex;
  flex-direction: column;
  width: 80%;
  height: 80vh;
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