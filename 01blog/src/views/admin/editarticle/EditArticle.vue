<template>

<div class="h-full w-full bg-gray-300 py-5">
  <div class="container mx-auto">
    <mu-container>
    <div class="w-2/3 mx-auto  pt-10">
        <mu-text-field v-model="title" label="标题请输入" full-width></mu-text-field>
    </div>
    <div class="w-2/3 mx-auto">
      <div class="text-base">
        <mu-text-field v-model="blogdesc" label="关于文章的简介" multi-line :rows="4" full-width></mu-text-field><br/>
      </div>
    </div>
    <div class="flex w-2/3 mx-auto">
      <div class="w-1/2">
        <mu-text-field v-model.number="number"  label="文章字数" placeholder="最多不超过5个字符" :max-length="5"></mu-text-field><br/>
      </div>
      <div class="w-1/2">
        <mu-text-field v-model.number="readTime"  label="阅读时间"></mu-text-field><br/>
      </div>
    </div>
    <div class="flex w-2/3 mx-auto mt-4">
      <div class="w-1/2 mr-5">
        <mu-text-field v-model="image"  label="图片"></mu-text-field><br/>
      </div>
      <div class="w-1/2">
<!--        选择框-->
        <mu-select label="Tags Input" v-model="tags"  chips multiple tags>
          <template slot="selection" slot-scope="scope">
            <mu-chip :selected="scope.selected" color="teal">
              {{scope.label}}
            </mu-chip>
          </template>
          <mu-option v-for="(language,index) in languages" :key="index" :label="language.name" :value="language.id"></mu-option>
        </mu-select>
      </div>
    </div>
    <div id="main" class="mt-5">
      <mavon-editor v-model="value"/>
    </div>
   <div class="mt-5">
     <mu-button color="info" class="" @click="blogsubmit()">提交</mu-button>
   </div>

    </mu-container>
  </div>

</div>
</template>

<script>
import {get_tags,submit_blogs} from "@/api/blog/blog.js"
import {request} from "../../../api/request";

var mavonEditor = require('mavon-editor')
import 'mavon-editor/dist/css/index.css'
export default {
  name: "EditArticle",
  data(){
    return{
      id:null,
      value:'',
      title:'',
      blogdesc:'',
      number:'',
      readTime:'',
      image:'',
      languages:[],
      tags:[]
    }
  },
  components: {
    'mavon-editor': mavonEditor.mavonEditor
  },
  created() {
    get_tags().then(res=>{
      this.languages =res.data;
      console.log(res.data)
    })
    const blogId = this.$route.params.blogId
    if(blogId){
      request({
        url:"/admin/blog/id",
        method:'get',
        params:{
          id:blogId
        }
      }).then(res=>{
        console.log(res.data)
        this.value=res.data.content
        this.id = res.data.id
        this.number = res.data.number
        this.title = res.data.title
        this.blogdesc = res.data.summary
        this.readTime = res.data.readTime
        this.image = res.data.picture
        for(let tag of res.data.tags){
          this.tags.push(tag.id)
        }
      })
    }

  },
  methods:{

    blogsubmit(){
      const blog = {
        id:this.id,
        title: this.title,
        summary: this.blogdesc,
        content: this.value,
        number:  this.number,
        readTime: this.readTime,
        picture: this.image,
        tags:this.tags
      }
      submit_blogs(blog)
      this.$router.push("/")

    }
  },
}
</script>

<style scoped>

</style>