<template>
  <div class="h-16 bg-gradient-to-r from-pink-200 via-purple-200 to-blue-200">
    <div class="header container mx-auto flex items-center h-full shadow-xl">
      <item url="/home">首页</item>
      <item url="/blog">博客</item>
      <item url="/anime">番剧</item>
      <item url="/photo">图片</item>
      <item url="/friends">友人帐</item>
      <item url="/about">关于我</item>
      <search-item></search-item>
    </div>
  </div>
</template>

<script>
import Item from "./children/Item";
import SearchItem from "./children/SearchItem";
export default {
name: "Header",
  components:{
    Item,SearchItem
  },
  props:{

  },
  methods:{
  },
  data(){
  return{

  }
  }

}
</script>

<style scoped>

</style>