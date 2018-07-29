<template>
    <div class="v-dashboard" v-if="loginInfo">
      <h5>登陆信息</h5>
      <el-row type="flex" align="middle">
        <el-col>
          <label>用户：{{loginInfo.nickname}}</label>
        </el-col>
        <el-col>
          <label>角色：{{loginInfo.roleName}}</label>
        </el-col>
      </el-row>
      <el-row type="flex" align="middle">
        <el-col>
          <label>注册时间：{{loginInfo.createTime}}</label>
        </el-col>
        <el-col>
          <label>描述：{{loginInfo.roleDesc}}</label>
        </el-col>
      </el-row>
      <el-row type="flex" align="middle">
        <el-col>
          <label>最近登陆IP：{{loginInfo.lastLoginIp}}</label>
        </el-col>
        <el-col>
          <label>最近登陆时间：{{loginInfo.lastLoginTime}}</label>
        </el-col>
      </el-row>
    </div>
</template>
<script>
import { mapState } from "vuex";
export default {
  name: "VDashboard",
  computed: {
    ...mapState("account", ["loginInfo"])
  },
  methods: {},
  created() {}
};
</script>
<style lang="scss" scoped>
.v-dashboard /deep/ {
  h5 {
    margin-top: 0;
  }
  .el-row {
    margin-top: 10px;
  }
}
</style>

