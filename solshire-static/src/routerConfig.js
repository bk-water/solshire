import CLayout from "@/layouts/index";
const VDashboard = () => import("@/views/dashboard/index");

const VPartnerList = () => import("@/views/partner/list");
const VPartnerEdit = () => import("@/views/partner/edit");

const VUserList = () => import("@/views/user/list");

const VArticleList = () => import("@/views/article/list");
const VArticleEdit = () => import("@/views/article/edit");

export default [
  {
    path: "",
    component: CLayout,
    children: [
      {
        path: "/",
        component: VDashboard,
        name: "dashboard",
        meta: {
          title: "首页"
        }
      }
    ]
  },
  {
    path: "/partner",
    component: CLayout,
    children: [
      {
        path: "list",
        component: VPartnerList,
        name: "partner-list",
        meta: {
          title: "事业合伙人管理"
        }
      },
      {
        path: "edit",
        component: VPartnerEdit,
        name: "partner-edit",
        meta: {
          title: "编辑事业"
        }
      }
    ]
  },
  {
    path: "/user",
    component: CLayout,
    name: "v-user",
    children: [
      {
        path: "list",
        component: VUserList,
        name: "v-user-list"
      }
    ]
  },
  {
    path: "/article",
    component: CLayout,
    name: "article",
    children: [
      {
        name: "article-list",
        path: "list",
        component: VArticleList,
        meta: {
          title: "网站编辑"
        }
      },
      {
        name: "article-edit",
        path: "edit",
        component: VArticleEdit,
        meta: {
          title: "内容编辑"
        }
      }
    ]
  }
];
