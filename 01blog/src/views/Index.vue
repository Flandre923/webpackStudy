<template>
  <div class="m-0">
<!--    导航栏-->
    <myHeader></myHeader>
    <router-view :key="key"/>
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
  },
  computed:{
    key() {
      return this.$route.name !== undefined? this.$route.name +new Date(): this.$route +new Date()
    }
  }
}
</script>

<style scoped>


</style>