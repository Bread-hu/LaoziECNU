<template>
  <router-view></router-view>
</template>

<script>
import daodejing from "./components/daodejing";
import mainPage from "./components/mainPage";
import zuozhe from "./components/zuozhe";
import chengyu from "./components/chengyu";
import wenxian  from "./components/wenxian";

export default {
  name: "App",
  comments: {
    daodejing,
    mainPage,
    zuozhe,
    chengyu,
    wenxian
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
