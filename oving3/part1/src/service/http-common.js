import axios from "axios";

const fetchClient = () => {
  const options = {
    baseURL: "http://localhost:5001",
    headers: {
      "Content-type": "application/json",
    },
  };

  return axios.create(options);
};

export default fetchClient();
