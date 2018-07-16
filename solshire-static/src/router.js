import Vue from "vue";
import Router from "vue-router";
import storage from "@/utils/storage";
import routerConfig from "./routerConfig";

Vue.use(Router);

const VLogin = () => import("@/views/login/index");

const router = new Router({
  mode: "history",
  routes: [
    {
      path: "/login",
      name: "v-login",
      component: VLogin,
      meta: {
        title: "登陆",
        needLogin: false
      }
    }
  ]
});

router.addRoutes(routerConfig);

router.beforeEach((to, from, next) => {
  if (storage.get("login_state") === 1) {
    if (to.path === "/login") {
      next({ path: "/" });
    } else {
      next();
    }
  } else {
    if (to.meta.needLogin === false) {
      next();
    } else {
      next({ path: "/login" });
    }
  }
});

export default router;
