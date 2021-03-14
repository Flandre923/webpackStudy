<template>
  <div class="w-1/2 relative">
    <img :src="jpeg" alt="" class="w-full h-full object-cover">
  </div>
</template>

<script>
export default {
  name: "AspJpeg",
  props:{
    jpeg:{

    },
  }
}
</script>

<style scoped>

</style>