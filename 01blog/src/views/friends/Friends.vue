<template>
<div>
  <back-ground-image class="bg-top bg-cover" :imageURL="'https://2heng.xin/wp-content/uploads//2017/12/托尔_-PID62179525-by-淺に春-1-1.jpg'"></back-ground-image>
  <div class="container mx-auto">
    <friends-item></friends-item>
    <div>
      <mu-paper class="flex flex-wrap mt-5 items-center justify-center" :z-depth="5">
        <friends-link-item v-for="friend in friendsdata" :key="friend.id" :friend="friend"></friends-link-item>

      </mu-paper>
    </div>
  </div>
</div>
</template>

<script>
import BackGroundImage from "../../components/blog/BackGroundImage";
import FriendsItem from "../../components/friends/FriendsItem";
import FriendsLinkItem from "../../components/friends/FriendsLinkItem";
import {get_friends} from "@/api/friend/friend.js"
export default {
name: "Friends",
  components:{
  BackGroundImage,FriendsItem,FriendsLinkItem
  },
  data(){
  return{
    friendsdata:null
  }
  },
  created() {
    get_friends().then(res=>{
      this.friendsdata = res.data
      console.log(this.friendsdata);
    })
  }
}
</script>

<style scoped>

</style>