<template>
  <div class="m-4 w-1/2">
    <div class="w-full text-center text-black text-xl mb-2 font-bold
                transition duration-500 ease-in-out transform hover:-translate-y-1 hover:scale-110">{{artiles.title}}</div>
    <div class="w-full flex items-center justify-center space-x-4 mb-4 text-sm">
      <div class="text-blue-600">{{timeFomat}}</div>
      <div class="text-black">大约 {{ artiles.number}} 字</div>
      <div class="text-black">阅读时长 {{artiles.readTime}} 分钟</div>
    </div>
    <p class="mb-10 m-4 mt-5 break-normal whitespace-pre-line">
      {{artiles.summary}}
    </p>
    <div class="divide-black divide-y">
      <router-link :to="{path:'/blog/'+artiles.id}">
        <div class="flex items-center justify-center">
          <button class="w-1/4 text-center rounded
                bg-gradient-to-r from-blue-500 divide-purple-600
               to-pink-500 text-lg transition duration-500 ease-in-out transform hover:-translate-y-1 hover:scale-110">阅读全文</button>
        </div>
      </router-link>
      <div class="flex space-x-4 mt-4">
          <div class="bg-red-300 border rounded-l-xl px-2 mt-4" v-for="(tag,index) in artiles.tags" :key="index">
            <router-link :to="{path:'/search/tag'+tag.id}">
            {{ tag.name }}
            </router-link>
          </div>

      </div>
    </div>
  </div>
</template>

<script>
import {timefomat} from "../../../util/timeformat";

export default {
name: "ArtilesComponent",
  data(){
  return{

  }
  },
  props:{
    artiles:{},
  },
  computed:{
    timeFomat(){
      return timefomat(this.artiles.createTime)
    }
  }
}
</script>

<style scoped>

</style>