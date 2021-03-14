<template>
  <div class="w-1/3">
    <mu-container>
      <mu-card>
        <mu-card-media :title="anime.animename" :sub-title="anime.animeoriginname">
          <img :src="anime.animeimg">
        </mu-card-media>
        <mu-card-text>
          <div class="py-5">{{ anime.animedesc }}</div>
          <mu-flex class="demo-linear-progress">
            <mu-linear-progress :value="anime.animeprogress" :size="15" mode="determinate" color=""></mu-linear-progress>
          </mu-flex>
        </mu-card-text>
      </mu-card>
    </mu-container>
  </div>
</template>

<script>
export default {
name: "amineItem",
  date(){
  return{
    linear:20
  }
  },
  props:{
  anime:{}
  }
}
</script>

<style scoped>

</style>