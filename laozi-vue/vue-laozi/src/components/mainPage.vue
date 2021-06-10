<template>
  <div id="app">
    <el-container>
      <el-header height="130px">
        <el-image
          style="margin-left: 400px; margin-top: 40px"
          :src="require('../assets/logo.png')"
        ></el-image>
      </el-header>
      <el-main>
        <el-row class="row_1">
          <!--           <button class="button_1" plain size="large">成语</button>
          <button class="button_1" plain size="large">作者</button>
          <button class="button_1" plain size="large">文献</button>
          <button class="button_1" plain size="large">时空间GIS</button>
          <button class="button_1" plain size="large">知识图谱</button>
          <button class="button_1" plain size="large">老子</button> -->
          <button
            v-for="item in button_list"
            :key="item.path"
            class="button_1"
            plain
            size="large"
            @click="goPage(item.path)"
          >
            {{ item.title }}
          </button>
        </el-row>
        <div style="margin-top: 250px; margin-left: 50%; width: 30%">
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
        <div style="width: 30%; margin-top: -300px; margin-left: 100px">
          <el-image
            style="margin-left: 100px; margin-top: 60px"
            :src="require('../assets/laozi_1.jpg')"
          ></el-image>
        </div>
      </el-main>
    </el-container>
  </div>
</template>

<script>
export default {
  name: "mainPage",
  data() {
    return {
      button_list: [{title:"成语",path:"/chengyu"}, {title:"作者",path:"/zuozhe"}, {title:"文献",path:"/wenxian"}, {title:"时空间GIS",path:"/shikongjian"}, {title:"知识图谱",path:"/zhishitupu"}, {title:"道德经",path:"/daodejing"}],
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
.logo_top {
  margin-left: 500px;
}
.button_1 {
  margin-left: 0%;
  background-color: transparent;
  float: left;
  border: none;
  width: 16.6%;
  font-size: 50px;
}
.button_1:hover {
  background-color: beige;
}
.row_1 {
  margin-left: 0%;
}
#app {
  background-color: wheat;
  width: 100%;
  height: 100%;
  position: fixed;
  background-size: 100% 100%;
}
.input-with-select .el-input-group__prepend {
  background-color: #fff;
}
</style>
