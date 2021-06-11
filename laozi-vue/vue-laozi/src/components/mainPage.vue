<template>
  <div id="app">
    <el-container>
      <el-header>
        <top-bar></top-bar>
      </el-header>
      <el-main>
      </el-main>
      <el-footer>
        <foot-bar></foot-bar>
      </el-footer>
    </el-container>
  </div>
</template>

<script>
export default {
  name: "mainPage",
  data() {
    return {
      input1: "",
      select: "",
    };
  },
  methods:{
    goPage(path) {
      this.$router.push(path);
    },
  },
};
</script>

<style scoped>
#app {
  width: 100%;
  height: 100%;
  position: fixed;
  background-size: 100% 100%;
}
.input-with-select .el-input-group__prepend {
  background-color: #fff;
}
</style>
