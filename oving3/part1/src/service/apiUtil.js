import http from "./http-common";

export const calculate = (calculation) => {
  return http.post("/calculate", calculation);
};
