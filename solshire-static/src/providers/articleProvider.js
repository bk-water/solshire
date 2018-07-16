import http from "@/utils/http";

export default {
  getArticle(id) {
    return http.get(`/appShowInfo/${id}`);
  },
  queryArticles({ pageNum = 1, pageSize = 10, id, name, type }) {
    return http.get("/appShowInfo", {
      params: {
        pageNum,
        pageSize,
        id,
        name,
        type
      }
    });
  },
  deleteArticle(id) {
    return http.delete(`/appShowInfo/${id}`);
  },
  saveArticle({ context, id, name, type, image, tip, sort }) {
    return http.post("/appShowInfo", {
      id,
      name,
      type,
      image,
      tip,
      context,
      sort
    });
  }
};
