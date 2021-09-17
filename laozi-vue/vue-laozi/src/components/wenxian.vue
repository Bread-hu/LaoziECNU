<template>
    <el-container>
      <el-header>
        <top-bar></top-bar>
      </el-header>
      <el-container style="margin-top: 0px; height: 100%">
        <el-aside width="250px" style="margin-top: 0px;height: 2000px">
          <el-menu
            class="el-menu-vertical-demo"
            default-active="1"
            style="border-right: 0"
          >
            <el-menu-item v-for="(item, key) in main_book_list" :key="key" :index="key" @click="getBookList(item)">

                <i class="el-icon-collection"></i>
                <span style="font-size: 20px">{{ key }}</span>

<!--              <el-menu-item-group>-->
<!--                <el-menu-item-->
<!--                  v-for="head in item"-->
<!--                  :key="head.book_name"-->
<!--                  :index="head.book_name"-->
<!--                  @click="getBook(head.book_name)"-->
<!--                  >-->
<!--                  {{head.book_name}}-->
<!--                </el-menu-item>-->
<!--              </el-menu-item-group>-->
            </el-menu-item>
          </el-menu>
        </el-aside>
        <el-main class="main_block">
          <div class="divbg">
            <div class="mcon" style="margin-top: 10px;text-align:center;margin:0 auto">
              <div v-for="item in show_book_list" :key="item.book_name" :index="item.book_name" style="height:auto;text-align: left;margin-top: 20px;background-color:#F0EFE2">
<!--                <img src="../assets/laozi_book.jpg" style="width: auto; float: left;vertical-align:middle;margin-top: 20px" />-->
<!--                <div style="display: inline-block;vertical-align: top;">-->
                  <el-button type="text" style="font-size: 20px;display: block;font-color: 	#000000;font-weight:bold" @click="getBook(item.book_name)">{{item.book_name}}</el-button>
                  <p style="font-size: 14px;width: 100%;margin: 0;" v-html="item.introduction">{{item.introduction}}</p>
<!--                </div>-->

              </div>
                <button v-for="num in page_num" :key="num" :index="num" @click="goNum(num)" class="button_css">{{num}}</button>
            </div>
<!--            <div v-for="item in show_book_list" :key="item.book_name" :index="item.book_name" style="height:auto ">-->
<!--              -->
<!--            </div>-->
          </div>
<!--          <p>{{book_content.book_name}}</p>-->
<!--          <h2>书名</h2>-->

<!--          <h1>{{book_content.book_name}}</h1>-->
<!--          <el-divider></el-divider>-->
<!--          <h2>时代</h2>-->
<!--          <h1>{{book_content.dynasty}}</h1>-->
<!--          <el-divider></el-divider>-->
<!--          <h2>简介</h2>-->

<!--          <p>{{book_content.introduction}}</p>-->
<!--          <el-divider></el-divider>-->

<!--          <h2>章节</h2>-->
<!--          <div v-for="item in chapter_list" :key="item.subook_id" :index="item.subook_id">-->
<!--          <el-button type="text" style="font-size: 20px" @click="getSubook(item)">{{item.subsubook_name}}</el-button>-->
<!--            <el-divider></el-divider>-->
<!--          </div>-->

<!--          <el-dialog title="具体章节" :visible.sync="visible">-->
<!--            <span>{{ subook_content }}</span>-->
<!--          </el-dialog>-->
        </el-main>
      </el-container>
      </el-container>
</template>

<script>
  export default {
    name: 'wenxian',
    data(){
      return {

        now_book_list:[],
        show_book_list:[],
        page_num:0,
        show_num:10,
        now_page:1,

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
            if(response.data[0].category == "经部"){
              console.log(response.data.length)
              that.show_book_list = response.data.slice(0,10)
              that.now_page = 1
              that.page_num = Math.ceil(response.data.length/that.show_num)
              console.log(that.page_num)
            }
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
        // var that = this;
        // var that_that = this;
        // this.axios({
        //   url: '/getBookByName',
        //   method: 'post',
        //   data: {
        //     book_name: book_name
        //   }
        // }).then(
        //   function (response){
        //     console.log(response.data);
        //     var book_id = response.data.book_id;
        //     that.book_content.book_name = response.data.book_name;
        //     console.log(that.book_content.book_name)
        //     that.book_content.dynasty = response.data.dynasty;
        //     console.log(that.book_content.dynasty)
        //     that.book_content.introduction = response.data.introduction;
        //     console.log(that.book_content.introduction)
        //     console.log(book_id)
        //     that.axios({
        //       url:'/getSubBookByBookId',
        //       method:'post',
        //       data:{
        //         book_id: book_id
        //       }
        //     }).then(
        //       function (response){
        //         console.log(response.data)
        //         that_that.chapter_list = response.data
        //       },
        //       function (err){
        //         console.log(err)
        //       }
        //     )
        //   },
        //   function (err){
        //     console.log(err)
        //   }
        // )
        this.$router.push({
          path: '/book',
          query: {
            bookname: book_name,
          }
        });

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
      },
      getBookList(item){
        console.log(item)
        var that = this;
        that.page_num = Math.ceil(item.length / that.show_num);
        that.now_page = 1;
        that.show_book_list = item.slice((that.now_page-1)*that.show_num, that.now_page*that.show_num)
        that.now_book_list = item
      },
      goNum(num){
        var that = this
        that.now_page = num
        that.show_book_list = that.now_book_list.slice((that.now_page-1)*that.show_num, that.now_page*that.show_num)
      }
    },


  }
</script>

<style scoped>
p{
  word-wrap: break-word;
  word-break: break-all;
  display: block;
  text-indent: 2em;
  margin-block-start: 1em;
  margin-block-end: 1em;
  margin-inline-start: 0px;
  margin-inline-end: 0px;
  color: #333333;
  line-height:200%;
}
.button_css{
  width: auto;
  height: auto;
  padding: 5px 10px;
  background-color: #e5e7e4;
  text-align: center;
  margin: 0 auto;
  border: 1px solid #e5e7e4;
  margin: 12px 6px 0;
  font-size: 18px;
}

.button_css:hover{
  box-shadow: rgb(235 234 226) 2px 2px 10px 0px, rgb(122 122 119 / 30%) 2px 2px 10px 0px;
  background-color: #fff;
  color: #333;
  border: 1px solid #c5653e;
}

.main_block {
  color: #333;
  font-size: 20px;
  line-height: 1.5;
  font-family: "Helvetica Neue",Helvetica,Arial,"PingFang SC","Hiragino Sans GB","Heiti SC","Microsoft YaHei","WenQuanYi Micro Hei",sans-serif;
}

.divbg{
  width: 100%;
  height: 100%;
  background-size: 100%;
  background-image: url("../assets/bg.jpg");
}
.mcon{
  background-color: #ebeee9;
  padding: 50px;
  width: 45%;
  height: 90%;
}
</style>

