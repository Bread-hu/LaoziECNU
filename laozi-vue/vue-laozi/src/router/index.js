import Vue from 'vue'
import Router from 'vue-router'
import daodejing from '../components/daodejing'
import mainPage from '@/components/mainPage'
import tempPage from  '@/components/mainTemp'
import zuozhe from '@/components/zuozhe'
import chengyu from '@/components/chengyu'
import wenxian from '@/components/wenxian'
// import zhishitupu from '@/components/zhishitupu'
import zhishitupu from '@/components/2DView'
import book from  '@/components/book'
import chengyudt from '@/components/chengyu_detailed'
import bookdt from '@/components/book_detailed'
import zuozhedt from "../components/zuozhedt"
import shikongjian from "../components/shikongjian";
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
    },
    {
      path: '/book',
      name: 'book',
      component: book
    },
    {
      path: '/chengyudt',
      name: 'chengyudt',
      component: chengyudt
    },
    {
      path: '/bookdt',
      name: 'bookdt',
      component: bookdt
    },
    {
      path: '/zuozhedt',
      name: 'zuozhedt',
      component: zuozhedt
    },
    {
      path: '/shikongjian',
      name: 'shikongjian',
      component: shikongjian
    }
  ]
})
