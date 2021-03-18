<template>
  <div class="h-16 bg-red-300 py-3 px-2 items-center justify-center">
    <mu-row justify-content align-content align-items>
      <top-item-item span1="1" offset1="3" color1="primary" url="/admin/home">后台首页</top-item-item>
      <top-item-item span1="1" offset1="0" color1="primary" url="/admin/editarticle">编辑文章</top-item-item>
      <top-item-item span1="1" offset1="0" color1="primary" url="/admin/alterarticle">修改文章</top-item-item>
      <top-item-item span1="1" offset1="0" color1="primary" url="/admin/tags">管理分类</top-item-item>
      <top-item-item span1="1" offset1="0" color1="primary" url="/admin/anime">管理番剧</top-item-item>
      <top-item-item span1="1" offset1="0" color1="primary" url="/admin/friends">管理友人帐</top-item-item>
      <top-item-item span1="1" offset1="2" color1="primary" url="" :logout="true">注销</top-item-item>
    </mu-row>
  </div>
</template>

<script>
import TopItemItem from "./TopItemItem";
export default {
name: "AdminHomeTopitem",
  components: {TopItemItem},
  methods:{
    logout(){
      console.log('11')
      window.sessionStorage.removeItem("tokenStr")
      this.$router.push("/admin")
    }
  }
}
</script>

<style scoped>

</style>