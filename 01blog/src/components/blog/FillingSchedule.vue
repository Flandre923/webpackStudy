<template>
  <mu-flex justify-content="center">
    <mu-flex class="flex-demo w-full" justify-content="center" >
      <mu-container>
        <mu-expansion-panel v-for="(cateblog,index) in cateblogs" :key="cateblog.id" :expand="panel === index" @change="toggle(index)" >
          <div slot="header">{{ cateblog.year }}</div>
          <archive-articles :cateblog="cateblog"></archive-articles>
        </mu-expansion-panel>

      </mu-container>
    </mu-flex>
  </mu-flex>
</template>

<script>
import ArchiveArticles from "./ArchiveArticles";
export default {

name: "FillingSchedule",
  data(){
    return{
      panel: ''
    }
  },
  props:{
    cateblogs:{}
  },
  components:{
    ArchiveArticles
  },
  methods:{
    toggle (panel) {
      this.panel = panel === this.panel ? '' : panel;
    }
  }
}
</script>

<style scoped>

</style>