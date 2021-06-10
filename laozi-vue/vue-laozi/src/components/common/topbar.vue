<template>
  <div>
      <el-image
          :src="require('../../assets/logo.png')"
      ></el-image>
      <el-menu
        default-active="activeIndex"
        class="el-menu-demo"
        mode="horizontal"
        style="margin-top: -60px; margin-left: 250px"
      >
        <el-menu-item
          v-for="item in button_list"
          :key="item.name"
          index="item.name"
          @click="goPage(item.path)"
          style="font-size: 20px"
        >{{ item.name }}
        </el-menu-item
        >
      </el-menu>
  </div>
</template>

<script>
export default {
  name: "topbar",
  data() {
    return {
      button_list: [
        {name: "首页", path: "/"},
        {name: "成语", path: "/chengyu"},
        {name: "作者", path: "/zuozhe"},
        {name: "文献", path: "/wenxian"},
        {name: "时空间GIS", path: "/shikongjian"},
        {name: "知识图谱", path: "/zhishitupu"},
        {name: "道德经", path: "/daodejing"},
      ]
    }
  },
  methods:{
    goPage(path) {
      this.$router.push(path);
    }
  }
}
</script>
