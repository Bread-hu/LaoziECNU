<template>
  <el-container>
    <el-header>
      <top-bar></top-bar>
    </el-header>

    <el-container style="margin-top: 0px;height: 100%">
      <el-aside width="250px" style="margin-top: 0px; height: 90vh">
        <el-menu
          class="el-menu-vertical-demo"
          default-active="1"
          style="border-right: 0"
        >
          <el-menu-item v-for="item in dynasty_list" :key="item.name" :index="item.name" @click="getAuthor(item.name,1)">

            <i class="el-icon-collection"></i>
            <span style="font-size: 20px">{{ item.name }}</span>
          </el-menu-item>
<!--          <el-submenu v-for="item in dynasty_list" :key="item.index" :index="item.index">-->
<!--            <template slot="title">-->
<!--              <i class="el-icon-collection"></i>-->
<!--              <span style="font-size: 20px">{{ item.name }}</span>-->
<!--            </template>-->
<!--            <el-menu-item-group>-->
<!--              <el-menu-item-->
<!--                v-for="num in item.maxPage"-->
<!--                :key="num"-->
<!--                index="item.name+num"-->
<!--                @click="getAuthor(item.name,num)">-->
<!--                {{"第"+num+"页"}}-->
<!--              </el-menu-item>-->
<!--            </el-menu-item-group>-->
<!--          </el-submenu>-->
        </el-menu>
      </el-aside>
      <el-main>
        <!--        <el-container style="background-color: burlywood;height: 300px">-->
        <!--          <el-image :src="require('../assets/laozi_1.jpg')" style="height: 300px; width: auto ">-->

        <!--          </el-image>-->
        <!--        </el-container>-->
        <div class="divbg">
          <div class="mcon" style="margin-top: 10px;text-align:center;margin:0 auto">
        <div v-for="item in author_list" :key="item.author_name" style="background-color: #F0EFE2;height: auto;text-align: left;margin-top: 20px;width: auto;">
          <img :src="item.author_pic" style="height: 15vh;width: auto; display: inline-block;" />
          <div style="display: inline-block; vertical-align: top">
<!--            <a href="laozi">{{ item.author_name }}</a>-->
            <el-button type="text" style="font-size: 20px" @click="getAuthorContent(item.author_name)">{{item.author_name}}</el-button>
            <p>{{ item.author_intro }}</p>
          </div>
        </div>
            <button v-for="num in page_list" :key="num" :index="num" @click="getAuthor(num,num)" class="button_css" style="text-align:center;margin:0 auto">{{num}}</button>
            <button v-show="ishow" class="button_css" style="text-align:center;margin:0 auto">...</button>
          </div>

        </div>

<!--        <el-dialog title="作者详细信息" :visible.sync="visible">-->
<!--          <div v-for="(item, key) in author_content.data" :key="key" :index="key">-->
<!--            <h2>{{key}}</h2>-->
<!--            <span>{{item}}</span>-->
<!--          </div>-->
<!--        </el-dialog>-->
        <!--                <div style="background-color: burlywood;height: 300px;display: block;margin-top: 20px">-->
        <!--                    <img src="../assets/laozi_1.jpg" style="height: 300px;width: auto; display: inline-block" />-->
        <!--                    <div style="display: inline-block; vertical-align: top">-->
        <!--                    <a href="laozi">老子</a>-->
        <!--                    <p >的身份卡速度就法律卡萨丁积分两款手机的法律卡上东方拉斯加对方卢卡斯的借口放了双方</p>-->
        <!--                    </div>-->
        <!--                </div>-->
      </el-main>
    </el-container>
  </el-container>
</template>

<script>
import axios from "axios";

export default {
  name: "zuozhe",
  data() {
    return {
      now_page: 1,
      now_dynasty: "不限",
      max_page:0,
      current_page:0,
      ishow:1,
      page_list: [],
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
        { name: "先秦", maxPage:2, index:"2"},
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
      author_list: [

      ],
      author_content:{},
      visible: false
    };
  },
  created() {
    var that = this;
    console.log(that)
    // this.axios({
    //   url: "http://127.0.0.1:8080/page",
    //   method: "post",
    //   params:{
    //     dynasty: "两汉",
    //     pageNumber: 0,
    //   },
    // }).then(
    //   function (response){
    //     console.log(response)
    //   },
    //   function (err) {
    //     console.log(err);
    //   }
    // )
    this.axios({
      url: "/dynastycount",
      method: "post",
      params:{
      },
    }).then(
      function (response){
        var count = 0
        var dynasty = response.data.data
        // console.log(dynasty)
        // console.log(dynasty.data)
        for(var i=0;i<dynasty.length;i++)
        {
          console.log(dynasty[i].dynasty)
          count += dynasty[i].count;
          for(var j=0;j<that.dynasty_list.length;j++)
          {
            if(that.dynasty_list[j].name == dynasty[i].dynasty)
            {
              that.dynasty_list[j].maxPage = dynasty[i].count
            }
          }
        }
        that.dynasty_list[0].maxPage = count
        console.log(that.dynasty_list)
        that.getAuthor("不限",1)
      },
      function (err) {
        console.log(err);
      }
    )

  },
  methods: {
    getList(current_num,maxpage){
      var that = this
      that.page_list = []
      if(current_num + 5 < maxpage){
        for(var i = current_num; i<=current_num+5; i++)
        {
          that.page_list.push(i)
        }
      }else{
        for(var i = maxpage-5; i<maxpage; i++)
        {
          that.page_list.push(i)
        }
        that.ishow=0
      }
    },
    getAuthor(dynasty,num){
      var that = this;
      that.current_page = num
      console.log(num)
      this.axios({
        url: "/page",
        method: "post",
        params:{
          dynasty: that.now_dynasty,
          pageNumber: num,
        },
      }).then(
        function (response){
          that.author_list = response.data.authors
          for(var i=0;i<that.author_list.length;i++){
            that.author_list[i].author_pic = "http://localhost:8080" + that.author_list[i].author_pic
          }
          console.log(that.author_list)
        },
        function (err) {
          console.log(err);
        }
      )
      for(var i=0;i<that.dynasty_list.length;i++){
        if(that.dynasty_list[i].name == dynasty){
          that.max_page = that.dynasty_list[i].maxPage
          that.now_dynasty = dynasty
        }
      }
      that.getList(that.current_page,that.max_page)
    },
    getAuthorContent(author_name){
      // console.log(author_name)
      // var that = this;
      // that.visible = true;
      // this.axios({
      //   url:'/authorDetail',
      //   method:'post',
      //   params:{
      //     author_name:author_name
      //   }
      // }).then(
      //   function (response){
      //     console.log(response)
      //     console.log(response.data)
      //     that.author_content = response.data
      //   },
      //   function (err){
      //     console.log(err)
      //   }
      // )
      this.$router.push({
        path: '/zuozhedt',
        query: {
          author_name: author_name,
        }
      });
    }
  },
};
</script>

<style scoped>

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

.divbg{
  width: 100%;
  height: auto;
  background-size: 100%;
  background-image: url("../assets/bg.jpg");
}
.mcon{
  background-color: #ebeee9;
  padding: 50px;
  width: 45%;
  height: auto;
}

p{
  width: 30vw;
  word-wrap: break-word;
  word-break: break-all;
}
</style>
