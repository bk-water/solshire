<template>
    <!-- <el-container class="c-layout">
        <el-aside width="200px">
            <el-menu default-active="2">
            </el-menu>
        </el-aside>
        <el-container class="main">
            <el-header>
              <div>
                <i class="s-icon-retract" @click="handleClickRetract"></i>
              </div>
              <div>
                <i class="s-icon-remind"></i>
                <el-dropdown v-if="loginInfo">
                  <span class="el-dropdown-link">
                    {{loginInfo.nickname}}<i class="el-icon-arrow-down el-icon--right"></i>
                  </span>
                  <el-dropdown-menu slot="dropdown">
                    <el-dropdown-item @click.native="handleLogout">退出</el-dropdown-item>
                  </el-dropdown-menu>
                </el-dropdown>
              </div>
            </el-header>
            <el-main>
                <el-card>
                    <transition>
                        <router-view/>
                    </transition>
                </el-card>
            </el-main>
            <el-footer height="30px">
              copyright@ 2018 业禾有限公司
            </el-footer>
        </el-container>
    </el-container> -->
    <div class="app-wrapper" >
      <side-bar class="sidebar-container"></side-bar>
      <div class="main-container">
        <nav-bar></nav-bar>
        <app-main></app-main>
      </div>
    </div>
</template>
<script>
import { mapActions, mapState } from "vuex";
import NavBar from "./components/NavBar";
import SideBar from "./components/SideBar";
import AppMain from "./components/AppMain";

export default {
  name: "c-layout",
  components: {
    NavBar,
    SideBar,
    AppMain
  },
  methods: {
    ...mapActions("permission", ["getMenus"]),
    ...mapActions("account", ["getLoginInfo"]),
    handleClickRetract() {}
  },
  computed: {
    ...mapState("permission", ["menus"]),
  },
  created() {
    this.getMenus();
    this.getLoginInfo();
  }
};
</script>
<style lang="scss" scoped>
.app-wrapper {
  position: relative;
  height: 100%;
  width: 100%;
  &:after {
    content: "";
    display: table;
    clear: both;
  }
}

.main-container {
  min-height: 100vh;
  transition: margin-left 0.28s;
  margin-left: 256px;
  background-color: rgba(240, 242, 245, 1);
}
</style>
