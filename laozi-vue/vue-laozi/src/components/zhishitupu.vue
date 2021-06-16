<template>
  <router-view>

  </router-view>
</template>

<script>
import * as d3 from 'd3'
export default {
  name: 'zhishitupu',
  data(){
    return {
      button_list: [
        {name: "首页", path: "/"},
        {name: "成语", path: "/chengyu"},
        {name: "作者", path: "/zuozhe"},
        {name: "文献", path: "/wenxian"},
        {name: "时空间GIS", path: "/shikongjian"},
        {name: "知识图谱", path: "/zhishitupu"},
        {name: "老子", path: "/laozi"},
      ]
    }
  },
  methods:{
    d3init(){
      this.links = this.data.links
      this.nodes = this.data.nodes
      this.svgDom = d3.select("#svg")
      this.d3render()
      this.stateInit()
    },
    stateInit(){
      this.nodeState = 0
      this.textState = 0
      // console.log(this.names)
      this.states = Array(this.names.length).fill('on')
    },
    d3render(){
      var _this = this

    },
  }
}
</script>

<style scoped>

</style>
