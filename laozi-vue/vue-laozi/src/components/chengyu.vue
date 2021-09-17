<template>
    <el-container>
      <el-header>
<!--        <el-image-->
<!--          style="margin-left: 0px; margin-top: 40px"-->
<!--          :src="require('../assets/logo.png')"-->
<!--        ></el-image>-->
<!--        <el-menu-->
<!--          default-active="activeIndex"-->
<!--          class="el-menu-demo"-->
<!--          mode="horizontal"-->
<!--          style="margin-top: -60px; margin-left: 250px"-->
<!--        >-->
<!--          <el-menu-item-->
<!--            v-for="item in button_list"-->
<!--            :key="item.name"-->
<!--            index="item.name"-->
<!--            @click="goPage(item.path)"-->
<!--            style="font-size: 35px; width: 13%"-->
<!--          >-->
<!--            <template slot="title">-->
<!--              <span style="font-size: 20px">{{ item.name }}</span>-->
<!--            </template>-->

<!--          </el-menu-item>-->
<!--        </el-menu>-->
        <top-bar></top-bar>
      </el-header>
      <el-container style="margin-top: 0px;height: 100%">
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
<!--              <el-submenu-->
<!--                v-for="head in item.head_list"-->
<!--                :key="head"-->
<!--                :index="head"-->
<!--                @click="getChengyu(head)"-->
<!--              >-->
<!--                <template slot="title">{{head}}</template>-->
<!--&lt;!&ndash;                <el-menu-item&ndash;&gt;-->
<!--&lt;!&ndash;                  v-for="num in chengyu_list[head]"&ndash;&gt;-->
<!--&lt;!&ndash;                  :key="num.id"&ndash;&gt;-->
<!--&lt;!&ndash;                  :index="num.id">&ndash;&gt;-->
<!--&lt;!&ndash;                  {{"嘻嘻"}}&ndash;&gt;-->
<!--&lt;!&ndash;                </el-menu-item>&ndash;&gt;-->
<!--              </el-submenu>-->
            </el-submenu>
          </el-menu>
        </el-aside>
        <el-main class="main_block">
<!--          <el-popover-->
<!--            placement="top"-->
<!--            width="400"-->
<!--            v-model="visible">-->
<!--            <p>这是一段内容这是一段内容确定删除吗？</p>-->
<!--            <div style="text-align: right; margin: 0">-->
<!--              <el-button size="mini" type="text" @click="visible = false">取消</el-button>-->
<!--              <el-button type="primary" size="mini" @click="visible = false">确定</el-button>-->
<!--            </div>-->
<!--            <el-button style="display: block; " slot="reference" v-for="item in chengyu_list" :key="item.id" :index="item.id" @click="getContent(item.id)">{{item.idiom}}</el-button>-->
<!--          </el-popover>-->
<!--          <el-popover-->
<!--            placement="top"-->
<!--            width="160"-->
<!--            v-model="visible">-->
<!--            <p>这是一段内容确定删除吗？</p>-->
<!--            <div style="text-align: right; margin: 0">-->
<!--              <el-button size="mini" type="text" @click="visible = false">取消</el-button>-->
<!--              <el-button type="primary" size="mini" @click="visible = false">确定</el-button>-->
<!--            </div>-->
<!--            <el-button slot="reference">删除</el-button>-->
<!--          </el-popover>-->
<!--          <div v-for="item in chengyu_list" :key="item.id" :index="item.id" type="text">-->
<!--          <el-button type="text" style="display: block" @click="getContent(item.id)">{{item.idiom}}</el-button>-->
<!--            <el-divider></el-divider>-->
<!--          </div>-->

<!--          <el-dialog title="成语详解" :visible.sync="visible">-->
<!--            <h2>成语拼音</h2>-->
<!--            <span>{{ chengyu_content.idiomPhonetic }}</span>-->
<!--            <h2>成语出处</h2>-->
<!--            <span>{{ chengyu_content.allusion }}</span>-->
<!--            <h2>成语示例</h2>-->
<!--            <span>{{ chengyu_content.example }}</span>-->
<!--            <h2>成语解释</h2>-->
<!--            <span>{{ chengyu_content.explanation }}</span>-->
<!--            <h2>成语语法</h2>-->
<!--            <span>{{ chengyu_content.grammar }}</span>-->
<!--            <h2>成语结构</h2>-->
<!--            <span>{{ chengyu_content.structure }}</span>-->
<!--            <h2>近义词</h2>-->
<!--            <span>{{chengyu_content.similar}}</span>-->
<!--          </el-dialog>-->
        <div class="divbg">
        <div class="mcon" style="margin-top: 10px;text-align:center;margin:0 auto">
          <h1>成语列表</h1>
          <ul class="btn w4">
            <li v-for="item in chengyu_list" :key="item.id" :index="item.id">
              <a :href="getHref(item.id)">{{item.idiom}}</a>
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
    name: 'chengyu',
    data(){
      return{
        temp: "公羊传",
        chengyu_json:{},
        button_list: [
          { name: "首页", path: "/" },
          { name: "成语", path: "/chengyu" },
          { name: "作者", path: "/zuozhe" },
          { name: "文献", path: "/wenxian" },
          { name: "时空间GIS", path: "/shikongjian" },
          { name: "知识图谱", path: "/zhishitupu" },
          { name: "老子", path: "/laozi" },
        ],
        visible:false,
        pinyin_list:[
          {name: "A", head_list: ['a','ai','an','ang','ao']},
          {name: "B", head_list: ['ba','bai','ban','bang','bao','bei','ben','beng','bi','bian','biao','bie','bin','bing','bo','bu']},
          {name: "C", head_list: ['ca','cai','can','cang','cao','ce','cei','cen','ceng','cha','chai','chan','chang','chao','che','chen','cheng','chi','chong','chou','chu','chua','chuai','chuan','chuang','chui','chun','chuo','ci','cong','cou','cu','cuan','cui','cun','cuo']},
          {name: "D", head_list: ['da','dai','dan','dang','dao','de','dei','deng','di','dia','dian','diao','die','ding','diu','dong','dou','du','duan','dui','dun','duo']},
          {name: "E", head_list: ['e','ei','en','eng','er']},
          {name: "F", head_list: ['fa','fan','fang','fei','fen','feng','fiao','fo','fou','fu']},
          {name: "G", head_list: ['ga','gai','gan','gang','gao','ge','gei','gen','geng','gong','gou','gu','gua','guai','guan','guang','gui','gun','guo']},
          {name: 'H', head_list: ['ha','hai','han','hang','hao','he','hei','hen','heng','hm','hng','hong','hou','hu','hua','huai','huan','huang','hui','hun','huo']},
          {name: 'J', head_list: ['ji','jia','jian','jiang','jiao','jie','jin','jing','jiong','jiu','ju','juan','jue','jun']},
          {name: 'K', head_list: ['ka','kai','kan','kang','kao','ke','ken','keng','kong','kou','ku','kua','kuai','kuan','kuang','kui','kun','kuo']},
          {name: 'L', head_list: ['la','lai','lan','lang','lao','le','lei','leng','li','lia','lian','liang','liao','lie','lin','ling','liu','long','lou','lu','luan','lüe','lunluo']},
          {name: 'M', head_list: ['m','ma','mai','man','mang','mao','me','mei','men','meng','mi','mian','miao','mie','min','ming','miu','mo','mou','mu']},
          {name: 'N', head_list: ['n','na','nai','nan','nang','nao','ne','nei','nen','neng','ng','ni','nian','niang','niao','nie','nin','ning','niu','nong','nou','nu','nuan','nüe','nun','nuo']},
          {name: 'O', head_list: ['o', 'ou']},
          {name: 'P', head_list: ['pa','pai','pan','pang','pao','pei','pen','peng','pi','pian','piao','pie','pin','ping','po','pou','pu']},
          {name: 'Q', head_list: ['qi','qia','qian','qiang','qiao','qie','qin','qing','qiong','qiu','qu','quan','que','qun']},
          {name: 'R', head_list: ['ran','rang','rao','re','ren','reng','ri','rong','rou','ru','ruan','rui','run','ruo']},
          {name: 'S', head_list: ['sa','sai','san','sang','sao','se','sen','seng','sha','shai','shan','shang','shao','she','shei','shen','sheng','shi','shou','shu','shua','shuai','shuan','shuang','shui','shun','shuo','si','song','sou','suan','sui','sun','suo']},
          {name: 'T', head_list: ['ta','tai','tan','tang','tao','te','teng','ti','tian','tiao','tie','ting','tong','tou','tu','tuan','tui','tun','tuo']},
          {name: 'W', head_list: ['wa','wai','wan','wang','wei','wen','weng','wo','wu']},
          {name: 'X', head_list: ['xi','xia','xian','xiang','xiao','xie','xin','xing','xiong','xiu','xu','xuan','xue','xun']},
          {name: 'Y', head_list: ['ya','yai','yan','yang','yao','ye','yi','yin','ying','yo','yong','you','yu','yuan','yue','yun']},
          {name: 'Z', head_list: ['za','zai','zan','zang','zao','ze','zei','zen','zeng','zha','zhai','zhan','zhang','zhao','zhe','zhei','zhen','zheng','zhi','zhong','zhou','zhu','zhua','zhuai','zhuan','zhuang','zhui','zhun','zhuo','zi','zong','zou','zu','zuan','zui','zun','zuo']},
        ],
        chengyu_list:{},
        chengyu_content:{},

      }
    },
    created() {
      this.getChengyu('a')
    },
    methods: {
      getHref(id){
        return "/chengyudt?id=" + id
      },
      getChengyu(head){
        var that = this;
        console.log(111)
        var that = this;
        this.axios({
          url:'/getIdioms',
          method:'post',
          data:{
            firstPhonetic: head
          }
        }).then(
          function (response)
          {
            that.chengyu_list = response.data
            console.log(that.chengyu_list)
          },
          function (err)
          {
            consol.log(err)
          }
        )
      },
      getContent(id){
        console.log(id)

        var that = this;
        that.visible = true;
        this.axios({
          url:'/getIdiomById',
          method:'post',
          data:{
            id: id
          }
        }).then(
          function (response){
            console.log(response.data)
            that.chengyu_content = response.data;
          },
          function (err){
            console.log(err)
          }
        )
        // that.chengyu_content= {name:"好大喜功",fanyi:"喜欢功劳"}
      }
    }
  }
</script>

<style scoped>
p{
  width: 1500px;
  word-wrap: break-word;
  word-break: break-all;
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
  width: 50%;
  height: 90%;
}

.main_block {
  color: #333;
  font-size: 20px;
  line-height: 1.5;
  font-family: "Helvetica Neue",Helvetica,Arial,"PingFang SC","Hiragino Sans GB","Heiti SC","Microsoft YaHei","WenQuanYi Micro Hei",sans-serif;
}
ul {
  list-style-type: disc;
}

ul.btn li{
  float: left;
  position: relative;
  white-space: nowrap;

}

a {
  color: #333;
  text-decoration: none;
  cursor: pointer;
  outline: none;
  blur: expression(this.onFocus=this.blur());
}

.mtitle a, .mcon a, .otitle a {
  text-decoration: underline;
}



li{
  text-align: -webkit-match-parent;
}

ul, ol, menu{
  list-style: none;
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
</style>
