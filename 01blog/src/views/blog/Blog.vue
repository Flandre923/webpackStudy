<template>
<div>
  <back-ground-image></back-ground-image>
  <div class="container flex mx-auto mt-5">
    <div class="w-2/3 mx-2">
      <filling-schedule :cateblogs="cateblogs"></filling-schedule>
    </div>
    <div class="w-1/3 mx-2">
      <tag-card :tags="tags"></tag-card>
    </div>
  </div>
</div>
</template>

<script>
import FillingSchedule from "../../components/blog/FillingSchedule";
import BackGroundImage from "../../components/blog/BackGroundImage";
import TagCard from "../../components/blog/TagCard";
import { get_tags,get_blogs_date } from "@/api/blog/blog.js"
export default {
name: "Blog",
  data(){
  return{
    tags:null,
    cateblogs:null
  }
  },
  components:{
    BackGroundImage,
    FillingSchedule,
    TagCard
  },
  methods:{
  },
  created() {
    get_tags().then(res=>{
      this.tags = res.data
      console.log(res)
    })
    get_blogs_date().then(res=>{
      this.cateblogs = res.data
      console.log(res);
    })
  }
}
</script>

<style scoped>

</style>