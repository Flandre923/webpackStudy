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
          title: 'Qilin\'s Prance 麟跃幽岩',
          artist: '陈致逸 / HOYO-MiX',
          src: 'https://m801.music.126.net/20210314210111/76ce41600ee1ad09773d4a6f37e2e761/jdyyaac/obj/w5rDlsOJwrLDjj7CmsOj/7262339653/3ed5/5631/59c3/8cb559be4453505c5a6e9981d1fa764f.m4a',
          pic: 'http://p2.music.126.net/hwxZS2Bv9Dht_8chjLLR-Q==/109951165690591384.jpg?param=130y130',
        },
        {
          title: '黒ネコのタンゴ',
          artist: '大橋のぞみ',
          src: 'https://m801.music.126.net/20210314212137/0081862cbd600f840d1e179c5e071e5e/jdyyaac/obj/w5rDlsOJwrLDjj7CmsOj/7813139243/057c/8e68/f262/d25ca515923d07649b47e51e9da092db.m4a',
          pic: 'http://p2.music.126.net/q19LH87XgR2THQVq8YgWsg==/649811372038051.jpg?param=130y130'
        },
        {
          title: '君だったら',
          artist: 'HAPPY BIRTHDAY',
          src: 'https://m801.music.126.net/20210314213350/4bdd0ed0c5013f23a35aadc9beb7360f/jdyyaac/545b/0453/005c/c1752b59c03975a78bfc7638abde00a9.m4a\n',
          pic: 'http://p2.music.126.net/PfLFdJg2wKihsac60C-lYA==/2512384069491818.jpg?param=130y130'
        }
      ],
      music: {
        title: '君だったら',
        artist: 'HAPPY BIRTHDAY',
        src: 'https://m801.music.126.net/20210314213350/4bdd0ed0c5013f23a35aadc9beb7360f/jdyyaac/545b/0453/005c/c1752b59c03975a78bfc7638abde00a9.m4a\n',
        pic: 'http://p2.music.126.net/PfLFdJg2wKihsac60C-lYA==/2512384069491818.jpg?param=130y130'
      }
    }
  }
}
</script>

<style scoped>

</style>