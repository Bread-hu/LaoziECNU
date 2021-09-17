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
    return{}
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
            let localValue, perf, downloadSpeep, usability, point,year;
            if (params.data) {
              localValue = params.data.idiom;
              year = params.data.value[2];
              // perf = params.data.perf;
              // downloadSpeep = params.data.downloadSpeep;
              // usability = params.data.usability;
              // point = params.data.point;
            } else {
              // 为了防止没有定义数据的时候报错写的
              localValue = 0;
              perf = 0;
            }
            let htmlStr = `
          <div style='font-size:18px;'> ${params.name}</div>
          <p style='text-align:left;margin-top:-4px;'>
              古籍：${localValue}<br/>
              年代:${year}<br/>
          </p>
        `;
            return htmlStr;
          },
          backgroundColor: "#ff7f50", //提示标签背景颜色
          textStyle: { color: "#fff" }, //提示标签字体颜色
        },
        visualMap: {
          type: 'continuous', // 连续型
          min: 0,       		// 值域最小值，必须参数
          max: 2000,			// 值域最大值，必须参数
          right: 200,
          bottom: 60,
          show: true,
          calculable: true,	// 是否启用值域漫游
          inRange: {
            color: ['#50a3ba','#eac736','#d94e5d']
            // 指定数值从低到高时的颜色变化
          },
          textStyle: {
            color: '#fff'	// 值域控件的文本颜色
          }
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
              // show: true,
            },
            coordinateSystem: 'geo',
            // 这是需要配置地图上的某个地区的数据，根据后台的返回的数据进行拼接（下面是我定义的假数据）
            data: [
              {
                name : '抚州',
                idiom :"临川集",
                value: [
                  27.95,
                  116.35,
                  1053
                ]
              },
              {
                name:"金华",
                idiom: "丹溪手镜",
                value: [
                  120.0702682,
                  29.3063535,
                  1319
                ]
              },
              {
                name:"苏州",
                idiom: "乐府余论",
                value: [
                  120.5810725,
                  31.30166935,
                  1819
                ]
              },
              {
                name:"温州",
                idiom:"仁端录",
                value:[
                  120.69,
                  27.99,
                  1774
                ]
              },
              {
                name:"烟台",
                idiom: "丹阳真人直言",
                value: [
                  121.59,
                  37.38,
                  1153
                ]
              },
              {
                name:"济南市",
                idiom: "为政忠告",
                value: [
                  117.11,
                  36.38,
                  1153
                ]
              },
              {
                name:"北京市",
                idiom: "义道记",
                value: [
                  116.39,
                  39.90,
                  1888
                ]
              },
              {
                name:"台山",
                idiom: "九州春秋",
                value: [
                  113.99,
                  34.00,
                  289
                ]
              },
              {
                name:"温州",
                idiom: "习学记言",
                value: [
                  120.69,
                  27.99,
                  1186
                ]
              },
              {
                name:"保定",
                idiom: "西斋四存编",
                value: [
                  115.44,
                  38.44,
                  1669
                ]
              },
              {
                name: "天津市",
                idiom: "了凡四训",
                value: [
                  117.19,
                  39.08,
                  1569
                ]
              },
              {
               name:"成都市",
               idiom: "五代史簒误",
                value: [
                  103.67,
                  30.62,
                  1044
                ]
              },
              {
                name:"绍兴市",
                idiom: "五灯会元",
                value: [
                  120.57,
                  29.99,
                  1234
                ]
              },
              {
                name:"梅州",
                idiom: "京尘杂录",
                value: [
                  116.11,
                  24.29,
                  1774
                ]
              },
              {
                name :"凉山彝族自治州",
                idiom: "今古学考",
                value:[
                  101.4481497,
                  27.6307777,
                  1892
                ]
              },
              {
                name: "桂林市",
                idiom: "从政遗规",
                value: [
                  110.1752245,
                  25.2383172,
                  1733
                ]
              },
              {
                name:"安顺市",
                idiom: "仙苑编珠",
                value: [
                  105.9437773,
                  26.254911,
                  1958
                ]
              },
              {
                name: "石家庄",
                idiom: "伊滨集",
                value: [
                  114.54162835108643,
                  38.229038849999995,
                  1319
                ]
              },
              {
                name:"黄山市",
                idiom: "伤寒恒论",
                value:[
                  117.6719948,
                  29.6932182,
                  1867
                ]
              },
              {
                name: "扬州市",
                idiom: "伤寒百证歌",
                value: [
                  119.1619072405039,
                  32.4148475,
                  1044
                ]
              },
              {
                name:"南京市",
                idiom: "伤寒证治准绳",
                value: [
                  118.727349,
                  32.0061278,
                  1595
                ]
              },
              {
                name: "保定市",
                idiom: "佛临涅槃记法住经",
                value: [
                  114.7969001,
                  38.906653,
                  762
                ]
              },
              {
                name: "湖州市",
                idiom: "佛说生经",
                value: [
                  119.83764718011363,
                  30.95163805,
                  556
                ]
              },
              {
                name: "铜川市",
                idiom: "保生铭",
                value: [
                  108.82693227339988,
                  35.0627936,
                  611
                ]
              },
              {
                name:"定西市",
                idiom: "信及录",
                value: [
                  105.281378,
                  35.215119,
                  1817
                ]
              },
              {
                name: "来宾市",
                idiom: "八闽通志",
                value: [
                  114.525425,
                  24.7453487,
                  1471
                ]
              },
              {
                name:"朔州",
                idiom: "六亭文选",
                value: [
                  112.4235469,
                  39.3307915,
                  1774
                ]
              },
              {
                name: "咸宁市",
                idiom: "六臣注文选",
                value: [
                  114.2932605,
                  29.855163,
                  659
                ]
              },
              {
                name: "常熟市",
                idiom: "兰闺恨",
                value: [
                  120.7480757,
                  31.6572954,
                  1913
                ]
              },
              {
                name: "安宁市",
                idiom: "关中奏议",
                value: [
                  102.4026832,
                  24.8377491,
                  1492
                ]
              },
              {
                name:"毫州市",
                idiom: "曲论",
                value:[
                  115.772453,
                  33.8579594,
                  206
                ]
              },
              {
                name: "淮安市",
                idiom: "养一斋李杜诗话",
                value: [
                  119.1075773,
                  33.5524785,
                  1812
                ]
              },

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
