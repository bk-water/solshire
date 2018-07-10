<template>
    <div class="v-article-list">

            <el-form :model="form" :inline="true">   
                <el-form-item label="文章ID：">
                    <el-input v-model="form.id" clearable></el-input>
                </el-form-item>
                        
                <el-form-item label="标题：">
                    <el-input v-model="form.name" clearable></el-input>
                </el-form-item>

                <el-form-item label="类型">
                  <el-select v-model="form.type" clearable placeholder="请选择">
                    <el-option
                      v-for="(item,i) in types"
                      :key="i"
                      :label="item"
                      :value="i">
                    </el-option>
                  </el-select>
                </el-form-item>
                    
                <el-form-item>
                    <el-button type="primary" @click.native.prevent="fetch(1)">查询</el-button>
                </el-form-item>
                
            </el-form>
            <el-row>
              <el-button type="primary" icon="el-icon-plus" @click.native.prevent="handleClickEdit">新增</el-button>
              
            </el-row>

            <el-table :data="dataList" :highlight-current-row="true" header-row-class-name="table-header" margin-top-10>
                <el-table-column
                    prop="id"
                    label="文章ID"
                    >
                </el-table-column>
                <el-table-column
                    prop="name"
                    label="标题"                 >
                </el-table-column>
                <el-table-column
                    prop="type"
                    label="类型"
                    >
                    <template slot-scope="scope">
                        {{types[scope.row.type]}}
                    </template>
                </el-table-column>
                <el-table-column
                    prop="tip"
                    label="提示"
                    >
                </el-table-column>
                <el-table-column
                    prop="addtime"
                    label="添加时间"
                    >
                </el-table-column>
                <el-table-column
                    label="操作" width="150">
                    <template slot-scope="scope">
                        <el-button @click="handleClickEdit(scope.row)" type="text" size="small">编辑</el-button>
                        <el-button @click="handleClickDelete(scope.row, scope.$index)" type="text" size="small">删除</el-button>
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
    </div>
</template>
<script>
import articleProvider from "@/providers/articleProvider";

export default {
  name: "VArticleList",
  data() {
    return {
      types: [
        "划动banner",
        "为您精选",
        "产品优惠",
        "保险理财",
        "基金理财",
        "管理咨询"
      ],
      form: {
        id: "",
        name: "",
        type: ""
      },
      dataList: [],
      paginator: null,
      pageSize: 10
    };
  },
  methods: {
    handleClickEdit(row) {
      this.$router.push({
        name: "article-edit",
        query: {
          id: row ? row.id : ""
        }
      });
    },
    async handleClickDelete(row, index) {
      try {
        await this.$confirm("此操作将永久删除该文章, 是否继续?", "提示", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
        });
        await articleProvider.deleteArticle(row.id);
        this.dataList.splice(index, 1);
        this.$message({
          type: "success",
          message: "删除成功!"
        });
      } catch (error) {
        this.$message({
          type: "info",
          message: "已取消删除"
        });
      }
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
    async fetch(pageNum = 1) {
      try {
        const resp = await articleProvider.queryArticles(
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
  },
  created() {
    this.fetch();
  }
};
</script>
<style lang="scss" scoped>
.v-article-list /deep/ {
  .el-table {
    .table-header {
      background-color: #eee;
      th {
        background-color: #eee;
      }
    }
  }
}
</style>
