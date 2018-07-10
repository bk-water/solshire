<template>
    <div class="v-partner-list">
      <el-form :model="form" :inline="true">   
        <el-form-item label="顾问ID：">
            <el-input v-model="form.richeid" clearable></el-input>
        </el-form-item>
                
        <el-form-item label="姓名：">
            <el-input v-model="form.realname" clearable></el-input>
        </el-form-item>

        <el-form-item label="证件号：">
          <el-input v-model="form.certifyNo" clearable></el-input>
        </el-form-item>
            
        <el-form-item label="手机号：">
          <el-input v-model="form.tel" clearable></el-input>
        </el-form-item>

        <el-form-item>
            <el-button type="primary" @click.native.prevent="fetch(1)">查询</el-button>
            <!-- <el-button>导出</el-button> -->
        </el-form-item>
      </el-form>

      <el-row>
        <el-button type="primary" icon="el-icon-plus" @click.native="handleClickEdit(1)">新增</el-button>
        <!-- <el-button icon="el-icon-delete">删除</el-button> -->
      </el-row>

      <el-table :data="dataList" :highlight-current-row="true" header-row-class-name="table-header" margin-top-10>
        <!-- <el-table-column type="selection" width="55"></el-table-column> -->
        <el-table-column prop="richeid" label="顾问ID"></el-table-column>
        <el-table-column prop="realname" label="姓名"></el-table-column>
        <el-table-column prop="certifyno" label="证件号"></el-table-column>
        <el-table-column prop="tel" label="手机号"></el-table-column>
        <el-table-column prop="sex" label="性别">
            <template slot-scope="scope">
              {{SEX_ARRAY[scope.row.sex]}}
            </template>
        </el-table-column>
        <el-table-column prop="state" label="状态">
            <template slot-scope="scope">
              {{STATE_ARRAY[scope.row.state]}}
            </template>
        </el-table-column>
        <el-table-column prop="addtime" label="签约时间"></el-table-column>
        <el-table-column prop="remark" label="描述"></el-table-column>
        <el-table-column
          label="操作"
          width="200">
          <template slot-scope="scope">
            <template v-if="scope.row.state===0">
              <el-button @click="handleCheck(scope.row)" type="text" size="small">审核</el-button>
              <el-button @click="handleDelete(scope.row)" type="text" size="small">删除</el-button>
            </template>
            <template v-else-if="scope.row.state===1">
              <el-button @click="handleClickEdit(2,scope.row)" type="text" size="small">编辑</el-button>
              <el-button @click="handleCancel(scope.row)" type="text" size="small">解约</el-button>
              <el-button @click="handleOpenDialog1(scope.row)" type="text" size="small">直属成员</el-button>
              <el-button @click="handleOpenDialog2(scope.row)" type="text" size="small">关系图</el-button>
            </template>
            <template v-else-if="scope.row.state===2">
              <el-button @click="handleDelete(scope.row)" type="text" size="small">删除</el-button>
            </template>
            <template v-else-if="scope.row.state===3">

            </template>
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
              :total="paginator.total" margin-top-10 display-flex justify-end
              >
            </el-pagination>

      <el-dialog :title="dialog.title" :visible.sync="dialog.visible" :close-on-click-modal="false">
        <el-form :model="saveForm" :inline="true" :rules="rules" ref="saveForm" label-width="100px">

          <el-form-item label="姓名" prop="realname">
            <el-input v-model="saveForm.realname" placeholder="请输入姓名"></el-input>
          </el-form-item>
          <el-form-item label="性别" prop="sex">
            <el-select v-model="saveForm.sex" placeholder="请选择性别" class="sex">
              <el-option v-for="(item,index) in SEX_ARRAY" :key="index" :label="item" :value="index"></el-option>
            </el-select>
          </el-form-item>

          <el-form-item label="手机号" prop="tel">
            <el-input v-model="saveForm.tel" placeholder="请输入手机号"></el-input>
          </el-form-item>
          <el-form-item label="证件号" prop="certifyno">
            <el-input v-model="saveForm.certifyno" placeholder="请输入证件号"></el-input>
          </el-form-item>

          <el-form-item label="银行卡号" class="bankcardid" prop="bankcardid">
            <el-input v-model="saveForm.bankcardid" placeholder="请输入银行卡号"></el-input>
          </el-form-item>

          <el-form-item label="推荐人" prop="reference">
            <el-input v-model="saveForm.reference" placeholder="请输入推荐人信息">
              <el-checkbox slot="prepend" v-model="checked"></el-checkbox>
            </el-input>
          </el-form-item>

          <el-form-item label="备注" class="remark">
            <el-input type="textarea" :rows="4" placeholder="请输入内容" v-model="saveForm.remark"></el-input>
          </el-form-item>
          
        </el-form>
        <span slot="footer" class="dialog-footer">
          <el-button @click="dialog.visible = false">取 消</el-button>
          <el-button type="primary" @click="handleSubmit">确 定</el-button>
        </span>
      </el-dialog>

      <el-dialog :visible.sync="dialog1.visible" class="dialog1">
        <span class="el-dialog__title" slot="title" v-html="dialog1.title"></span>

        <el-form :model="dialog1.form" :inline="true">   
          <el-form-item label="顾问ID：">
              <el-input v-model="dialog1.form.richeid" clearable></el-input>
          </el-form-item>
                  
          <el-form-item label="姓名：">
              <el-input v-model="dialog1.form.realname" clearable></el-input>
          </el-form-item>

          <el-form-item label="证件号：">
            <el-input v-model="dialog1.form.certifyNo" clearable></el-input>
          </el-form-item>
              
          <el-form-item label="手机号：">
            <el-input v-model="dialog1.form.tel" clearable></el-input>
          </el-form-item>

          <el-form-item>
              <el-button type="primary" @click.native.prevent="fetch(1)">查询</el-button>
          </el-form-item>
        </el-form>

        <el-table :data="dataList" :highlight-current-row="true" header-row-class-name="table-header" margin-top-10>
          <el-table-column prop="richeid" label="顾问ID"></el-table-column>
          <el-table-column prop="realname" label="姓名"></el-table-column>
          <el-table-column prop="sex" label="性别">
              <template slot-scope="scope">
                {{SEX_ARRAY[scope.row.sex]}}
              </template>
          </el-table-column>
          <el-table-column prop="certifyno" label="证件号"></el-table-column>
          <el-table-column prop="tel" label="手机号"></el-table-column>
          <el-table-column prop="addtime" label="注册时间"></el-table-column>
        </el-table>

        <span slot="footer" class="dialog-footer">
          <el-button @click="dialog1.visible = false">取 消</el-button>
        </span>
      </el-dialog>


      <el-dialog title="直属成员关系图" :visible.sync="dialog2.visible">
        <el-tree :data="dialog2.tree" :props="defaultProps" @node-click="handleNodeClick"></el-tree>
        <span slot="footer" class="dialog-footer">
          <el-button @click="dialog2.visible = false">取 消</el-button>
        </span>
      </el-dialog>
    </div>
</template>
<script>
import partnerProvider from "@/providers/partnerProvider";
import { STATE_ARRAY, SEX_ARRAY } from "@/utils/enum";
import { createLengthValidate } from "@/utils/validate";
export default {
  name: "VPartnerList",
  data() {
    const self = this;
    return {
      STATE_ARRAY,
      SEX_ARRAY,
      defaultProps: {
        children: "children",
        label: "label"
      },
      dataList: [],
      form: {
        richeid: "",
        name: "",
        certifyNo: "",
        tel: ""
      },
      saveForm: {
        realname: "",
        sex: "",
        tel: "",
        certifyno: "",
        bankcardid: "",
        reference: "",
        remark: ""
      },
      dialog: {
        title: "新增事业合伙人",
        visible: false,
        loading: false
      },
      dialog1: {
        title: "",
        visible: false,
        paginator: null,
        form: {
          richeid: "",
          name: "",
          certifyNo: "",
          tel: ""
        },
        dataList: []
      },
      dialog2: {
        visible: false,
        tree: null
      },
      page: {
        start: 1,
        size: 10
      },
      paginator: null,
      checked: false,
      rules: {
        realname: [
          {
            required: true,
            trigger: "blur",
            validator: createLengthValidate(1, "请输入姓名")
          }
        ],
        sex: [
          {
            required: true,
            trigger: "blur",
            validator: createLengthValidate(1, "请选择性别")
          }
        ],
        tel: [
          {
            required: true,
            trigger: "blur",
            validator: createLengthValidate(1, "请输入手机号")
          }
        ],
        certifyno: [
          {
            required: true,
            trigger: "blur",
            validator: createLengthValidate(1, "请输入证件号")
          }
        ],
        bankcardid: [
          {
            required: true,
            trigger: "blur",
            validator: createLengthValidate(1, "请输入银行卡号")
          }
        ],
        reference: [
          {
            trigger: "blur",
            validator: (rule, value, callback) => {
              if (self.checked && value.length < 1) {
                callback(new Error("请输入推荐人信息"));
              }
              callback();
            }
          }
        ]
      }
    };
  },
  methods: {
    async isAllowUpdateState(message) {
      try {
        await this.$confirm(message, "提示", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
        });
        return true;
      } catch (error) {}
      return false;
    },
    async handleClickEdit(action, row) {
      this.dialog.title = `${action === 2 ? "编辑" : "新增"}事业合伙人`;
      if (action === 2) {
        let data = await this.getPartner(row.richeid);
        if (data) {
          this.saveForm = data;
        }
      }
      this.dialog.visible = true;
    },
    async handleOpenDialog1(row) {
      this.dialog1.title = `<span>顾问ID：${row.richeid}</span><span>姓名：${
        row.realname
      }</span><span>级别：${row.levelName}</span>`;

      this.dialog1.visible = true;
    },
    async handleOpenDialog2(row) {
      try {
        this.dialog2.tree = [
          {
            id: row.richeid,
            label: `${row.realname}(${row.richeid}) -- ${row.levelName}`,
            children: []
          }
        ];
        this.setChildren(this.dialog2.tree[0]);
        this.dialog2.visible = true;
      } catch (error) {}
    },
    async setChildren(node) {
      const self = this;
      try {
        const resp = await partnerProvider.queryDirectUserTree(node.id);
        resp.data.forEach(d => {
          let node1 = {
            id: d.richeid,
            label: `${d.realname}(${d.richeid}) -- ${d.levelName}`,
            children: []
          };
          self.setChildren(node1);
          node.children.push(node1);
        });
      } catch (error) {
        console.error(error);
      }
    },
    handleNodeClick(node) {
      console.dir(arguments);
    },
    handleSubmit() {
      const self = this;
      this.$refs.saveForm.validate(valid => {
        if (valid) {
          const loading = self.$loading({
            lock: true,
            text: "保存中",
            spinner: "el-icon-loading",
            background: "rgba(0, 0, 0, 0.7)"
          });
          let flag = false;
          if (!self.checked) {
            flag = self.savePartenr(
              Object.assign({}, self.saveForm, { reference: null })
            );
          } else {
            flag = self.savePartenr(self.saveForm);
          }
          if (flag) {
            self.fetch(1);
            self.dialog.visible = false;
          }
          loading.close();
        } else {
          return false;
        }
      });
    },
    async handleCheck(row) {
      const flag = await this.isAllowUpdateState("确认审核通过？");
      if (flag) {
        try {
          const resp = await partnerProvider.updateState(row.richeid, 1);
          this.$message({
            type: "success",
            message: "审核成功"
          });
          this.fetch(this.page.start);
        } catch (error) {
          this.$message({
            type: "error",
            message: "审核失败"
          });
        }
      }
    },
    async handleDelete(row) {
      const flag = await this.isAllowUpdateState("确认删除？");
      if (flag) {
        try {
          const resp = await partnerProvider.updateState(row.richeid, 3);
          this.$message({
            type: "success",
            message: "删除成功"
          });
          this.fetch(1);
        } catch (error) {
          this.$message({
            type: "error",
            message: "删除失败"
          });
        }
      }
    },
    async handleCancel(row) {
      const flag = await this.isAllowUpdateState("确认解约？");
      if (flag) {
        try {
          const resp = await partnerProvider.updateState(row.richeid, 2);
          this.$message({
            type: "success",
            message: "解约成功"
          });
          this.fetch(this.page.start);
        } catch (error) {
          this.$message({
            type: "error",
            message: "解约失败"
          });
        }
      }
    },
    async handleSizeChange(val) {
      console.log(`每页${val}数据`);
      this.page.size = val;
      this.fetch();
    },
    async handleCurrentChange(val) {
      console.log(`请求${val}数据`);
      this.page.start = val;
      this.fetch(val);
    },
    async getPartner(id) {
      try {
        const resp = await partnerProvider.getPartner(id);
        const {
          richeid,
          realname,
          sex,
          tel,
          certifyno,
          bankcardid,
          reference,
          remark
        } = resp.data;
        if (reference) {
          this.checked = true;
        }
        return {
          richeid,
          realname,
          sex,
          tel,
          certifyno,
          bankcardid,
          reference,
          remark
        };
      } catch (error) {}
      return null;
    },
    async savePartenr(data) {
      try {
        const resp = await partnerProvider.savePartner(data);
        return true;
      } catch (error) {
        console.error(error);
      }
      return false;
    },
    async fetch(pageNum = 1) {
      try {
        const resp = await partnerProvider.queryPartners(
          Object.assign({}, this.form, {
            pageNum,
            pageSize: this.pageSize
          })
        );
        this.page.start = pageNum;
        this.dataList = resp.data;
        this.paginator = resp.paginator;
      } catch (error) {
        console.dir(error);
      }
    }
  },
  activated() {},
  created() {
    this.fetch();
  }
};
</script>
<style lang="scss" scoped>
.v-partner-list /deep/ {
  .el-table {
    .table-header {
      background-color: #eee;
      th {
        background-color: #eee;
      }
    }
  }

  .el-dialog {
    max-width: 700px;

    .el-dialog__title {
      span {
        margin-right: 20px;
      }
    }

    .el-form-item {
      .el-select {
        &.sex {
          .el-input__inner {
            padding-right: 15px;
          }
        }
      }
      &.remark,
      &.bankcardid {
        .el-form-item__content {
          width: 515px;
        }
      }
    }
  }
  .dialog1 {
    .el-dialog {
      max-width: 2000px;
      width: 60%;
    }
  }
}
</style>
