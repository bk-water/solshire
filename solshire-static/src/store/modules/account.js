import storage from "@/utils/storage";
import * as types from "@/store/mutation-types";
import userProvider from "@/providers/userProvider";

const state = {
  loginInfo: null
};

const getters = {
  isLogin() {
    return storage.get("login_state") === 1;
  }
};

const actions = {
  async login({ commit }, { username, password, code }) {
    await userProvider.login({ username, password, code });
    commit(types.SET_LOGIN_STATE);
  },
  async getLoginInfo({ commit }) {
    if (state.loginInfo) {
      return;
    }
    const resp = await userProvider.getLoginInfo();
    commit(types.SET_LOGIN_INFO, resp.data);
  },
  async logout({ commit }) {
    commit(types.DELETE_LOGIN_STATE);
    commit(types.DELETE_LOGIN_INFO);
    await userProvider.logout()
  }
};

const mutations = {
  [types.SET_LOGIN_STATE](state) {
    storage.set("login_state", 1);
  },
  [types.SET_LOGIN_INFO](state, loginInfo) {
    state.loginInfo = loginInfo;
  },
  [types.DELETE_LOGIN_STATE](state) {
    storage.remove("login_state");
  },
  [types.DELETE_LOGIN_INFO](state) {
    state.loginInfo = null;
  }
};

export default {
  namespaced: true,
  state,
  getters,
  actions,
  mutations
};
