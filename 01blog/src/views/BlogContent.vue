<template>
<div>

  <div class="w-screen bg-cover bg-top" :style="'height:400px; background-image: url('+content.picture+')'"></div>
  <mu-paper class="container mx-auto text-left" :z-depth="5">
  <div>
    <div class="mx-auto">
      <h1 class="text-center p-4">{{content.title}}</h1>
    </div>
  </div>
    <mu-divider></mu-divider>
  <div class="markdown-body mx-8 text-left pt-5" style="min-height: 750px" v-html="content.content">
  </div>
 </mu-paper>
</div>
</template>

<script>
import {request} from "../api/request";
import 'github-markdown-css/github-markdown.css'
export default {
name: "BlogContent",
  data(){
    return{
      content:null,
    }
  },
  methods:{

  },
  created() {
    const blogid = this.$route.params;
    request({
      url:'/blog/content',
      method:'get',
      params:{
        id:blogid.blogId
      }
    }).then(res=>{
      this.content = res.data
      // mrakdown渲染
      let MarkdownIt = require("markdown-it")
      let md = new MarkdownIt()
      let result = md.render(this.content.content)
      this.content.content = result
      //
      console.log(content)
    })
    console.log(blogid.blogId)
  }

}
</script>

<style scoped>

</style>