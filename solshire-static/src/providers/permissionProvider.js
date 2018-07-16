import http from "@/utils/http";

export default {
  getMenus() {
    return http.get("/admin/tree");
  }
};
