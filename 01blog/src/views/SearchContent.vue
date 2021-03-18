<template>
 <div>
   <back-ground-image class="bg-center bg-cover" imageURL="https://view.moezx.cc/images/2021/03/11/02acb66c3815434cd5f1f8aed2cb3828.jpg"></back-ground-image>
   <div>
     <mycontent v-for="blog in blogs" :blog="blog"></mycontent>
   </div>
 </div>
</template>

<script>
import BackGroundImage from "../components/blog/BackGroundImage";
import mycontent from "../components/index/Content";
import {request} from "../api/request";

export default {
  name: "SearchContent",
  components:{
    BackGroundImage,
    mycontent,
  },
  data(){
    return{
      blogs:null,
    }
  },
  created(){
    request({
      url:"/search/tags/blog",
      method:"get",
      params:{
        tagid:this.$route.params.search
      }
    }).then(res=>{
      this.blogs=res.data
    })
    console.log(this.$route.params.search);

  }
}
</script>

<style scoped>

</style>