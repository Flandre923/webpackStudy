<template>
  <mu-chip :color="chip[randomnumber()]" class="">
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
  methods:{
   randomnumber(){
     return Math.floor(Math.random()*5)
   }
  }
}
</script>

<style scoped>

</style>