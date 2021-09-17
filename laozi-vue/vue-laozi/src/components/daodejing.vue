<template>
  <el-container>
    <el-header>
      <top-bar></top-bar>
    </el-header>
    <el-container>
      <el-aside>
        <el-menu
          class="el-menu-vertical-demo"
          default-active="1"
          unique-opened
        >
          <el-submenu index="1">
            <template slot="title">
              <i class="el-icon-collection"></i>
              <span style="font-size: 20px">道经</span>
            </template>
            <el-menu-item-group>
              <el-menu-item
                v-for="item in chapter_dao_list"
                :key="item.index"
                index="item.index"
                @click="searchChapter(item)"
              >{{ item.name }}
              </el-menu-item
              >
            </el-menu-item-group>
          </el-submenu>
          <el-submenu index="2">
            <template slot="title">
              <i class="el-icon-collection"></i>
              <span style="font-size: 20px">德经</span>
            </template>
            <el-menu-item-group>
              <el-menu-item
                v-for="item in chapter_de_list"
                :key="item.index"
                index="item.index"
                @click="searchChapter(item)"
              >{{ item.name }}
              </el-menu-item>
            </el-menu-item-group>
          </el-submenu>
          <el-submenu index="3">
            <template slot="title">
              <i class="el-icon-collection"></i>
              <span style="font-size: 20px">成语</span>
            </template>
            <el-menu-item-group>
              <el-menu-item
                v-for="item in idiom_list"
                :key="item.index"
                index="item.index"
                @click="selectIdiom(item.name)"
              >{{ item.name }}
              </el-menu-item>
            </el-menu-item-group>
          </el-submenu>
        </el-menu>
      </el-aside>
      <el-main>
        <h1 style="font:20px Extra large">{{ title }}</h1>
        <template v-if="ok">
          <el-card>
            <div slot="header" class="clearfix">
              <span style="font-size: 20px">原文</span>
            </div>
            <div>
              <p v-html="original"> {{ original }}</p>
            </div>
          </el-card>
          <el-card>
            <div slot="header" class="clearfix">
              <span style="font-size: 20px">注释</span>
            </div>
            <div>
              <p>{{ annotation }}</p>
            </div>
          </el-card>
          <el-card>
            <div slot="header" class="clearfix">
              <span style="font-size: 20px">译文</span>
              <el-select v-model="language" placeholder="切换语言" @change="selectLanguage">
                <el-option
                  v-for="item in options"
                  :key="item.value"
                  :label="item.label"
                  :value="item.value">
                </el-option>
              </el-select>
            </div>
            <div>
             <p>{{ translate }}</p>
            </div>
          </el-card>
        </template>
        <template v-else>
          <el-card>
            <div slot="header" class="clearfix">
              <span style="font-size: 20px">解释</span>
            </div>
            <div>
              {{ idiom_explanation }}
            </div>
          </el-card>
          <el-card>
            <div slot="header" class="clearfix">
              <span style="font-size: 20px">出自</span>
              <el-button type="text" v-on:click="toOriginal">查看原文</el-button>
            </div>
            <div>
              <el-button type="text" v-on:click="toIdiom">{{ idiom_from }}</el-button>
<!--              <el-button type="text" v-on:click="toIdiom">和光同尘</el-button>-->
            </div>
          </el-card>
        </template>
      </el-main>

    </el-container>
    <el-footer>
      <foot-bar></foot-bar>
    </el-footer>
  </el-container>

</template>

<script>
export default {
  name: "daodejing",
  data() {
    return {
      ok: true,
      title: "",
      language: "",
      translate: "",
      annotation: "",
      original: "",
      idiom_from: "",
      idiom_explanation: "",
      options: [{value: 'translation', label: '中文'},
        {value: 'Bulgarian', label: '保加利亚语'},
        {value: 'Czech', label: '捷克语'},
        {value: 'Danish', label: '丹麦语'},
        {value: 'Dutch', label: '荷兰语'},
        {value: 'English', label: '英语'},
        {value: 'Estonian', label: '爱沙尼亚语'},
        {value: 'Finnish', label: '芬兰语'},
        {value: 'French', label: '法语'},
        {value: 'German', label: '德语'},
        {value: 'Hebrew', label: '希伯来语'},
        {value: 'Hungarian', label: '匈牙利语'},
        {value: 'Icelandic', label: '冰岛语'},
        {value: 'Indonesian', label: '印度尼西亚语'},
        {value: 'Interlingua', label: '国际语'},
        {value: 'Italian', label: '意大利语'},
        {value: 'Japanese', label: '日语'},
        {value: 'Klingon', label: '克林贡语'},
        {value: 'Korean', label: '韩语'},
        {value: 'Kurdish', label: '库尔德语'},
        {value: 'Latvian', label: '拉脱维亚语'},
        {value: 'Persian', label: '波斯语'},
        {value: 'Phoenician', label: '腓尼基语'},
        {value: 'Polish', label: '波兰语'},
        {value: 'Romanian', label: '罗马尼亚语'},
        {value: 'Russian', label: '俄语'},
        {value: 'Spanish', label: '西班牙语'},
        {value: 'Swedis', label: '瑞典人'}],
      chapter_dao_list: [
        {index: "1-1", name: "第一章", chapter: "1"},
        {index: "1-2", name: "第二章", chapter: "2"},
        {index: "1-3", name: "第三章", chapter: "3"},
        {index: "1-4", name: "第四章", chapter: "4"},
        {index: "1-5", name: "第五章", chapter: "5"},
        {index: "1-6", name: "第六章", chapter: "6"},
        {index: "1-7", name: "第七章", chapter: "7"},
        {index: "1-8", name: "第八章", chapter: "8"},
        {index: "1-9", name: "第九章", chapter: "9"},
        {index: "1-10", name: "第十章", chapter: "10"},
        {index: "1-11", name: "第十一章", chapter: "11"},
        {index: "1-12", name: "第十二章", chapter: "12"},
        {index: "1-13", name: "第十三章", chapter: "13"},
        {index: "1-14", name: "第十四章", chapter: "14"},
        {index: "1-15", name: "第十五章", chapter: "15"},
        {index: "1-16", name: "第十六章", chapter: "16"},
        {index: "1-17", name: "第十七章", chapter: "17"},
        {index: "1-18", name: "第十八章", chapter: "18"},
        {index: "1-19", name: "第十九章", chapter: "19"},
        {index: "1-20", name: "第二十章", chapter: "20"},
        {index: "1-21", name: "第二十一章", chapter: "21"},
        {index: "1-22", name: "第二十二章", chapter: "22"},
        {index: "1-23", name: "第二十三章", chapter: "23"},
        {index: "1-24", name: "第二十四章", chapter: "24"},
        {index: "1-25", name: "第二十五章", chapter: "25"},
        {index: "1-26", name: "第二十六章", chapter: "26"},
        {index: "1-27", name: "第二十七章", chapter: "27"},
        {index: "1-28", name: "第二十八章", chapter: "28"},
        {index: "1-29", name: "第二十九章", chapter: "29"},
        {index: "1-30", name: "第三十章", chapter: "30"},
        {index: "1-31", name: "第三十一章", chapter: "31"},
        {index: "1-32", name: "第三十二章", chapter: "32"},
        {index: "1-33", name: "第三十三章", chapter: "33"},
        {index: "1-34", name: "第三十四章", chapter: "34"},
        {index: "1-35", name: "第三十五章", chapter: "35"},
        {index: "1-36", name: "第三十六章", chapter: "36"},
        {index: "1-37", name: "第三十七章", chapter: "36"},
      ],
      chapter_de_list: [
        {index: "1-38", name: "第三十八章", chapter: "38"},
        {index: "1-39", name: "第三十九章", chapter: "39"},
        {index: "1-40", name: "第四十章", chapter: "40"},
        {index: "1-41", name: "第四十一章", chapter: "41"},
        {index: "1-42", name: "第四十二章", chapter: "42"},
        {index: "1-43", name: "第四十三章", chapter: "43"},
        {index: "1-44", name: "第四十四章", chapter: "44"},
        {index: "1-45", name: "第四十五章", chapter: "45"},
        {index: "1-46", name: "第四十六章", chapter: "46"},
        {index: "1-47", name: "第四十七章", chapter: "47"},
        {index: "1-48", name: "第四十八章", chapter: "48"},
        {index: "1-49", name: "第四十九章", chapter: "49"},
        {index: "1-50", name: "第五十章", chapter: "50"},
        {index: "1-51", name: "第五十一章", chapter: "51"},
        {index: "1-52", name: "第五十二章", chapter: "52"},
        {index: "1-53", name: "第五十三章", chapter: "53"},
        {index: "1-54", name: "第五十四章", chapter: "54"},
        {index: "1-55", name: "第五十五章", chapter: "55"},
        {index: "1-56", name: "第五十六章", chapter: "56"},
        {index: "1-57", name: "第五十七章", chapter: "57"},
        {index: "1-58", name: "第五十八章", chapter: "58"},
        {index: "1-59", name: "第五十九章", chapter: "59"},
        {index: "1-60", name: "第六十章", chapter: "60"},
        {index: "1-61", name: "第六十一章", chapter: "61"},
        {index: "1-62", name: "第六十二章", chapter: "62"},
        {index: "1-63", name: "第六十三章", chapter: "63"},
        {index: "1-64", name: "第六十四章", chapter: "64"},
        {index: "1-65", name: "第六十五章", chapter: "65"},
        {index: "1-66", name: "第六十四章", chapter: "66"},
        {index: "1-67", name: "第六十七章", chapter: "67"},
        {index: "1-68", name: "第六十八章", chapter: "68"},
        {index: "1-69", name: "第六十九章", chapter: "69"},
        {index: "1-70", name: "第七十章", chapter: "70"},
        {index: "1-71", name: "第七十一章", chapter: "71"},
        {index: "1-72", name: "第七十二章", chapter: "72"},
        {index: "1-73", name: "第七十三章", chapter: "73"},
        {index: "1-74", name: "第七十四章", chapter: "74"},
        {index: "1-75", name: "第七十五章", chapter: "75"},
        {index: "1-76", name: "第七十六章", chapter: "76"},
        {index: "1-77", name: "第七十七章", chapter: "77"},
        {index: "1-78", name: "第七十八章", chapter: "78"},
        {index: "1-79", name: "第七十九章", chapter: "79"},
        {index: "1-80", name: "第八十章", chapter: "80"},
        {index: "1-81", name: "第八十一章", chapter: "81"},
      ],
      idiom_list: [
        {index: "2-0", name: "玄之又玄"},
        {index: "2-1", name: "有无相生"},
        {index: "2-2", name: "功成不居"},
        {index: "2-3", name: "和光同尘"},
        {index: "2-4", name: "天地不仁"},
        {index: "2-5", name: "天长地久"},
        {index: "2-6", name: "上善若水"},
        {index: "2-7", name: "金玉满堂"},
        {index: "2-8", name: "功成身退"},
        {index: "2-9", name: "目迷五色"},
        {index: "2-10", name: "宠辱若惊"},
        {index: "2-11", name: "视而不见"},
        {index: "2-12", name: "听而不闻"},
        {index: "2-13", name: "涣然冰释"},
        {index: "2-14", name: "虚怀若谷"},
        {index: "2-15", name: "绝圣弃智"},
        {index: "2-16", name: "少私寡欲"},
        {index: "2-17", name: "相差无几"},
        {index: "2-18", name: "如登春台"},
        {index: "2-19", name: "飘风骤雨"},
        {index: "2-20", name: "余食赘行"},
        {index: "2-21", name: "天大地大"},
        {index: "2-22", name: "道法自然"},
        {index: "2-23", name: "知白守黑"},
        {index: "2-24", name: "去甚去泰"},
        {index: "2-25", name: "天道好还"},
        {index: "2-26", name: "佳兵不祥"},
        {index: "2-27", name: "知止不殆"},
        {index: "2-28", name: "自知之明"},
        {index: "2-29", name: "淡而无味"},
        {index: "2-30", name: "将夺固与"},
        {index: "2-31", name: "无中生有"},
        {index: "2-32", name: "若存若亡"},
        {index: "2-33", name: "大器晚成"},
        {index: "2-34", name: "大音希声"},
        {index: "2-35", name: "知足不辱"},
        {index: "2-36", name: "大巧若拙"},
        {index: "2-37", name: "知足常乐"},
        {index: "2-38", name: "出生入死"},
        {index: "2-39", name: "祸福相依"},
        {index: "2-40", name: "根深蒂固"},
        {index: "2-41", name: "以德报怨"},
        {index: "2-42", name: "轻诺寡信"},
        {index: "2-43", name: "千里之行，始于足下"},
        {index: "2-44", name: "慎终如始"},
        {index: "2-45", name: "俭故能广"},
        {index: "2-46", name: "寸进尺退"},
        {index: "2-47", name: "被褐怀玉"},
        {index: "2-48", name: "天网恢恢，疏而不漏"},
        {index: "2-49", name: "小国寡民"},
        {index: "2-50", name: "鸡犬相闻"},
        {index: "2-51", name: "老死不相往来"},
      ],
    }
  },
  methods: {
    toIdiom(){
        this.$router.push("/chengyudt?id=19979");
    },
    searchChapter(item) {
      this.ok = true;
      this.title = item.name;
      var that = this;
      this.axios({
        url: "/daodejing/selectChapter",
        method: "get",
        params: {
          chapter: item.chapter,
        },
      }).then(
        function (response) {
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
    selectIdiom(name) {
      this.ok = false;
      this.title = name;
      var that = this;
      this.axios({
        url: "/daodejing/selectIdiom",
        method: 'get',
        params: {
          name: name
        }
      }).then(
        function (response) {
          that.idiom_from = response.data.from;
          that.idiom_explanation = response.data.explanation
        }
      )
    },
    selectLanguage: function (language) {
      var that = this
      this.axios({
        url: "/daodejing/selectLanguage",
        method: 'get',
        params: {language: language}
      }).then(
        function (response) {
          that.translate = response.data;
        }
      )
    },
    toOriginal() {
      var that = this;
      this.axios({
        url: "/daodejing/toOriginal",
        method: "get",
        params: {
          keywords: this.idiom_from
        }
      }).then(function (response) {
        that.original = response.data.original;
        that.translate = response.data.translation;
        that.annotation = response.data.annotation;
        that.ok = true;
      })
    }
  },
};
</script>

<style scoped>

</style>
