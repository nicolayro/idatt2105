import { mount } from "@vue/test-utils";
import Login from "../../src/views/Login.vue";

describe("Login", () => {
  test("entering text in input fields", () => {
    const wrapper = mount(Login);

  });

    test("logging in", async () => {
    const wrapper = mount(Login);

    await wrapper.find('button').trigger('click');

    
  });
});
