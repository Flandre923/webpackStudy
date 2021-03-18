<template>
  <div class="flex items-center justify-center h-screen bg-cover bg-center" style="background-image: url('https://view.moezx.cc/images/2021/02/14/ff73ab59a6d61af6d915e84e8020ecaa.webp')">
    <div class="flex bg-white max-w-3xl">
      <div class="p-8 w-1/2">
        <h1 class="text-3xl text-center mb-4">登录</h1>
          <div class="my-3">
            <div class="border border-red-500 text-red-600" v-if="username_error"> {{ error_username_message }} </div>
            <input v-model="user.username" type="text" placeholder="Username" class="border rounded w-full py-2 px-4 outline-none focus:outline "/>
          </div>
          <div class="my-3">
            <div class="border border-red-500 text-red-600" v-if="password_error">{{error_password_message}} </div>
            <input v-model="user.password" type="password" placeholder="Password" class="border rounded w-full py-2 px-4 outline-none focus:outline "/>
          </div>
          <div class="my-3 flex">
            <button class="border rounded w-1/2 py-2 text-white bg-blue-600 border-blue-700 mr-2" @click="summit">登录</button>
            <button class="border wounded w-1/2 py-2" @click="reset">清空</button>
          </div>
      </div>
      <div class="w-1/2">
        <img src="https://view.moezx.cc/images/2021/03/08/8197e148d9392bf851012f83d3a7f2ca.jpg" alt="" class="w-full h-full object-cover">
      </div>
    </div>
  </div>
</template>

<script>
import { login } from '@/api/admin/login/login.js'
export default {
name: "Login",
  data(){
  return{
    user:{
      username:'',
      password:''
    },
    password_error:false,
    username_error:false,
    error_username_message:'',
    error_password_message:'',

  }
  },
  methods:{
  summit(){
    if(this.user.username === ''){
      this.username_error = true
      this.error_username_message = "  输入的账号不能为空"
    }
    if(this.user.password === ''){
      this.password_error = true
      this.error_password_message = "  输入的密码不能为空"
    }
    // console.log(this.password_error && this.password_error);
    if(this.password_error===false && this.username_error===false){
      console.log(this.user);
      login(this.user).then(res=>{
        if(res.data!==null){
          const tokenStr = res.data.tokenHead + res.data.token
          window.sessionStorage['tokenStr']=tokenStr
          this.$router.push("/admin")
        }
      })
    }

  },
  reset(){
    this.user.username=''
    this.user.password=''
    this.username_error = false
    this.password_error = false
    this.error_username_message = ""
    this.error_password_message = ""
  }
  }
}
</script>

<style scoped>

</style>