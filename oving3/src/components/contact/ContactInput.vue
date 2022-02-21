<template>
  <label :for="label">{{ label }}</label>
  <input
    v-bind="$attrs"
    :id="label"
    :type="type"
    @input="$emit('update:modelValue', $event.target.value)"
  />
  <p v-if="error" class="error">{{ error }}</p>
</template>

<script>
export default {
  props: {
    label: {
      type: String,
      default: "",
    },
    modelValue: {
      type: String,
      default: "",
    },
    error: {
      type: String,
      default: "",
    },
    type: {
      type: String,
      default: "text",
    },
  },
};
</script>

<style scoped>
label {
  display: block;
  text-align: left;
  margin: 20px auto 3px auto;
  width: 20rem;
}

input {
  display: block;
  height: 1.2rem;
  font-size: 1rem;
  padding: 5px;
  width: 20rem;
  margin: auto;
}

.error {
  color: red;
}
</style>
