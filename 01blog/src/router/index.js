import Vue from 'vue'
import VueRouter from 'vue-router'
import Index from '../views/Index'
import Loign from '../views/admin/Login'
import {index_routes_children} from  './routes'
import {admin_routes} from  './adminroutes'
const AdminIndex = () => import("../views/admin/index/AdminIndex")
const AdminHome = () => import("../views/admin/Home/AdminHome")

Vue.use(VueRouter)
const routes = [
  {
    path:'/',
    component:Index,
    redirect:'/home',
    children:index_routes_children
  },
  {
    path:'/login',
    component:Loign,
  },
  {
    path:'/admin',
    component:AdminIndex,
    redirect:'/admin/home',
    children:admin_routes
  },
]

const router = new VueRouter({
  routes
})

export default router
