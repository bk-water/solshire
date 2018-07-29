<template>
    <div class="v-user-list">
      <el-form ref="form">
        <el-row type="flex">
          <el-col>
            <el-form-item label="顾问ID：">
              <el-input></el-input>
            </el-form-item>
          </el-col>

          <el-col>
            <el-form-item label="姓名：">
              <el-input></el-input>
            </el-form-item>
          </el-col>

          <el-col>
            <el-form-item label="证件号：">
              <el-input></el-input>
            </el-form-item>
          </el-col>
        </el-row>
        <el-row type="flex">
          <el-col>
            选择日期：
            <el-date-picker
              type="daterange"
              align="right"
              unlink-panels
              range-separator="~"
              start-placeholder="开始日期"
              end-placeholder="结束日期"
              :picker-options="pickerOptions" >
            </el-date-picker>

            <el-button size="mini">查询</el-button>
            <el-button size="mini">导出</el-button>
          </el-col>
        </el-row>    
          
      </el-form>

      <el-table
      
      style="width: 100%">
      <el-table-column
        prop="date"
        label="顾问ID"
        width="180">
      </el-table-column>
      <el-table-column
        prop="name"
        label="姓名"
        width="180">
      </el-table-column>
      <el-table-column
        prop="address"
        label="证件号">
      </el-table-column>
      <el-table-column
        prop="address"
        label="手机号">
      </el-table-column>
      <el-table-column
        prop="address"
        label="性别">
      </el-table-column>
      <el-table-column
        prop="address"
        label="邮箱">
      </el-table-column>
      <el-table-column
        prop="address"
        label="级别">
      </el-table-column>
      <el-table-column
        prop="address"
        label="注册时间">
      </el-table-column>
      <el-table-column
        prop="address"
        label="操作">
        <template slot-scope="scope">
          <el-button @click="handleClick(scope.row)" type="text" size="small">修改</el-button>
        </template>
      </el-table-column>
    </el-table>
    </div>
</template>
<script>
export default {
  name: "v-user-list",
  data() {
    return {
      dataList: [],
      pickerOptions: {
        shortcuts: [
          {
            text: "最近一周",
            onClick(picker) {
              const end = new Date();
              const start = new Date();
              start.setTime(start.getTime() - 3600 * 1000 * 24 * 7);
              picker.$emit("pick", [start, end]);
            }
          },
          {
            text: "最近一个月",
            onClick(picker) {
              const end = new Date();
              const start = new Date();
              start.setTime(start.getTime() - 3600 * 1000 * 24 * 30);
              picker.$emit("pick", [start, end]);
            }
          },
          {
            text: "最近三个月",
            onClick(picker) {
              const end = new Date();
              const start = new Date();
              start.setTime(start.getTime() - 3600 * 1000 * 24 * 90);
              picker.$emit("pick", [start, end]);
            }
          }
        ]
      }
    };
  },
  methods: {
    fetch() {}
  },
  activated() {
    this.fetch();
  }
};
</script>
<style lang="scss" scoped>
.v-user-list /deep/ {
  background-color: #fff;

  .el-form {
    font-size: 14px;
    .el-input {
      width: 180px;
      .el-input__inner {
        height: 32px;
        line-height: 32px;
        padding: 0 10px;
      }
    }
  }
}
</style>

