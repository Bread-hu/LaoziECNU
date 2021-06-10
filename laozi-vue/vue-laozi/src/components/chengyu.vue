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
            <el-submenu v-for="item in pinyin_list" :key="item.name" :index="item.name">
              <template slot="title">
                <i class="el-icon-collection"></i>
                <span style="font-size: 20px">{{ item.name }}</span>
              </template>
<!--              <el-menu-item-group>-->
<!--                <el-menu-item-->
<!--                  v-for="head in item.head_list"-->
<!--                  :key="head"-->
<!--                  index="head"-->
<!--                  @click="getChengyu(head)">-->
<!--                  {{head}}-->
<!--                </el-menu-item>-->
<!--              </el-menu-item-group>-->
              <el-submenu
                v-for="head in item.head_list"
                :key="head"
                :index="head"
              >
                <template slot="title">{{head}}</template>
                <el-menu-item
                  v-for="num in 3"
                  :key="num"
                  :index="num">
                  {{num}}
                </el-menu-item>
              </el-submenu>
            </el-submenu>
          </el-menu>
        </el-aside>
      </el-container>
    </el-container>
</template>

<script>
  export default {
    name: 'chengyu',
    data(){
      return{
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
        pinyin_list:[
          {name: "A", head_list: ['a','ai','an','ang','ao']},
          {name: "B", head_list: ['ba','bai','ban','bang','bao','bei','ben','beng','bi','bian','biao','bie','bin','bing','bo','bu']},
          {name: "C", head_list: ['ca','cai','can','cang','cao','ce','cei','cen','ceng','cha','chai','chan','chang','chao','che','chen','cheng','chi',',chong','chou','chu','chua','chuai','chuan','chuang','chui','chun','chuo','ci','cong','cou','cu','cuan','cui','cun','cuo']},
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
        chengyu_list:{}
      }
    },
    created() {
      var that = this;
      // console.log(that)
      // console.log(that.pinyin_list.length)
      for(var i=0; i<that.pinyin_list.length;i++)
      {
        //console.log(that.pinyin_list[i].head_list)
        for(var j=0;j<that.pinyin_list[i].head_list.length;j++)
        {
          //console.log(temp)
          this.axios({
            url:'/getIdioms',
            method: "post",
            data:{
              firstPhonetic: that.pinyin_list[i].head_list[j]
            }
          }).then(
            function (response)
            {
              // console.log(response.data)
              // console.log(response)
              // console.log(that.pinyin_list[i].head_list[j])
              //console.log(response.data)
              // console.log(i)
              // console.log(that.pinyin_list)
              console.log(response.data)
              // console.log(that.chengyu_list)
            },
            function (err)
            {
              console.log(err)
            }
          )
        }
      }
    },
    methods: {
      getChengyu(head){
        var that = this;
        this.axios({

        })
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
</style>
