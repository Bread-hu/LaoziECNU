<template>
  <router-view></router-view>
</template>

<script>
import daodejing from "./components/daodejing";
import mainPage from "./components/mainPage";
import zuozhe from "./components/zuozhe";

export default {
  name: "App",
  comments: {
    daodejing,
    mainPage,
    zuozhe
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
