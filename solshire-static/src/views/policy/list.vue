<template>
    <div class="v-policy-list">
        <el-form :model="form" :inline="true">   
            <el-form-item label="保单号：">
                <el-input v-model="form.id" clearable></el-input>
            </el-form-item>   
            <el-form-item label="保险公司：">
                <el-input v-model="form.name" clearable></el-input>
            </el-form-item>
            <el-form-item label="证件号：">
                <el-input v-model="form.name" clearable></el-input>
            </el-form-item>
            <el-form-item label="产品名称：">
                <el-input v-model="form.name" clearable></el-input>
            </el-form-item>
            <el-form-item label="理财师：">
                <el-input v-model="form.name" clearable></el-input>
            </el-form-item>
            <el-form-item label="选择日期：">
                <el-date-picker type="daterange" align="right" unlink-panels range-separator="~" start-placeholder="开始日期" end-placeholder="结束日期" :picker-options="pickerOptions" ></el-date-picker>    
            </el-form-item>        
            <el-form-item>
                <el-button type="primary" @click.native.prevent="fetch(1)">查询</el-button>
                <el-button @click.native.prevent="handleExportList">导出</el-button>
            </el-form-item>
        </el-form>

        <el-table :data="dataList" :highlight-current-row="true" header-row-class-name="table-header" margin-top-10>
            <el-table-column prop="id" label="保单号"></el-table-column>
            <el-table-column prop="id" label="保险公司"></el-table-column>
            <el-table-column prop="id" label="产品名称"></el-table-column>
            <el-table-column prop="id" label="投保人"></el-table-column>
            <el-table-column prop="id" label="货币"></el-table-column>
            <el-table-column prop="id" label="缴费形式"></el-table-column>
            <el-table-column prop="id" label="年期"></el-table-column>
            <el-table-column prop="id" label="每期保费"></el-table-column>
            <el-table-column prop="id" label="缴费方法"></el-table-column>
            <el-table-column prop="id" label="保单日期"></el-table-column>
            <el-table-column prop="id" label="理财师"></el-table-column>
            <el-table-column prop="id" label="标准保费"></el-table-column>
            <el-table-column label="操作" width="100">
                <template slot-scope="scope">
                    <el-button @click="handleClickView(scope.row)" type="text" size="small">编辑</el-button>
                </template>
            </el-table-column>
        </el-table> 
        <el-pagination v-if="paginator"
            @size-change="handleSizeChange"
            @current-change="handleCurrentChange"
            :current-page="paginator.pageNum"
            :page-sizes="[10, 20, 30, 40, 50]"
            :page-size="10"
            layout=" prev, pager, next, total, sizes,jumper"
            :total="paginator.total" display-flex justify-end margin-top-10
            >
        </el-pagination>

        <el-dialog title="保单详情" :visible.sync="dialogVisible">

        </el-dialog>

    </div>
</template>
<script>
import policyProvider from "@/providers/policyProvider";
export default {
  name: "VPolicyList",
  data() {
    return {
      form: {
        id: "",
        name: "",
        type: ""
      },
      dataList: [],
      paginator: null,
      pageSize: 10,
      dialogVisible: false,
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
    handleClickView(row) {},
    async handleSizeChange(val) {
      console.log(`每页${val}数据`);
      this.pageSize = val;
      this.fetch();
    },
    async handleCurrentChange(val) {
      console.log(`请求${val}数据`);
      this.fetch(val);
    },
    async handleExportList() {},
    async fetch(pageNum = 1) {
      try {
        const resp = await policyProvider.queryPolicies(
          Object.assign({}, this.form, {
            pageNum,
            pageSize: this.pageSize
          })
        );
        this.dataList = resp.data;
        this.paginator = resp.paginator;
      } catch (error) {
        console.dir(error);
      }
    }
  }
};
</script>
<style lang="scss" scoped>
</style>
