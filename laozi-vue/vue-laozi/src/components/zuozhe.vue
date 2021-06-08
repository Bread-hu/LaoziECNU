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

    <el-container style="margin-top: 0px">
      <el-aside width="250px" style="margin-top: 0px">
        <el-menu
          class="el-menu-vertical-demo"
          default-active="1"
          style="border-right: 0"
        >
          <el-submenu v-for="item in dynasty_list" :key="item.index" :index="item.index">
            <template slot="title">
              <i class="el-icon-collection"></i>
              <span style="font-size: 20px">{{ item.name }}</span>
            </template>
            <el-menu-item-group>
              <el-menu-item 
              v-for="num in item.maxPage"
              :key="num"
              index="item.name+num"
              @click="getAuthor(item.name,num)">
              {{"第"+num+"页"}}
              </el-menu-item>
            </el-menu-item-group>
          </el-submenu>
        </el-menu>
      </el-aside>
      <el-main>
        
      </el-main>
    </el-container>
  </el-container>
</template>

<script>
export default {
  name: "zuozhe",
  data() {
    return {
      button_list: [
        { name: "首页", path: "/" },
        { name: "成语", path: "/chengyu" },
        { name: "作者", path: "/zuozhe" },
        { name: "文献", path: "/wenxian" },
        { name: "时空间GIS", path: "/shikongjian" },
        { name: "知识图谱", path: "/zhishitupu" },
        { name: "老子", path: "/laozi" },
      ],
      dynasty_list: [
        { name: "不限", maxPage:50, index:"1"},
        { name: "先秦", maxPage:20, index:"2"},
        { name: "两汉", maxPage:10, index:"3"},
        { name: "晋魏", maxPage:3, index:"4"},
        { name: "南北朝", maxPage:5, index:"5"},
        { name: "隋唐", maxPage:7, index:"6"},
        { name: "唐代", maxPage:8, index:"7"},
        { name: "五代", maxPage:2, index:"8"},
        { name: "宋代", maxPage:4, index:"9"},
        { name: "金朝", maxPage:6, index:"10"},
        { name: "元代", maxPage:7, index:"11"},
        { name: "明代", maxPage:0, index:"12"},
        { name: "清代", maxPage:5, index:"13"},
      ],
    };
  },
  methods: {
    getAuthor()
  },
};
</script>

<style scoped>
</style>
