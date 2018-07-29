import http from "@/utils/http";

export default {
  /**
   * 查询顾问
   * @param {*} params
   */
  queryAdvisers(params = {}) {
    return http.get("/user/listAdviser", {
      params
    });
  },
  
};
