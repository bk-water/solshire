<template>
  <section class="app-main">
    
    <el-card>
      <el-breadcrumb separator-class="el-icon-arrow-right" slot="header">
        <el-breadcrumb-item v-for="(item,index)  in levelList" :key="item.path" v-if='item.meta.title'>
          <span v-if='item.redirect==="noredirect"||index==levelList.length-1' class="no-redirect">{{item.meta.title}}</span>
          <router-link v-else :to="item.redirect||item.path">{{item.meta.title}}</router-link>
        </el-breadcrumb-item>
      </el-breadcrumb>
      <transition name="fade" mode="out-in">
        <router-view></router-view>
      </transition>
    </el-card>
  </section>
</template>

<script>
export default {
  name: "AppMain",
  data() {
    return {
      levelList: null
    };
  },
  watch: {
    $route() {
      this.getBreadcrumb();
    }
  },
  methods: {
    getBreadcrumb() {
      let matched = this.$route.matched.filter(item => item.name);
      const first = matched[0];
      if (first && first.name !== "dashboard") {
        matched = [{ path: "/", meta: { title: "首页" } }].concat(
          matched
        );
      }
      this.levelList = matched;
    }
  },
  created() {
    this.getBreadcrumb();
  }
};
</script>
<style lang="scss" scoped>
.app-main /deep/ {
  padding: 10px 20px;

  .el-breadcrumb {
    display: inline-block;
    font-size: 14px;
    margin-left: 10px;
    .no-redirect {
      color: #97a8be;
      cursor: text;
    }
  }
}
</style>

