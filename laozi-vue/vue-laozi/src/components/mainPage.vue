<template>

    <el-container>
      <el-header>
        <top-bar></top-bar>
      </el-header>
      <el-container >
      <el-main style="margin-top:5vh;width: 100%;height:70vh;text-align: center;">

        <div class="div_block" >
          <p class="text_mode">成语</p>
          <p class="text_mode_1" style="font-size: 20px;float: top ">成语字典全录入</p>
        </div>
        <div class="div_block" >
          <p class="text_mode">作者</p>
          <p class="text_mode_1" style="font-size: 20px;float: top ">古籍诗词作者全录入</p>
        </div>
        <div class="div_block" >
          <p class="text_mode">文献</p>
          <p class="text_mode_1" style="font-size: 20px;float: top ">古籍核心文献</p>
        </div>
        <div class="div_block" >
          <p class="text_mode">古籍GIS</p>
          <p class="text_mode_1" style="font-size: 20px;float: top ">作者古籍时空间变化</p>
        </div>
        <div class="div_block" >
          <p class="text_mode">知识图谱</p>
          <p class="text_mode_1" style="font-size: 20px;float: top ">作者古籍知识图谱</p>
        </div>
        <div class="div_block" >
          <p class="text_mode">道德经</p>
          <p class="text_mode_1" style="font-size: 20px;float: top ">道经德经多种翻译</p>
        </div>

      </el-main>

      </el-container>
      <el-footer>
        <foot-bar></foot-bar>
      </el-footer>
    </el-container>


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
    test() {
      console.log(1111)
    }
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
.div_block{
  width:10%;
  height:80%;
  display: inline-block;
  background-color: #d3b17d;
  opacity:0.3;
  -webkit-transition-duration: 0.5s;
  border-radius:5px
}
.div_block:hover{
  width: 16%;
  opacity: 0.5;
  /*background-image: url("../assets/laozi_1.jpg");*/

}
.div_block:hover .text_mode_1{
  display: block;
}

.text_mode{
  font-size: 40px;
  display: block;
  opacity: 1.0;
  color: white;
  writing-mode: vertical-rl;
  -webkit-writing-mode: vertical-rl;
  margin-top: 50px;
  margin-left: 30px;
}
.text_mode_1{
  font-size: 40px;
  /*display: block;*/
  opacity: 1.0;
  color: white;
  margin-top: 50px;
  margin-left: 30px;
  writing-mode: vertical-rl;
  -webkit-writing-mode: vertical-rl;
  float: right;
  display: none;
}

/*.dt{*/
/*  writing-mode: vertical-lr;*/
/*  writing-mode: tb-lr;*/
/*}*/
</style>
