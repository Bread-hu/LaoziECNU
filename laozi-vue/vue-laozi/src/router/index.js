import Vue from 'vue'
import Router from 'vue-router'
import laozi from '@/components/laozi'
import mainPage from '@/components/mainPage'
import tempPage from  '@/components/mainTemp'
import zuozhe from '@/components/zuozhe'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/laozi',
      name: 'laozi',
      component: laozi
    },
    {
      path: '/',
      name: 'mainPage',
      component: mainPage
    },
    {
      path: '/temp',
      name: 'tempPage',
      component: tempPage
    },
    {
      path: '/zuozhe',
      name: 'zuozhe',
      component: zuozhe
    }
  ]
})
