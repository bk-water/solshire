import axios from "axios";

const instance = axios.create({
  baseURL: process.env.VUE_APP_API_BASE_URL,
  headers: {
    "content-type": "application/json;charset=UTF-8"
  }
});

instance.interceptors.request.use(
  c => {
    return c;
  },
  err => {}
);

instance.interceptors.response.use(
  resp => {
    if (resp.data) {
      if (resp.data.code === "200") {
        return Promise.resolve(resp.data);
      }
      return Promise.reject(resp.data);
    }
    return Promise.reject({
      code: "404",
      msg: "NotFound"
    });
  },
  err => {
    return Promise.reject({
      code: String(err.response.status),
      msg: err.response.statusText
    });
  }
);

export default instance;
