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
              <h1>{{ subsubook_name }}</h1>
            </div>
            <p class="ind2" style="text-align: left;font-size: 20px;display: block">
              {{subook_content}}
            </p>
          </div>
        </div>
      </el-main>
    </el-container>
  </el-container>
</template>

<script>
export default {
  name: "book_detailed",
  data(){
    return {
      subook_content : [],
      subook_id:undefined,
      subook_name:undefined,
      subsubook_name:undefined
    }
  },
  created() {
    this.subook_id = this.$route.query.subook_id
    this.subook_name = this.$route.query.subook_name
    this.subsubook_name = this.$route.query.subsubook_name
    var that = this
    // console.log(item)
    console.log(this.subsubook_name)
    this.axios({
      url:'/getBookContent',
      method:'post',
      data:{
        subook_id:that.subook_id,
        subook_name:that.subook_name,
        subsubook_name:that.subsubook_name,
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
  methods:{

  }
}
</script>

<style scoped>
.main_block {
  height: 1500px;
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
