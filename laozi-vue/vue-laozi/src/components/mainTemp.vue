<template>
  <el-container>
    <el-header>
      <el-image
        :src="require('../assets/logo.png')"
        style="margin-left: 400px"
      ></el-image>
      <el-container
        style=" background-color: #666666; margin-top: 20px"
      >
        <el-menu background-color="#EEEEEE"  mode="horizontal">
          <el-menu-item
            v-for="item in button_list"
            :key="item.name"
            index="item.name"
            @click="goPage(item.path)"
            >{{ item.name }}</el-menu-item
          >
        </el-menu>
        <el-carousel indicator-position="outside">

        </el-carousel>
      </el-container>
    </el-header>
  </el-container>
</template>

<script>
export default {
  name: "tempPage",
  data() {
    return {
      button_list: [
        { title: "成语", path: "/chengyu" },
        { title: "作者", path: "/zuozhe" },
        { title: "文献", path: "/wenxian" },
        { title: "时空间GIS", path: "/shikongjian" },
        { title: "知识图谱", path: "/zhishitupu" },
        { title: "老子", path: "/daodejing" },
      ],
    };
  },
  methods: {},
};
</script>

<style scoped>
</style>
