<template>
    <div class="v-customer-list">

        <el-form :model="form" :inline="true">   
            <el-form-item label="客户ID：">
                <el-input v-model="form.id" clearable></el-input>
            </el-form-item>   
            <el-form-item label="姓名：">
                <el-input v-model="form.name" clearable></el-input>
            </el-form-item>
            <el-form-item label="证件号：">
                <el-input v-model="form.name" clearable></el-input>
            </el-form-item>
            <el-form-item label="手机号：">
                <el-input v-model="form.name" clearable></el-input>
            </el-form-item>
            <el-form-item>
                <el-date-picker type="daterange" align="right" unlink-panels range-separator="~" start-placeholder="开始日期" end-placeholder="结束日期" :picker-options="pickerOptions" ></el-date-picker>    
            </el-form-item>        
            <el-form-item>
                <el-button type="primary" @click.native.prevent="fetch(1)">查询</el-button>
                <el-button @click.native.prevent="handleExportList">导出</el-button>
            </el-form-item>
        </el-form>

        <el-table :data="dataList" :highlight-current-row="true" header-row-class-name="table-header" margin-top-10>
            <el-table-column prop="id" label="客户ID"></el-table-column>
            <el-table-column prop="id" label="投保人"></el-table-column>
            <el-table-column prop="id" label="性别"></el-table-column>
            <el-table-column prop="id" label="出生日期"></el-table-column>
            <el-table-column prop="id" label="职业"></el-table-column>
            <el-table-column prop="id" label="手机号"></el-table-column>
            <el-table-column prop="id" label="证件号"></el-table-column>
            <el-table-column prop="id" label="邮箱"></el-table-column>
            <el-table-column prop="id" label="顾问"></el-table-column>
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
import customerProvider from "@/providers/customerProvider";

export default {
  name: "VCustomerList",
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
      dialogVisible:false,
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
    handleClickView(row) {

    },
    async handleSizeChange(val) {
      console.log(`每页${val}数据`);
      this.pageSize = val;
      this.fetch();
    },
    async handleCurrentChange(val) {
      console.log(`请求${val}数据`);
      this.fetch(val);
    },
    async handleExportList(){

    },
    async fetch(pageNum = 1) {
      try {
        const resp = await customerProvider.queryCustomers(
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

