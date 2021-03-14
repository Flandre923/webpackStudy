<template>
  <div>
    <!--     图-->
    <home-page-picture></home-page-picture>
    <my-content v-for="(blog,index) in blogs" :key="index" :blog="blog"></my-content>

  </div>
</template>

<script>
import HomePagePicture from "../../components/index/HomePagePicture";
import myContent from "../../components/index/Content";
import {getBlogs} from "@/api/home/home.js"

export default {
name: "Home",
  components:{
    myContent,
    HomePagePicture,
  },
  data(){
  return{
    blogs:null,
  }
  },
  created(){
    getBlogs().then(res=>{
      this.blogs = res.data
      console.log(this.blogs)
    })
  }
}
</script>

<style scoped>

</style>