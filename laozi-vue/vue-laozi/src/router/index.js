import Vue from 'vue'
import Router from 'vue-router'
import daodejing from '@/components/daodejing'
import mainPage from '@/components/mainPage'
import tempPage from  '@/components/mainTemp'
import zuozhe from '@/components/zuozhe'
import chengyu from '@/components/chengyu'
import wenxian from '@/components/wenxian'
import zhishitupu from '@/components/zhishitupu'

Vue.use(Router)

export default new Router({
  mode:'history',
  routes: [
    {
      path: '/daodejing',
      name: 'daodejing',
      component: daodejing
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
    },
    {
      path: '/chengyu',
      name: 'chengyu',
      component: chengyu
    },
    {
      path:'/wenxian',
      name:'wenxian',
      component: wenxian
    },
    {
      path: '/zhishitupu',
      name: 'zhishitupu',
      component: zhishitupu
    }
  ]
})
