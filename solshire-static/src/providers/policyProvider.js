import http from "@/utils/http";

export default {
  queryPolicies(params = {}) {
    return http.get("/sales/listOrder", {
      params
    });
  }
};
