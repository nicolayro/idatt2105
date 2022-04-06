<template>
  <h2>Registrer deg</h2>
  <form @submit.prevent="handleSubmit">
    <label for="username">Brukernavn</label>
    <input id="text" type="text" v-model="username" />

    <label for="password">Passord</label>
    <input id="password" type="password" v-model="password" />

    <label for="repeat-password">Gjenta passord</label>
    <input id="repeat-password" type="password" v-model="repeatPassword" />

    <button type="submit">Registrer meg</button>
    <p class="error" v-if="error">{{ error }}</p>
  </form>

  <p>
    Har du ingen konto ?
    <router-link to="/register">Registrer deg her</router-link>
  </p>
</template>

<script>
import { register } from "@/service/authUtil";

export default {
  data() {
    return {
      username: "",
      password: "",
      repeatPassword: "",
      error: "",
    };
  },
  methods: {
    async handleSubmit() {
      if (this.password !== this.repeatPassword) {
        this.error = "Passordene er ikke like";
      }
      console.log("Attempting registration");
      try {
        const response = await register({
          username: this.username,
          password: this.password,
        });
        console.log(response);
      } catch (err) {
        console.log(err);
      }
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
