import http from "./http-common";

export const login = (user) => {
  return http.post("/login", user);
};

export const register = (user) => {
  return http.post("/register", user);
};
