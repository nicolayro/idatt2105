import { createRouter, createWebHistory } from "vue-router";
import CalculatorView from "../views/CalculatorView.vue";
import Contact from "../views/Contact.vue";

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
];

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes,
});

export default router;
