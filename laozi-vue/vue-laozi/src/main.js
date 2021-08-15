// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import axios from 'axios'
import VueAxios from 'vue-axios'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import './assets/css/global.css'
import topbar from "./components/common/topbar";
import footbar from "./components/common/footbar"
import echarts from 'echarts'

// axios.defaults.baseURL=process.env.API_ROOT;
axios.defaults.baseURL="http://localhost:8080"
Vue.config.productionTip = false
Vue.use(ElementUI)
Vue.use(VueAxios, axios)
Vue.component('top-bar',topbar)
Vue.component('foot-bar',footbar)
Vue.prototype.$echarts = echarts
/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  components: { App},
  template: '<App/>'
})


