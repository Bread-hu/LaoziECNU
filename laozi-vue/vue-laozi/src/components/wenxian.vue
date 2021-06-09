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
      <el-container style="margin-top: 0px; height: 100%">
        <el-aside width="250px" style="margin-top: 0px">
          <el-menu
            class="el-menu-vertical-demo"
            default-active="1"
            style="border-right: 0"
          >
            <el-submenu v-for="item in pinyin_list" :key="item.name" :index="item.name">
              <template slot="title">
                <i class="el-icon-collection"></i>
                <span style="font-size: 20px">{{ item.name }}</span>
              </template>
              <el-menu-item-group>
                <el-menu-item
                  v-for="head in item.head_list"
                  :key="head"
                  index="head"
                  @click="getChengyu(head)">
                  {{head}}
                </el-menu-item>
              </el-menu-item-group>
            </el-submenu>
          </el-menu>
        </el-aside>
      </el-container>
    </el-container>
</template>

<script>
  export default {
    name: 'wenxian',
    data(){

    },
    created() {
      var that = this;
      this.axios({
          url: '/getSubBookByBookId',
          method: 'post',
          data:{
            book_id:'book_276'
          }
      })
    }
  }
</script>

<style scoped>
p{
  width: 1500px;
  word-wrap: break-word;
  word-break: break-all;
}
</style>

