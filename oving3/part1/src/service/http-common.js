import axios from "axios";

const fetchClient = () => {
  const options = {
    baseURL: "http://localhost:5001",
    headers: {
      "Content-type": "application/json",
    },
  };

  let instance = axios.create(options);

  instance.interceptors.request.use(async (config) => {
    let token = localStorage.getItem("token");
    config.headers.Authorization = token ? `Bearer ${token}` : "";
    return config;
  });

  return instance;
};

export default fetchClient();
