<template>
  <div class="flex items-center justify-center w-full mt-10">
    <div class="w-3/4">
      <mu-paper class="demo-paper" :z-depth="3">
        <div class="ml-10 py-5 font-mono text-base font-semibold tracking-wide leading-6">
          <p class="mb-5">欢迎交换友链</p>
          <p>请留言告诉我你的：</p>
          <p>1、名字</p>
          <p>2、一句话介绍（熟人我会亲自帮写的）</p>
          <p>3、主页地址</p>
          <p class="mb-10">4、头像（HTTPS*）</p>

          <p>For Example：</p>
          <ul class="list-disc list-inside">
            <li class="ml-5">Name: FLandre's Tea Time</li>
            <li class="ml-5">Desc: 芙兰朵露狂热粉</li>
            <li class="ml-5">URL: https://www.baidu.com</li>
            <li class="ml-5">Avatar: 头像</li>
          </ul>
        </div>
      </mu-paper>
    </div>
  </div>
</template>

<script>
export default {
name: "FriendsItem"
}
</script>

<style scoped>

</style>