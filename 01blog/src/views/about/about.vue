<template>
<div>
  <back-ground-image class="bg-top bg-cover" imageURL="https://view.moezx.cc/images/2021/02/08/44d079df65f53f100393d8913c357102.jpg"></back-ground-image>
  <mu-container>
    <mu-paper class="m-5 p-5" :z-depth="5">
        <about-aplayer></about-aplayer>
    </mu-paper>
    <mu-paper class="m-5 p-5" :z-depth="5">
      <mu-container>
        <mu-tabs :value.sync="active3" center color="teal">
          <mu-tab>
            关于我？
          </mu-tab>
          <mu-tab>
            关于本站？
          </mu-tab>
          <mu-tab>
            赞赏?
          </mu-tab>
        </mu-tabs>
        <div class="demo-text" v-if="active3 === 0">
<!--          -->
          <about-me></about-me>
        </div>
        <div class="demo-text" v-if="active3 === 1">
<!--         -->
          <about-blog></about-blog>
        </div>
        <div class="demo-text" v-if="active3 === 2">
         <about-donate></about-donate>
        </div>
      </mu-container>
    </mu-paper>
    <about-comment></about-comment>
  </mu-container>

</div>
</template>

<script>
import BackGroundImage from "../../components/blog/BackGroundImage";
import AboutAplayer from "../../components/about/AboutAplayer";
import AboutMe from "../../components/about/AboutMe";
import AboutBlog from "../../components/about/AboutBlog";
import AboutDonate from "../../components/about/AboutDonate";
import ArtilesComponent from "../../components/index/common/ArtilesComponent";
import AboutComment from "../../components/about/AboutComment";
export default {
name: "about",
  components:{
    AboutComment,
    AboutAplayer,BackGroundImage,AboutMe,AboutBlog,AboutDonate,ArtilesComponent
  },
  data () {
    return {
      active3: 0,
    };
  },
  methods:{
  }

}
</script>

<style lang="less" scoped>

</style>