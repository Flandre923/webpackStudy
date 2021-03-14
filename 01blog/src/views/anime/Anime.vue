<template>
<div>
  <back-ground-image :iamgepos="'bg-top'" imageURL="https://2heng.xin/wp-content/uploads//2017/12/｡･：＊：･✿-PID65231071-by-hakusai.jpg"></back-ground-image>
  <div class="container mx-auto mt-2">
    <div class="flex flex-wrap">
      <amine-item v-for="(anime,index) in animes" :anime="anime" :key="index"></amine-item>
    </div>
  </div>
</div>
</template>

<script>
import BackGroundImage from "../../components/blog/BackGroundImage";
import AmineItem from "@/components/amine/AmineItem"
import  {get_animes} from '@/api/anime/anime.js'
export default {
name: "Anime.vue",
  components:{
    BackGroundImage,AmineItem
  },
  data(){
  return{
    animes:null,
  }
  },
  created() {
    get_animes().then(res=>{
      this.animes = res.data
      console.log(res.data);
    })
  }

}
</script>

<style scoped>

</style>