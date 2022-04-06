import { createRouter, createWebHistory } from "vue-router";
import CalculatorView from "../views/CalculatorView.vue";
import Contact from "../views/Contact.vue";
import Login from "../components/authentication/Login";
import Register from "../components/authentication/Registration";

const routes = [
  {
    path: "/",
    name: "CalculatorView",
    component: CalculatorView,
  },
  {
    path: "/contact",
    name: "Contact",
    component: Contact,
  },
  {
    path: "/login",
    name: "Login",
    component: Login,
  },
  {
    path: "/register",
    name: "Register",
    component: Register,
  },
];

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes,
});

export default router;
