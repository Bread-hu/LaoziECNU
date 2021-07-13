<template>
  <router-view></router-view>
</template>

<script>
import daodejing from "./components/daodejing";
import mainPage from "./components/mainPage";
import zuozhe from "./components/zuozhe";
import chengyu from "./components/chengyu";
import wenxian  from "./components/wenxian";
// import zhishitupu from "./components/zhishitupu";
import zhishitupu from  "./components/2dView";
import book from "./components/book";
import chengyudt from '@/components/chengyu_detailed'
import bookdt from '@/components/book_detailed'
import zuozhedt from "./components/zuozhedt";
import shikongjian from "./components/shikongjian";

export default {
  name: "App",
  components: {
    daodejing,
    mainPage,
    zuozhe,
    chengyu,
    wenxian,
    zhishitupu,
    book,
    chengyudt,
    bookdt,
    zuozhedt,
    shikongjian
  },
  data() {
    return {
    };
  },
  methods: {
  },
};
</script>

<style>

.input-with-select .el-input-group__prepend {
  background-color: #fff;
}

.verticallines span {
  color: red;
  font-size: 2em;
  float: left;
  vertical-align: middle;
}
</style>
