import http from "@/utils/http";

export default {
  /**
   * 查询客户列表
   * @param {*} params
   */
  queryCustomers(params = {}) {
    return http.get("/sales/list", {
      params
    });
  }
};
