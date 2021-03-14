<template>
  <div class="m-0">
<!--    导航栏-->
    <myHeader></myHeader>
    <router-view/>
    <myFooter></myFooter>
  </div>
</template>

<script>
import myHeader from '@/components/common/Header'
import myFooter from '@/components/common/Footer'
export default {
  name: "Home",
  components:{
    myHeader,myFooter
  }
}
</script>

<style scoped>


</style>