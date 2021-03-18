<template>
  <mu-chip :color="chip[randomnumber()]" class=""  @click="tagSearchClick(tag)">
    <slot></slot>
  </mu-chip>
</template>

<script>
export default {
name: "TagItem",
  data(){
  return{
    chip: ['primary', 'secondary', 'success', 'warning', 'info', 'error'],
  }
  },
  props:{
   tag:{}
  },
  methods:{
   randomnumber(){
     return Math.floor(Math.random()*5)
   },
  tagSearchClick(tag){
  console.log("123")
  this.$router.push("/search/tag"+tag.id)
  }
  }
}
</script>

<style scoped>

</style>