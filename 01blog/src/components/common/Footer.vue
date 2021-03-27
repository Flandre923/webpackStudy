<template>
  <div class="mt-10 h-48 w-screen bg-black opacity-75">
    <div class="container mx-auto divide-y">
      <div class="flex divide-x space-x-4">
        <div class="w-1/2 flex items-center justify-center flex-wrap mb-2">
          <div class="text-gray-300 w-full text-center mb-2">最新文章</div>
          <div class="text-center">
          <button class="text-gray-400 w-full" v-for="blog in blogs" :key="blog.id" @click="$router.push('/blog/'+blog.id)">{{blog.title}}</button>
          </div>

        </div>
        <div class="w-1/2">
           <div class="flex justify-center">
             <div class="text-gray-400 m-4">
               <div class="text-center">受伤之后，人才会知道那是疼痛。无论是反驳、辩护或痛骂，都只不过是大脑为了减轻伤痛制造的解药。 <br></div>
               <div class="text-right">--《空之境界》</div>
             </div>
          </div>
        </div>
      </div>
      <div>
        <div class="w-full flex justify-center">
          <div class="text-gray-400">Copyright © 2019 - 2021</div>
          <span class="ml-4 text-blue-300">  Flandre’s Tea Time</span>
        </div>
        <div class="text-gray-400 flex items-center justify-center">
          <div class="mr-2">Power By:</div>
          <div class="mr-2">vue</div>
          <div class="mr-2">vue</div>
          <div class="mr-2">vue</div>
        </div>
      </div>

    </div>
  </div>
</template>

<script>
import {getBlogs} from "../../api/home/home";

export default {
  name: "Footer",
  data(){
    return{
        blogs:null,
    }
  },
  created() {
    getBlogs({page_size:null,current:null}).then(res=>{
      console.log(res.data.data);
      this.blogs = res.data.data;
    })
  }
}
</script>

<style scoped>

</style>