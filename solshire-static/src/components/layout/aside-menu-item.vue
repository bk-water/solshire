<template>
    <div class="c-aside-menu-item">
        <template v-for="(menu,i) in menus">
            <router-link :key="i" :to="menu.path">
                <el-menu-item index="1-1">
                    <span>{{menu.name}}</span>
                </el-menu-item>
            </router-link>
        </template>
    </div>
</template>
<script>
export default {
  name: "CAsideMenuItem",
  props: {
    menus: {
      type: Array
    }
  },
  methods: {
    hasChildren(item) {
      return item.children.length > 1;
    }
  }
};
</script>
