<template>
    <el-container>
      <el-main class="v-login">
        <el-form :model="form" :rules="rules" ref="form">
          <el-form-item prop="username">
            <el-input placeholder="账号" v-model="form.username" maxlength="32" prefix-icon="s-icon-account" style="width:300px" @keyup.enter.native="handleLogin"></el-input>
          </el-form-item>
          <el-form-item prop="password">
            <el-input type="password" placeholder="密码" maxlength="32" v-model="form.password" prefix-icon="s-icon-password" style="width:300px" @keyup.enter.native="handleLogin"></el-input>
          </el-form-item>
          <el-form-item prop="code">
            <el-input placeholder="验证码" maxlength="4" v-model="form.code" style="width:100px" @keyup.enter.native="handleLogin"></el-input>
            <img :src="kaptcha" />
            <el-button type="text" class="changeBtn" @click.native.prevent="handleRefreshKaptcha">换一张</el-button>
          </el-form-item>
          <el-form-item>
            <el-button type="primary" style="width:100%" :loading="loading" @click.native.prevent="handleLogin">登录</el-button>
          </el-form-item>
        </el-form>
      </el-main>
    </el-container>
</template>
<script>
import { mapActions } from "vuex";
import { createLengthValidate } from "@/utils/validate";
export default {
  name: "VLogin",
  data() {
    return {
      form: {
        username: "",
        password: "",
        code: ""
      },
      rules: {
        username: [
          {
            required: true,
            trigger: "blur",
            validator: createLengthValidate(1, "请输入账号")
          }
        ],
        password: [
          {
            required: true,
            trigger: "blur",
            validator: createLengthValidate(6, "请输入至少六位密码")
          }
        ],
        code: [
          {
            required: true,
            trigger: "blur",
            validator: createLengthValidate(4, "请输入四位验证码")
          }
        ]
      },
      loading: false,
      kaptcha: null
    };
  },
  methods: {
    ...mapActions("account", ["login"]),
    async accountLogin() {
      try {
        await this.login(this.form)
        this.loading=false
        this.$router.push({ path: '/' })
      } catch (e) {
        this.$message({
          message:e.msg,
          center:true
        })
        this.loading=false
      }
    },
    handleRefreshKaptcha() {
      this.kaptcha = `${
        process.env.VUE_APP_API_BASE_URL
      }/kaptcha/${Date.now()}`;
    },
    async handleLogin() {
      const self = this
      this.$refs.form.validate(valid => {
        if (valid) {
          self.loading = true;
          self.accountLogin();
        } else {
          return false;
        }
      });
    }
  },
  created() {
    this.handleRefreshKaptcha();
  }
};
</script>

<style lang="scss" scoped>
.v-login /deep/ {
  background-image: url("../../assets/v-login/bg.jpg");
  position: fixed;
  height: 100%;
  width: 100%;
  display: flex;
  justify-content: center;
  align-items: center;

  .el-form-item {
    img {
      height: 40px;
      vertical-align: bottom;
      margin-left: 10px;
    }

    .changeBtn {
      margin-left: 10px;
    }
  }
}
</style>
