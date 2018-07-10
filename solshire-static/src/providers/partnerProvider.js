import http from "@/utils/http";

export default {
  /**
   * 查询合伙人信息
   * @param {*} param0
   */
  queryPartners({ pageNum = 1, pageSize = 10, richeid, name, certifyNo }) {
    return http.get("/user/listPartner", {
      params: {
        pageNum,
        pageSize,
        richeid,
        name,
        certifyNo
      }
    });
  },
  savePartner(data) {
    return http.post("/user/partner", data);
  },
  updateState(id, state) {
    return http.post("/user/status", null, {
      params: {
        richeid: id,
        status: state
      }
    });
  },
  getPartner(id) {
    return http.get(`/user/${id}`);
  },
  queryDirectUsers(params) {
    return http.get("/user/directUser", {
      params
    });
  },
  queryDirectUserTree(id) {
    return http.get(`/user/tree/${id}`);
  }
};
