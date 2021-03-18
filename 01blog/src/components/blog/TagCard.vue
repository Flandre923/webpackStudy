<template>
  <mu-container>
    <mu-card>
      <mu-card-title title="文章标签" sub-title="Blog's tags"></mu-card-title>
      <mu-card-text>
        <mu-container class="">
          <tag-item class="mb-2 mr-3" v-for="(tag,index) in tags" :key="index" :tag="tag">
            {{ tag.name }}
          </tag-item>
        </mu-container>
      </mu-card-text>
    </mu-card>
  </mu-container>
</template>

<script>
import TagItem from "./TagItem";
export default {
  name: "TagCard",
  components:{
    TagItem
  },
  methods:{

  },
  props:{
    tags:{}
  }
}
</script>

<style scoped>

</style>