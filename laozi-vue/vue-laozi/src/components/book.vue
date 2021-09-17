<template>
  <el-container>
    <el-header>
      <top-bar></top-bar>
    </el-header>
    <el-container>
      <el-main class="main_block">
        <div class="divbg">
          <div class="mcon" style="margin-top: 10px;text-align:center;margin:0 auto">
            <div class="kaiti center">
              <h1>{{book_content.book_name}}</h1>
            </div>
            <hr>
            <p class="ind2" style="text-align: left;font-size: 20px;display: block">
              <span class="tip">朝代</span>
              <span>{{book_content.dynasty}}</span>
            </p>
            <div class="ind2" style="text-align: left;font-size: 20px;display: block">
              <span class="tip">简介</span>
              <span v-html="book_content.introduction"></span>
            </div>
<!--            <p class="ind2" style="text-align: left;font-size: 20px;display: block">-->
<!--              <span class="tip">章节</span>-->
<!--              -->
<!--            </p>-->
            <hr>
            <div class="kaiti center">
              <h1>章节</h1>
            </div>
            <ul class="btn w4">
              <li v-for="item in chapter_list" :key="item.subook_id" :index="item.subook_id">
                <a :href="getHref(item)">{{item.subsubook_name}}</a>
              </li>
            </ul>
          </div>
        </div>
      </el-main>
    </el-container>
  </el-container>
</template>

<script>
export default {
  name: "book",
  data(){
    return{
      chengyu_content: undefined,
      book_content: {book_name:"这是书名",dynasty:"这是朝代",introduction:"这是介绍"},
      chapter_list:[],
    }
  },
  created() {
    console.log(this.$route.query.bookname)
    var book_name = this.$route.query.bookname;
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
  methods:{
    getHref(item) {
      // this.$router.push({
      //   path:'/bookdt',
      //   query:{
      //     subook_id: item.subook_id,
      //     subook_name: item.subook_name,
      //     subsubook_name: item.subsubook_name
      //   }
      // })
      return "/bookdt?subook_id=" + item.subook_id + "&subook_name=" + item.subook_name + "&subsubook_name=" + item.subsubook_name
    }
  }
}
</script>

<style scoped>
.main_block {
  height: 1000px;
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

.kaiti {
  font-family: Georgia,Baskerville,"Liberation Serif","Kaiti SC",STKaiti,"AR PL UKai CN","AR PL UKai HK","AR PL UKai TW","AR PL UKai TW MBE","AR PL KaitiM GB",KaiTi,KaiTi_GB2312,DFKai-SB,"TW\-Kai",serif;
}

.center{
  text-align: center;
}

h1{
  font-size: 42px;
  font-weight: normal;
}

ul {
  list-style-type: disc;
}

ul.btn li{
  float: left;
  position: relative;
  white-space: nowrap;

}

ul.btn li a {
  over-flow: hidden;
  font-size: 18px;
  text-decoration: none;
  width: auto;
  height: auto;
  padding: 15px 20px;
  border: 1px solid #e5e7e4;
  background-color: #e5e7e4;
  display: block;
  text-align: center;
}

ul.btn li a{
  -moz-border-radius: 6px;
  -webkit-border-radius: 6px;
  border-radius: 6px;
  font-size: 20px;
}

ul.w4 li a{
  margin: 12px 6px 0;
  overflow: hidden;
  white-space: nowrap;
}
::selection {
  background-color: #a4a288;
  color: #fff;
}
ul.btn li a:hover {
  box-shadow: rgb(235 234 226) 2px 2px 10px 0px, rgb(122 122 119 / 30%) 2px 2px 10px 0px;
}

ul.btn li a:hover, ul.btn li.cur a {
  background-color: #fff;
  color: #333;
  border: 1px solid #c5653e;
}
.mtitle a:hover, .mcon a:hover, .otitle a:hover {
}

.mtitle a, .mcon a, .otitle a {
  text-decoration: underline;
}

a {
  color: #333;
  text-decoration: none;
  cursor: pointer;
  outline: none;
  blur: expression(this.onFocus=this.blur());
}
li{ list-style: none;}

p.ind2 {
  text-indent: -3em;
  margin-left: 3em;
}

p {
  line-height: 28px;
  font-size: 16px;
  margin: 12px 0 0;
  text-indent: 2em;
  word-wrap: break-word;
  zoom: 1;
}

.tip, a.tip {
  margin-right: 0.75em;
  color: #77744d;
  text-decoration: none;
  border: 0 !important;
}

</style>
