
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

    <el-container style="margin-top: 0px;height: 100%">
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
        <!--        <el-container style="background-color: burlywood;height: 300px">-->
        <!--          <el-image :src="require('../assets/laozi_1.jpg')" style="height: 300px; width: auto ">-->

        <!--          </el-image>-->
        <!--        </el-container>-->
        <div v-for="item in author_list" style="background-color: burlywood;height: 300px;margin-top: 20px">
          <img src="../assets/laozi_1.jpg" style="height: 300px;width: auto; display: inline-block" />
          <div style="display: inline-block; vertical-align: top">
            <a href="laozi">{{ item.author_name }}</a>
            <p>{{ item.author_intro }}</p>
          </div>
        </div>
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
      author_list: [

      ]
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
      url: "http://127.0.0.1:8080/dynastycount",
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
            if(that.dynasty_list[j].name== dynasty[i].dynasty)
            {
              that.dynasty_list[j].maxPage = dynasty[i].count
            }
          }
        }
        that.dynasty_list[0].maxPage = count
        console.log(that.dynasty_list)
      },
      function (err) {
        console.log(err);
      }
    )

  },
  methods: {
    getAuthor(dynasty,num){
      var that = this;
      this.axios({
        url: "http://127.0.0.1:8080/page",
        method: "post",
        params:{
          dynasty: dynasty,
          pageNumber: num,
        },
      }).then(
        function (response){
          that.author_list = response.data.authors
          console.log(that.author_list)
        },
        function (err) {
          console.log(err);
        }
      )
    }
  },
};
</script>

<style scoped>
p{
  width: 1500px;
  word-wrap: break-word;
  word-break: break-all;
}
</style>
