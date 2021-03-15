<template>
  <mu-paper class="w-1/4 m-5 p-5 hover:bg-yellow-200" :z-depth="5">
    <a :href="friend.friendurl">
      <div class="flex ">
        <div class="w-1/2 ">
          <mu-avatar :size="100">
            <img :src="friend.friendavatar">
          </mu-avatar>
        </div>
        <div class="w-1/2">
          <div class="mb-5 text-yellow-700">
            {{friend.friendname}}
          </div>
          <p class="overflow-hidden text-gray-600 break-words">
            {{friend.frienddesc}}
          </p>
        </div>
      </div>
    </a>
  </mu-paper>
</template>

<script>
export default {
name: "FriendsLinkItem",
  props:{
    friend:{}
  }
}
</script>

<style scoped>

</style>