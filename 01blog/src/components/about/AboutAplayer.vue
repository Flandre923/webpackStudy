<template>
  <aplayer autoplay
           :music="music"
           :list="listmusic"
  />
</template>

<script>
import Aplayer from "vue-aplayer";
export default {
name: "AboutAplayer",
  components:{
    Aplayer
  },
  data(){
    return{
      listmusic:[
        {
          title: 'はらり、ひらり',
          artist: 'Sona',
          src: 'http://music.163.com/song/media/outer/url?id=5357088.mp3',
          pic: 'http://p1.music.126.net/23MfRObAk2q9syO_VCUYDA==/352943232527522.jpg?param=130y130',
        },
        {
          title: 'どうして…',
          artist: 'めらみぽっぷ',
          src: 'http://music.163.com/song/media/outer/url?id=850775.mp3',
          pic: 'http://p2.music.126.net/BUHcvSSz0VKwWx3Tke9yww==/891703930126638.jpg?param=130y130'
        },
        {
          title: '君だったら',
          artist: 'HAPPY BIRTHDAY',
          src: 'http://music.163.com/song/media/outer/url?id=26116370.mp3',
          pic: 'http://p2.music.126.net/PfLFdJg2wKihsac60C-lYA==/2512384069491818.jpg?param=130y130'
        }
      ],
      music: {
        title: '黒猫奇想譚',
        artist: '96猫',
        src: 'http://music.163.com/song/media/outer/url?id=28403167.mp3',
        pic: 'http://p2.music.126.net/PfLFdJg2wKihsac60C-lYA==/2512384069491818.jpg?param=130y130'
      }
    }
  }
}
</script>

<style scoped>

</style>