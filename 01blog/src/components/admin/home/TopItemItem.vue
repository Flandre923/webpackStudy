<template>
  <mu-col :span="span1" :offset="offset1">
    <div class="grid-cell">
      <mu-button :color="color1" @click="buttonclick">
        <slot></slot>
      </mu-button>
    </div>
  </mu-col>
</template>

<script>
export default {
name: "TopItemItem",
  props:{
    span1:{
      default:1,
    },
    offset1:{
      default:0,
    },
    color1:{
      default:'primary',
    },
    url:{},
    logout:{}

  },
  data(){
    return {
    }
  },
  methods:{
    buttonclick(){
      if(this.logout===true){
        window.sessionStorage.removeItem("tokenStr")
        this.$router.push("/login")
      }else {
        this.$router.push(this.url)
      }
    }
  }
}
</script>

<style scoped>

</style>