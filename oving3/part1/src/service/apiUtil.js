import http from "./http-common";

export const getCalculations = () => {
  return http.get("/calculations");
};

export const calculate = (calculation) => {
  return http.post("/calculations", calculation);
};
