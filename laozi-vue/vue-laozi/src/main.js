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

axios.defaults.baseURL=process.env.API_ROOT;
Vue.config.productionTip = false
Vue.use(ElementUI)
Vue.use(VueAxios, axios)
Vue.component('top-bar',topbar)
Vue.component('foot-bar',footbar)
/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  components: { App},
  template: '<App/>'
})


