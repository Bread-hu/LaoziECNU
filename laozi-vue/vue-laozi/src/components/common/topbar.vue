<template>
  <div style="text-align: center;margin: 0 auto">
      <el-image
          :src="require('../../assets/logo.png')"
          style="display: inline-block;vertical-align:middle"
      ></el-image>
      <el-menu
        default-active="activeIndex"
        class="el-menu-demo"
        mode="horizontal"
        style="display: inline-block;width: 40%;vertical-align:middle;border: none"
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
    <div style="display: inline-block; width: 25%; vertical-align:middle">
      <el-input
        placeholder="请输入内容"
        v-model="input1"
        class="input-with-select"
      >
        <el-select
          style="width: 100px"
          v-model="select"
          slot="prepend"
          placeholder="请选择"
        >
          <el-option label="成语" value="1"></el-option>
          <el-option label="老子" value="2"></el-option>
          <el-option label="作者" value="3"></el-option>
        </el-select>
        <el-button slot="append" icon="el-icon-search"></el-button>
      </el-input>
    </div>
  </div>
</template>

<script>
export default {
  name: "topbar",
  data() {
    return {
      input1 : undefined,
      select: undefined,
      button_list: [
        {name: "首页", path: "/"},
        {name: "成语", path: "/chengyu"},
        {name: "作者", path: "/zuozhe"},
        {name: "文献", path: "/wenxian"},
        {name: "古籍GIS", path: "/shikongjian"},
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
