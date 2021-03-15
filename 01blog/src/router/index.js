import Vue from 'vue'
import VueRouter from 'vue-router'
import Index from '../views/Index'
import Loign from '../views/admin/Login'
import {index_routes_children} from  './routes'

Vue.use(VueRouter)
const routes = [
  {
    path:'/',
    component:Index,
    redirect:'/home',
    children:index_routes_children
  },
  {
    path:'/admin',
    component:Loign,
    children:[]
  },
]

const router = new VueRouter({
  routes
})

export default router
