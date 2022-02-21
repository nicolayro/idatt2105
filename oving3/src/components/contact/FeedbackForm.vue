<template>
  <form @submit.prevent="handleSubmit">
    <label for="name">Navn</label>
    <input v-model="name" type="text" id="name" />
    <p v-if="errors.name" class="error">{{ errors.email }}</p>

    <label for="">Epost</label>
    <input v-model="email" type="text" id="email" />
    <p v-if="errors.email" class="error">{{ errors.email }}</p>

    <label for="message">Melding</label>
    <textarea v-model="message" />
    <p v-if="errors.message" class="error">{{ errors.message }}</p>

    <button type="submit">Send inn</button>
  </form>

  <div v-if="loadingMessage">{{ loadingMessage }}</div>
</template>

<script>
// import ContactInput from "./ContactInput.vue";

export default {
  // components: {
  //   ContactInput,
  // },
  data() {
    return {
      name: this.$store.state.name,
      email: this.$store.state.email,
      message: "",
      errors: {
        name: null,
        email: null,
        message: null,
      },
      loadingMessage: "",
    };
  },
  methods: {
    handleSubmit() {
      // First we must validate the data
      this.validate();
      if (this.isError()) {
        console.log("Erros found");
        return;
      }

      // If we get here, we know there are no errors
      this.loadingMessage = "Sender...";
      setTimeout(() => {
        console.log({
          name: this.name,
          email: this.email,
          message: this.message,
        });
        this.loadingMessage = "Sendt!";

        // When everything is completed, we save the name and email to global store
        this.$store.dispatch("setName", this.name);
        this.$store.dispatch("setEmail", this.email);
        this.message = "";

        // We remove the message after a couple of seconds
        setTimeout(() => {
          this.loadingMessage = "";
        }, 2000);
      }, 1000);
    },
    validate() {
      this.initialErrorState();
      if (!this.name) {
        this.errors.name = "Vennligst skriv inn et navn";
      }
      if (!this.email) {
        this.errors.email = "Vennligst skriv inn en epost";
      }
      if (!this.message) {
        this.errors.message = "Vennligst skriv inn en melding";
      }
      if (!this.email.includes("@")) {
        this.errors.email = "Vennligst skriv inn en gyldig epost";
      }
    },
    isError() {
      return !Object.values(this.errors).every((x) => x === null);
    },
    initialErrorState() {
      this.errors = {
        name: null,
        email: null,
        message: null,
      };
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
