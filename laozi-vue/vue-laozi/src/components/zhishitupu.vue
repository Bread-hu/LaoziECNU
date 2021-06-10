<template>
    <el-container>
      <el-header height="150px">
        <el-image
          style="margin-left: 0px; margin-top: 40px"
          :src="require('../assets/logo.png')"
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
            style="font-size: 35px; width: 13%"
          >
            <template slot="title">
              <span style="font-size: 20px">{{ item.name }}</span>
            </template>

          </el-menu-item>
        </el-menu>
      </el-header>

      <el-container>
        <el-aside>

        </el-aside>

        <el-main style="background-color: #272b30">

        </el-main>
      </el-container>
    </el-container>
</template>

<script>
import * as d3 from 'd3'
export default {
  name: 'zhishitupu',
  data(){
    return {
      button_list: [
        {name: "首页", path: "/"},
        {name: "成语", path: "/chengyu"},
        {name: "作者", path: "/zuozhe"},
        {name: "文献", path: "/wenxian"},
        {name: "时空间GIS", path: "/shikongjian"},
        {name: "知识图谱", path: "/zhishitupu"},
        {name: "老子", path: "/laozi"},
      ]
    }
  }
}
</script>

<style scoped>

</style>
