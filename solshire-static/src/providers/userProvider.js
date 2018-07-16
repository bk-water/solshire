import http from "@/utils/http";

export default {
  login({ username, password, code }) {
    return http.post("/login", null, {
      params: {
        userName: username,
        password,
        code
      }
    });
  },
  logout() {
    return http.post("/loginOut");
  },
  getLoginInfo() {
    return http.get("/admin/index");
  }
};
