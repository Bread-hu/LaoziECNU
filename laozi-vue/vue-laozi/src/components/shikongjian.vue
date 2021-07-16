<template>
  <el-container>
    <el-header>
      <top-bar></top-bar>
    </el-header>
    <el-container>
      <div id="china_map" :style="{width:width, height: '70vh' }"></div>
<!--        <div id="china_map" style="width: 70vw;height:50vh"></div>-->
    </el-container>
  </el-container>
</template>

<script>

import echarts from 'echarts'
import china from "echarts/map/json/china.json";  //中国地图
echarts.registerMap("china", china);
export default {
  name: "index",
  props: {
    className: {
      type: String,
      default: "chart",
    },
    width: {
      type: String,
      default: "100%",
    },
  },
  data(){
  },
  mounted() {
    this.setMapData();
  },
  methods: {
    // 地图
    setMapData() {
      // 初始化echarts实例 #D8E9FD
      this.chinachart = echarts.init(document.getElementById("china_map"));
      // 进行相关配置
      this.chartOption = {
        tooltip: {
          // 鼠标移到图里面的浮动提示框
          // formatter详细配置： https://echarts.baidu.com/option.html#tooltip.formatter
          formatter(params, ticket, callback) {
            // params.data 就是series配置项中的data数据遍历
            let localValue, perf, downloadSpeep, usability, point;
            if (params.data) {
              localValue = params.data.value;
              perf = params.data.perf;
              downloadSpeep = params.data.downloadSpeep;
              usability = params.data.usability;
              point = params.data.point;
            } else {
              // 为了防止没有定义数据的时候报错写的
              localValue = 0;
              perf = 0;
            }
            let htmlStr = `
          <div style='font-size:18px;'> ${params.name}</div>
          <p style='text-align:left;margin-top:-4px;'>
              成语：${localValue}<br/>
              占比：${perf}<br/>
          </p>
        `;
            return htmlStr;
          },
          backgroundColor: "#ff7f50", //提示标签背景颜色
          textStyle: { color: "#fff" }, //提示标签字体颜色
        },
        // visualMap: {
        //   show: true,
        //   bottom: 60,
        //   right: 200,
        //   text: ["高", "低"],
        //   //  min:0,
        //   //   precision:0,
        //   itemHeight: 200,
        //   color: [
        //     "#5475f5",
        //     "#9feaa5",
        //     "#85daef",
        //     "#74e2ca",
        //     "#e6ac53",
        //     "#9fb5ea",
        //   ],
        // },
        // geo配置详解： https://echarts.baidu.com/option.html#geo
        geo: {
          // 地理坐标系组件用于地图的绘制
          map: "china", // 表示中国地图
          // roam: true, // 是否开启鼠标缩放和平移漫游
          zoom: 1.2, // 当前视角的缩放比例（地图的放大比例）
          label: {
            // show: true
          },
          itemStyle: {
            // 地图区域的多边形 图形样式。
            normal: {
              //未选中的状态
              borderColor: "#ffffff",
              areaColor: "#D8E9FD", //背景颜色
              label: {
                // show: true, //显示名称
              },
            },
            emphasis: {
              //选中的状态
              // 高亮状态下的多边形和标签样式
              shadowBlur: 20,
              shadowColor: "rgba(0, 0, 0, 0.5)",
              borderColor: "#fff",
              areaColor: "#DA3A3A",
            },
          },
        },
        series: [
          {
            name: "地图", // 浮动框的标题（上面的formatter自定义了提示框数据，所以这里可不写）
            type: "scatter",
            geoIndex: 0,
            label: {
              show: true,
            },
            coordinateSystem: 'geo',
            // 这是需要配置地图上的某个地区的数据，根据后台的返回的数据进行拼接（下面是我定义的假数据）
            data: [
              {
                name : '北京',
                value: [
                  116.46,
                  39.92,
                  340
                ]
              }
              // {
              //   name: "北京",
              //   value: 599, //  项目数量
              //   perf: "60%", // 项目占比
              // },
              // {
              //   name: "上海",
              //   value: 142,
              //   perf: "40%",
              // },
              // {
              //   name: "黑龙江",
              //   value: 44,
              //   perf: "1%",
              // },
              // {
              //   name: "新疆",
              //   value: 999,
              //   perf: "70%",
              // },
              // {
              //   name:"徐州市",
              //   value: 200,
              //   perf:"80%",
              // }
            ],
          },
        ],
      };
      // 使用刚指定的配置项和数据显示地图数据
      this.chinachart.setOption(this.chartOption);
    },
  }
}

</script>

<style scoped>

</style>
