<template>
  <h2>Logg inn</h2>
  <form @submit.prevent="handleSubmit">
    <label for="email">Epost</label>
    <input id="email" type="text" v-model="email" />

    <label for="password">Passord</label>
    <input id="password" type="password" v-model="password" />

    <button type="submit">Logg inn</button>
  </form>
</template>

<script>
export default {
  data() {
    return {
      email: "",
      password: "",
    };
  },
  methods: {
    handleSubmit() {
      console.log("Logging in...");
      console.log({
        email: this.email,
        password: this.password,
      });
    },
  },
};
</script>

<style scoped>
form {
  width: 60vw;
  margin: auto;
}

button {
  width: 20rem;
  height: 2.5rem;
  border: solid black 1px;
  margin: 20px 0;
  background-color: cadetblue;
  color: white;
  font-size: 1.5rem;
}

button:hover {
  opacity: 0.8;
}

button:active {
  transform: translate(1px, 1px);
}

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

textarea {
  display: block;
  height: 4rem;
  font-size: 1rem;
  padding: 5px;
  width: 20rem;
  margin: auto;
}

ul {
  width: 20rem;
  margin: auto;
}
</style>
