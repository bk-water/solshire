import storage from "@/utils/storage";
import * as types from "@/store/mutation-types";
import permissionProvider from "@/providers/permissionProvider";

const state = {
  menus: [
    {
      name: "财富团队成员",
      children: [
        {
          name: "事业合伙人管理",
          children: [
            {
              name: "新增"
            }
          ]
        },
        {
          name: "顾问管理"
        }
      ]
    }
  ]
};

const getters = {};

const actions = {
  async getMenus({ commit }) {
    const resp = await permissionProvider.getMenus();
    console.dir(resp);
  }
};

const mutations = {};

export default {
  namespaced: true,
  state,
  getters,
  actions,
  mutations
};
