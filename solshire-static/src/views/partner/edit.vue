<template>
    <div class="v-partner-edit">
        <el-form :model="form" :inline="true" label-width="80px">
          <el-row>
            <el-form-item label="姓名" :label-width="dialogFormLabelWidth">
              <el-input v-model="form.name" auto-complete="off" placeholder="请输入姓名"></el-input>
            </el-form-item>
            <el-form-item label="性别" :label-width="dialogFormLabelWidth">
              <el-select v-model="form.region" placeholder="请选择性别">
                <el-option label="男" value="1"></el-option>
                <el-option label="女" value="0"></el-option>
              </el-select>
            </el-form-item>
          </el-row>
          <el-row>
            <el-form-item label="手机号" :label-width="dialogFormLabelWidth">
              <el-input v-model="form.tel" auto-complete="off" placeholder="请输入手机号"></el-input>
            </el-form-item>
            <el-form-item label="证件号" :label-width="dialogFormLabelWidth">
              <el-input v-model="form.certifyNo" auto-complete="off" placeholder="请输入证件号"></el-input>
            </el-form-item>
          </el-row>
          <el-row>
            <el-form-item label="银行卡号" :label-width="dialogFormLabelWidth">
              <el-input v-model="form.mobile" auto-complete="off" placeholder="请输入银行卡号"></el-input>
            </el-form-item>
          </el-row>
          
          <el-form-item>
            <el-checkbox v-model="checked">推荐人</el-checkbox>
          </el-form-item>
        </el-form>
    </div>
</template>
<script>
export default {
  name: "VPartnerEdit",
  data() {
    return {
      form: {}
    };
  }
};
</script>
<style lang="scss" scoped>
</style>
