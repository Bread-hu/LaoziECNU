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
            <el-submenu v-for="(item, key) in main_book_list" :key="key" :index="key">
              <template slot="title">
                <i class="el-icon-collection"></i>
                <span style="font-size: 20px">{{ key }}</span>
              </template>
              <el-menu-item-group>
                <el-menu-item
                  v-for="head in item"
                  :key="head.book_name"
                  :index="head.book_name"
                  @click="getBook(head.book_name)"
                  >
                  {{head.book_name}}
                </el-menu-item>
              </el-menu-item-group>
            </el-submenu>
          </el-menu>
        </el-aside>
        <el-main>
<!--          <p>{{book_content.book_name}}</p>-->
          <h2>书名</h2>

          <h1>{{book_content.book_name}}</h1>
          <el-divider></el-divider>
          <h2>时代</h2>
          <h1>{{book_content.dynasty}}</h1>
          <el-divider></el-divider>
          <h2>简介</h2>

          <p>{{book_content.introduction}}</p>
          <el-divider></el-divider>

          <h2>章节</h2>
          <div v-for="item in chapter_list" :key="item.subook_id" :index="item.subook_id">
          <el-button type="text" style="font-size: 20px" @click="getSubook(item)">{{item.subsubook_name}}</el-button>
            <el-divider></el-divider>
          </div>

          <el-dialog title="具体章节" :visible.sync="visible">
            <span>{{ subook_content }}</span>
          </el-dialog>

        </el-main>
      </el-container>
    </el-container>
</template>

<script>
  export default {
    name: 'wenxian',
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
        ],
        main_book_list: {'经部':["xi"],'史部':["xi"],'子部':["xi"],'集部':["xi"]},
        book_content: {book_name:"这是书名",dynasty:"这是朝代",introduction:"这是介绍"},
        chapter_list:[],
        subook_content:"这是一个具体章节",
        visible: false
      }
    },
    created() {
      var that = this;
      var keys = Object.keys(that.main_book_list)
      console.log(keys)
      for (var i=0;i<keys.length;i++)
      {
        this.axios({
          url: '/literaturesByType',
          method: 'post',
          data: {
            category: keys[i],
            page: 0
          }
        }).then(
          function (response){
            console.log(response.data)
            that.main_book_list[response.data[0].category] = response.data
          },
          function (err){
            console.log(err)
          }
        )
      }
      // for (var i=0;i<keys.length;i++){
      //   console.log(that.main_book_list[i])
      // }
      // console.log(keys)
      // for (var i=0;i<keys.length;i++) {
      //   this.axios({
      //     url: '/literaturesByType',
      //     method: 'post',
      //     data: {
      //       category: keys[i],
      //       page: 0
      //     }
      //   }).then(
      //     function (response) {
      //       console.log(response.data)
      //     },
      //     function (err) {
      //       console.log(err)
      //     }
      //   )
      // }
    },
    methods:{
      goPage(path) {
        this.$router.push(path);
      },
      getBook(book_name){
        var that = this;
        var that_that = this;
        this.axios({
          url: '/getBookByName',
          method: 'post',
          data: {
            book_name: book_name
          }
        }).then(
          function (response){
            console.log(response.data);
            var book_id = response.data.book_id;
            that.book_content.book_name = response.data.book_name;
            console.log(that.book_content.book_name)
            that.book_content.dynasty = response.data.dynasty;
            console.log(that.book_content.dynasty)
            that.book_content.introduction = response.data.introduction;
            console.log(that.book_content.introduction)
            console.log(book_id)
            that.axios({
              url:'/getSubBookByBookId',
              method:'post',
              data:{
                book_id: book_id
              }
            }).then(
              function (response){
                console.log(response.data)
                that_that.chapter_list = response.data
              },
              function (err){
                console.log(err)
              }
            )
          },
          function (err){
            console.log(err)
          }
        )
      },
      getSubook(item){

        var that = this;
        that.visible = true
        console.log(item)
        this.axios({
          url:'/getBookContent',
          method:'post',
          data:{
            subook_id:item.subook_id,
            subook_name:item.subook_name,
            subsubook_name:item.subsubook_name,
          }
        }).then(
          function (response){
            console.log(response.data)
            that.subook_content = response.data.content
          },
          function (err){
            console.log(err)
          }
        )
      }
    },

  }
</script>

<style scoped>
p{
  width: 1500px;
  word-wrap: break-word;
  word-break: break-all;
}
</style>

