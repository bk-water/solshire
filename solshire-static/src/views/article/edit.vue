<template>
    <div class="v-article-edit">
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="标题" prop="name">
          <el-input v-model="form.name" style="max-width:500px"></el-input>
        </el-form-item>
        <el-form-item label="类型" prop="type">
          <el-select v-model="form.type" placeholder="请选择类型">
            <el-option v-for="(item,i) in types"
                      :key="i"
                      :label="item"
                      :value="i">
                    </el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="首图">
            <el-upload
            drag
            :action="action" name="upfile"
            :limit="1" accept="jpg,png" :file-list="files" list-type="picture-card" :with-credentials="true" :auto-upload="true" :on-success="handleUploadSuccess">
            <i class="el-icon-upload"></i>
            <div class="el-upload__text">将文件拖到此处，或<em>点击上传</em></div>
            <div class="el-upload__tip" slot="tip">只能上传jpg/png文件，且不超过500kb</div>
          </el-upload>
        </el-form-item>
        <el-form-item label="提示">
          <el-input v-model="form.tip" style="max-width:500px"></el-input>
        </el-form-item>
        <el-form-item label="排序">
          <el-input-number v-model="form.sort" :min="1" :max="100000000"></el-input-number>
        </el-form-item>
        <el-form-item label="内容" prop="context">
          <c-rich-text-editor v-model="form.context"></c-rich-text-editor>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" :loading="loading" @click.native.prevent="handleSubmitForm">保存</el-button>
          <el-button @click.native.prevent="$router.push({name:'article-list'})">返回</el-button>
        </el-form-item>
      </el-form>
    </div>
</template>
<script>
import CRichTextEditor from "@/components/rich-text-editor";
import { createLengthValidate } from "@/utils/validate";
import articleProvider from "@/providers/articleProvider";

export default {
  name: "VArticleEdit",
  components: {
    CRichTextEditor
  },
  data() {
    return {
      action: `${process.env.VUE_APP_API_BASE_URL}/gen/uploadFile`,
      types: [
        "划动banner",
        "为您精选",
        "产品优惠",
        "保险理财",
        "基金理财",
        "管理咨询"
      ],
      form: {
        id: null,
        name: "",
        type: "",
        image: "",
        tip: "",
        sort: 1,
        context: ""
      },
      rules: {
        name: [
          {
            required: true,
            trigger: "blur",
            validator: createLengthValidate(1, "请输入标题")
          }
        ],
        type: [
          {
            required: true,
            trigger: "blur",
            validator: createLengthValidate(1, "请选择类型")
          }
        ],
        context: [
          {
            required: true,
            trigger: "blur",
            validator: createLengthValidate(1, "请输入内容")
          }
        ]
      },
      loading: false
    };
  },
  computed: {
    files() {
      if (this.form.image) {
        return [{ url: process.env.VUE_APP_IMG_DOMAIN + this.form.image }];
      }
      return [];
    }
  },
  methods: {
    async saveArticle() {
      try {
        const resp = await articleProvider.saveArticle(this.form);
        this.form.id = resp.data.id;
        this.$message({
          type: "success",
          message: "保存成功!"
        });
      } catch (error) {
        this.$message({
          message: e.msg,
          center: true
        });
      }
      this.loading = false;
    },
    handleUploadSuccess(resp) {
      this.form.image = resp.path;
    },
    handleSubmitForm() {
      const self = this;
      this.$refs.form.validate(valid => {
        if (valid) {
          self.loading = true;
          self.saveArticle();
        } else {
          return false;
        }
      });
    },
    setData(data) {
      this.form = data;
    }
  },
  activated() {},
  beforeRouteEnter(to, from, next) {
    if (to.query.id) {
      articleProvider.getArticle(to.query.id).then(resp => {
        next(vm => vm.setData(resp.data));
      });
    } else {
      next();
    }
  }
};
</script>
<style lang="scss" scoped>
.v-article-edit /deep/ {
  .el-form-item {
    .el-upload--picture-card {
      width: 360px;
      height: 180px;
    }
  }
}
</style>
