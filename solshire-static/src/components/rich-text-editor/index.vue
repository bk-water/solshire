<template>
    <div class="tinymce-container editor-container" :class="{fullscreen:fullscreen}">
        <textarea :id="editorId"></textarea>
        <el-dialog title="图片上传" :visible.sync="dialogVisible" :append-to-body="true">
          <el-upload
            drag
            :action="action" name="upfile"
            multiple accept="jpg,png" list-type="picture-card" :with-credentials="true" :auto-upload="true" :on-success="handleUploadSuccess">
            <i class="el-icon-upload"></i>
            <div class="el-upload__text">将文件拖到此处，或<em>点击上传</em></div>
            <div class="el-upload__tip" slot="tip">只能上传jpg/png文件，且不超过500kb</div>
          </el-upload>
        </el-dialog>
    </div>
</template>
<script>
import plugins from "./plugins";
import toolbar from "./toolbar";

export default {
  name: "CRichTextEditor",
  props: {
    id: {
      type: String
    },
    language: {
      type: String,
      default: "zh_CN"
    },
    height: {
      type: Number,
      default: 360
    },
    value: {
      type: String,
      default: ""
    },
    toolbar: {
      type: Array,
      default() {
        return [];
      }
    },
    menubar: {
      type: String,
      default: "file edit insert view format table"
    },
    theme: "modern",
    config: {
      type: Object,
      default() {
        return {};
      }
    }
  },
  data() {
    return {
      editorId: this.id || `rich-text-editor-${Date.now()}`,
      hasChange: false,
      hasInit: false,
      fullscreen: false,
      dialogVisible: false,
      action: `${process.env.VUE_APP_API_BASE_URL}/gen/uploadFile`,
      uploadSuccessCallback: null
    };
  },
  watch: {
    value(val) {
      if (!this.hasChange && this.hasInit) {
        this.$nextTick(() =>
          window.tinymce.get(this.tinymceId).setContent(val || "")
        );
      }
    }
  },
  computed: {
    options() {
      const self = this;
      return Object.assign(
        {
          language: this.language,
          height: this.height,
          theme: this.theme,
          body_class: "panel-body ",
          object_resizing: false,
          toolbar: this.toolbar.length > 0 ? this.toolbar : toolbar,
          menubar: this.menubar,
          plugins: plugins,
          end_container_on_empty_block: true,
          powerpaste_word_import: "clean",
          code_dialog_height: 450,
          code_dialog_width: 1000,
          advlist_bullet_styles: "square",
          advlist_number_styles: "default",
          imagetools_cors_hosts: ["www.tinymce.com", "codepen.io"],
          default_link_target: "_blank",
          link_title: false,
          importcss_append: true,
          uploadCallback(cb) {
            self.uploadSuccessCallback = cb;
            self.dialogVisible = true;
          }
        },
        this.config
      );
    }
  },
  methods: {
    init() {
      const self = this;
      const customEditor = window.tinymce.init({
        ...this.options,
        selector: `#${this.editorId}`,
        init_instance_callback: editor => {
          if (self.value) {
            editor.setContent(self.value);
          }
          self.hasInit = true;
          editor.on("NodeChange Change KeyUp SetContent", () => {
            self.hasChange = true;
            self.$emit("input", editor.getContent());
          });
        },
        setup(editor) {
          editor.on("init", e => {
            self.$emit("ready");
          });
          editor.on("FullscreenStateChanged", e => {
            self.fullscreen = e.state;
            self.$emit("state-change", e);
          });
        }
      });
    },
    destroy() {},
    setContent() {
      window.tinymce.get(this.editorId).setContent(value);
    },
    getContent() {
      window.tinymce.get(this.editorId).getContent();
    },
    handleUploadSuccess(resp) {
      this.uploadSuccessCallback(process.env.VUE_APP_IMG_DOMAIN+resp.path)
    }
  },
  mounted() {
    tinymce.PluginManager.load(
      "upload",
      "/tinymce.4.7.13/plugins/upload/plugin.js"
    );
    console.dir(tinymce);
    this.init();
  },
  activated() {
    this.init();
  },
  deactivated() {
    this.destroy();
  },
  destroyed() {
    this.destroy();
  }
};
</script>
<style lang="scss" scoped>
.tinymce-container /deep/ {
  position: relative;
  .mce-fullscreen {
    z-index: 10000;
  }
}

.tinymce-textarea {
  visibility: hidden;
  z-index: -1;
}
.editor-custom-btn-container {
  position: absolute;
  right: 4px;
  top: 4px;
  /*z-index: 2005;*/
}
.fullscreen .editor-custom-btn-container {
  z-index: 10000;
  position: fixed;
}
.editor-upload-btn {
  display: inline-block;
}
.el-dialog__wrapper /deep/ {
  .el-upload {
    width: 100%;
    height: 300px;
    .el-upload-dragger {
      width: 100%;
      height: 300px;
      display: flex;
      flex-direction: column;
      justify-content: center;
      align-items: center;
    }
  }
  .el-upload__tip {
    text-align: right;
  }
}
</style>
