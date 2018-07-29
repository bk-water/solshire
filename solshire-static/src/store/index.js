import Vue from "vue";
import Vuex from "vuex";

import account from "@/store/modules/account";
import permission from "@/store/modules/permission";

Vue.use(Vuex);

export default new Vuex.Store({
  modules: {
    account,
    permission
  }
});
