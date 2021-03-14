import Vue from 'vue'
import VueRouter from 'vue-router'
import Index from '../views/Index'
const Home = () => import("../views/home/Home")
const Blog = () => import("../views/blog/Blog")
const Anime = () => import("../views/anime/Anime")

Vue.use(VueRouter)
const routes = [
  {
    path:'/',

    component:Index,
    redirect:'/home',
    children:[
      {
        path:'/home',
        name:'home',
        component:Home,
        meta:{
          title:'首页'
        }
      },
      {
        path: '/blog',
        name:'blog',
        component:Blog,
        meta:{
          title:'博客归档和标签'
        }
      },
      {
        path: '/anime',
        name:'anime',
        component:Anime,
        meta:{
          title:'番剧'
        }
      }
    ]
  },
]

const router = new VueRouter({
  routes
})

export default router
