<template>
  <div class="mt-5 mx-20">
    <h2 class="text-2xl font-mono font-bold">赞赏？</h2>
    <mu-divider></mu-divider>
    <ul class="list-disc list-inside mx-5 leading-6 text-base tracking-wide space-y-4">
      <p>虽然我还不至于吃不到饭，但过得还是勉勉强强吧，如果你觉得这网站的对你有帮助的还请支持一下</p>
      <p>想了解网站怎么写的话，遇到不懂的地方或者看不懂的地方都可以问我，我会尽全力在我力所能及的范围内帮组你的。</p>
      <p class="text-base font-bold">关于我的联系方式：</p>
      <div class="w-full">
        <div class="flex items-center justify-center">
          <mu-button color="primary" style="margin-bottom: 16px;" @click="toggleAlert()">联系我</mu-button>
        </div>
      </div>
      <mu-alert class="flex flex-wrap" color="primary" @delete="alert1 = false" delete v-if="alert1" transition="mu-scale-transition">
        <div class="w-full text-center"> <mu-icon left value="qq: "></mu-icon>804984970</div>
        <div class="w-full text-center"> <mu-icon left value="mail :"></mu-icon>804984970@qq.com</div>
        <div class="w-full text-center"> <mu-icon left value="github: "></mu-icon>?</div>
        <div class="w-full text-center"> <mu-icon left value="bilibili : "></mu-icon>?</div>
      </mu-alert>
      <div class="text-base font-bold">赞赏</div>
      <div class="w-full">
        <div class="flex items-center justify-center">
          <mu-button color="primary" style="margin-bottom: 16px;" @click="toggleAlert1()">赞赏?</mu-button>
        </div>
      </div>
      <mu-alert color="primary" @delete="alert2 = false" delete v-if="alert2" transition="mu-scale-transition">
        <div  class="flex items-center justify-center">
          <div class="flex-row"> 谢谢主子了 喵~</div>
          <mu-icon class="ml-32" left value="支付宝: "></mu-icon>
          <img class="h-32" src="@/assets/iamgedonate/Alipay.png" alt="支付宝">
          <mu-icon class="ml-5" left value="微信: "></mu-icon>
          <img class="h-32" src="@/assets/iamgedonate/reward.png" alt="微信">
        </div>
      </mu-alert>
    </ul>
  </div>
</template>

<script>
export default {
  name: "AboutDonate",
  methods:{
    toggleAlert () {
      this.alert1 = !this.alert1;
    },
    toggleAlert1 () {
      this.alert2 = !this.alert2;
    }
  },
  data () {
    return {
      alert1: false,
      alert2: false
    };
  },
}
</script>

<style scoped>

</style>