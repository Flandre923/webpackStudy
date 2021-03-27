<template>
  <div>
    <!--     图-->
    <home-page-picture></home-page-picture>
    <my-content v-for="(blog,index) in blogs" :key="index" :blog="blog"></my-content>
    <mu-flex justify-content="center" class="py-5">
      <mu-pagination :total="page.total" :current.sync="page.current" :page-size="page.page_size" @change="page_change"></mu-pagination>
    </mu-flex>
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
    page:{
      total:0,
      current:1,
      page_size:10,
    }
  }
  },
  methods:{
    page_change(){
     this.getAllBlogAndPage()
    },
    getAllBlogAndPage(){
      getBlogs(this.page).then(res=>{
        this.blogs = res.data.data
        this.page.total = res.data.total
        console.log(this.blogs)
      })
    }
  },
  created(){
    this.getAllBlogAndPage()
  }
}
</script>

<style scoped>

</style>