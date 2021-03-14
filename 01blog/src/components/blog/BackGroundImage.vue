<template>
  <div :class="iamgepos" :style="'height: 400px;background-image: url('+ imageURL +')'">
  </div>
</template>

<script>
export default {
  name: "BackGroundImage",
  props:{
    imageURL:{
      type:String,
      default:'https://2heng.xin/wp-content/uploads//2018/05/sakura.jpg'
    },
    iamgepos:{
      type:String,
      default:'bg-center'
    }
  }
}
</script>

<style scoped>

</style>