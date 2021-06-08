<template>
  <router-view></router-view>
</template>

<script>
import laozi from "./components/laozi";
import mainPage from "./components/mainPage";
import zuozhe from "./components/zuozhe";
import axios from "axios";

export default {
  name: "App",
  comments: {
    laozi,
    mainPage,
    zuozhe
  },
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
      chapter_dao_list: [
        { index: "1-1", name: "第一章", chapter: "1" },
        { index: "1-2", name: "第二章", chapter: "2" },
        { index: "1-3", name: "第三章", chapter: "3" },
        { index: "1-4", name: "第四章", chapter: "4" },
        { index: "1-5", name: "第五章", chapter: "5" },
        { index: "1-6", name: "第六章", chapter: "6" },
        { index: "1-7", name: "第七章", chapter: "7" },
        { index: "1-8", name: "第八章", chapter: "8" },
        { index: "1-9", name: "第九章", chapter: "9" },
        { index: "1-10", name: "第十章", chapter: "10" },
        { index: "1-11", name: "第十一章", chapter: "11" },
        { index: "1-12", name: "第十二章", chapter: "12" },
        { index: "1-13", name: "第十三章", chapter: "13" },
        { index: "1-14", name: "第十四章", chapter: "14" },
        { index: "1-15", name: "第十五章", chapter: "15" },
        { index: "1-16", name: "第十六章", chapter: "16" },
        { index: "1-17", name: "第十七章", chapter: "17" },
        { index: "1-18", name: "第十八章", chapter: "18" },
        { index: "1-19", name: "第十九章", chapter: "19" },
        { index: "1-20", name: "第二十章", chapter: "20" },
        { index: "1-21", name: "第二十一章", chapter: "21" },
        { index: "1-22", name: "第二十二章", chapter: "22" },
        { index: "1-23", name: "第二十三章", chapter: "23" },
        { index: "1-24", name: "第二十四章", chapter: "24" },
        { index: "1-25", name: "第二十五章", chapter: "25" },
        { index: "1-26", name: "第二十六章", chapter: "26" },
        { index: "1-27", name: "第二十七章", chapter: "27" },
        { index: "1-28", name: "第二十八章", chapter: "28" },
        { index: "1-29", name: "第二十九章", chapter: "29" },
        { index: "1-30", name: "第三十章", chapter: "30" },
        { index: "1-31", name: "第三十一章", chapter: "31" },
        { index: "1-32", name: "第三十二章", chapter: "32" },
        { index: "1-33", name: "第三十三章", chapter: "33" },
        { index: "1-34", name: "第三十四章", chapter: "34" },
        { index: "1-35", name: "第三十五章", chapter: "35" },
        { index: "1-36", name: "第三十六章", chapter: "36" },
        { index: "1-37", name: "第三十七章", chapter: "36" },
      ],
      chapter_de_list: [
        { index: "1-38", name: "第三十八章", chapter: "38" },
        { index: "1-39", name: "第三十九章", chapter: "39" },
        { index: "1-40", name: "第四十章", chapter: "40" },
        { index: "1-41", name: "第四十一章", chapter: "41" },
        { index: "1-42", name: "第四十二章", chapter: "42" },
        { index: "1-43", name: "第四十三章", chapter: "43" },
        { index: "1-44", name: "第四十四章", chapter: "44" },
        { index: "1-45", name: "第四十五章", chapter: "45" },
        { index: "1-46", name: "第四十六章", chapter: "46" },
        { index: "1-47", name: "第四十七章", chapter: "47" },
        { index: "1-48", name: "第四十八章", chapter: "48" },
        { index: "1-49", name: "第四十九章", chapter: "49" },
        { index: "1-50", name: "第五十章", chapter: "50" },
        { index: "1-51", name: "第五十一章", chapter: "51" },
        { index: "1-52", name: "第五十二章", chapter: "52" },
        { index: "1-53", name: "第五十三章", chapter: "53" },
        { index: "1-54", name: "第五十四章", chapter: "54" },
        { index: "1-55", name: "第五十五章", chapter: "55" },
        { index: "1-56", name: "第五十六章", chapter: "56" },
        { index: "1-57", name: "第五十七章", chapter: "57" },
        { index: "1-58", name: "第五十八章", chapter: "58" },
        { index: "1-59", name: "第五十九章", chapter: "59" },
        { index: "1-60", name: "第六十章", chapter: "60" },
        { index: "1-61", name: "第六十一章", chapter: "61" },
        { index: "1-62", name: "第六十二章", chapter: "62" },
        { index: "1-63", name: "第六十三章", chapter: "63" },
        { index: "1-64", name: "第六十四章", chapter: "64" },
        { index: "1-65", name: "第六十五章", chapter: "65" },
        { index: "1-66", name: "第六十四章", chapter: "66" },
        { index: "1-67", name: "第六十七章", chapter: "67" },
        { index: "1-68", name: "第六十八章", chapter: "68" },
        { index: "1-69", name: "第六十九章", chapter: "69" },
        { index: "1-70", name: "第七十章", chapter: "70" },
        { index: "1-71", name: "第七十一章", chapter: "71" },
        { index: "1-72", name: "第七十二章", chapter: "72" },
        { index: "1-73", name: "第七十三章", chapter: "73" },
        { index: "1-74", name: "第七十四章", chapter: "74" },
        { index: "1-75", name: "第七十五章", chapter: "75" },
        { index: "1-76", name: "第七十六章", chapter: "76" },
        { index: "1-77", name: "第七十七章", chapter: "77" },
        { index: "1-78", name: "第七十八章", chapter: "78" },
        { index: "1-79", name: "第七十九章", chapter: "79" },
        { index: "1-80", name: "第八十章", chapter: "80" },
        { index: "1-81", name: "第八十一章", chapter: "81" },
      ],
      input1: "",
      select: "",
      title: "第一章",
      translate: "",
      annotation: "",
      original: "道可道非常道，名可名非常名，一生二，二生三，三生万物",
    };
  },
  methods: {
    searchChapter(item) {
      //console.log(this)
      var that = this;
      this.axios({
        url: "http://127.0.0.1:8080/laozi/daodejing",
        method: "post",
        params: {
          chapter: item.chapter,
        },
      }).then(
        function (response) {
          that.title = item.name;
          console.log(response.data);
          that.original = response.data.original;
          that.annotation = response.data.annotation;
          that.translate = response.data.translation;
        },
        function (err) {
          console.log(err);
        }
      );
    },
  },
};
</script>

<style>
.box-card_1{
  width: 30%;
  margin-left: 900px;
  margin-top: -720px;
}
.box-card_2{
  width: 30%;
  margin-left: 900px;
  margin-top: 100px;
}
.el-divider--vertical {
  display: inline-block;
  width: 1px;
  height: 100%;
  margin-left: -20px;
}
.logo_top {
  margin-left: 500px;
}
.button_1 {
  margin-left: 0%;
  background-color: transparent;
  float: left;
  border: none;
  width: 16.6%;
  font-size: 50px;
}
.button_1:hover {
  background-color: beige;
}
.row_1 {
  margin-left: 0%;
}
#app {
  background-color: wheat;
  width: 100%;
  height: 100%;
  position: fixed;
  background-size: 100% 100%;
}
.input-with-select .el-input-group__prepend {
  background-color: #fff;
}

.verticallines {
  background-color: #eead0e;
  font-family: "Source Han Serif SC";
  height: 600px;
  margin: 1em;
  padding: 2em;
  font-size: 2em;
  margin-left: 100px;
  writing-mode: tb-rl;
  -webkit-writing-mode: vertical-rl;
}

.verticallines span {
  color: red;
  font-size: 2em;
  float: left;
  vertical-align: middle;
}
</style>
