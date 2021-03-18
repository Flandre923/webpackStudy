import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import "./main.css";
import MuseUI from 'muse-ui';
import 'muse-ui/dist/muse-ui.css';

Vue.config.productionTip = false
Vue.use(MuseUI);

router.beforeEach((to,from,next)=>{
  console.log(to.path)
  if(to.path==="/admin/home"
      || to.path==="/admin/editarticle"
      || to.path==="/admin/alterarticle"
      || to.path==="/admin/tags"
      || to.path==="/admin/friends"
      || to.path==="/admin/anime"){
    if(window.sessionStorage.getItem("tokenStr")){
      next()
    }else{
      next('/login')
    }
  }else{
    next()
  }
})

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
