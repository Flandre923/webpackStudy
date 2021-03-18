<template>
  <div class="flex items-center justify-center">
    <mu-text-field v-model="input" label-width="3" help-text="搜索..."></mu-text-field>
  </div>
</template>

<script>
export default {
  name: "SearchItem",
  data(){
    return{
      input:null
    }
  },
  components:{
  },
  methods:{
  },
  computed:{

  }
}
</script>

<style scoped>

</style>