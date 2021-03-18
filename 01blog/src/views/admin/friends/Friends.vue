<template>
<div>
  <mu-container>
    <mu-paper :z-depth="4" class="my-5">
      <div class="p-4">
        <mu-button color="primary" small class="" @click="openAlertDialog2">新增</mu-button>
      </div>
      <mu-data-table stripe :columns="columns" :data="list">
        <template slot-scope="scope">
          <td>{{scope.row.friendname}}</td>
          <td>{{scope.row.frienddesc}}</td>
          <td>{{scope.row.friendurl}}</td>
          <td>{{scope.row.friendavatar}}</td>
          <td class="is-right flex p-4 space-x-2 items-center justify-center" >
            <mu-button color="primary" small @click="openAlertDialog2(scope.row)">编辑</mu-button>
            <mu-button color="secondary" small @click="openAlertDialog(scope.row)">删除</mu-button>
          </td>
        </template>
      </mu-data-table>
    </mu-paper>
  </mu-container>

  <mu-dialog title="是否确认要删除？" width="600" max-width="80%" :esc-press-close="false" :overlay-close="false" :open.sync="openAlert">
    是否确认删除，此操作不可逆！！
    <mu-button slot="actions" flat color="primary" @click="closeAlertDialog">不删除</mu-button>
    <mu-button slot="actions" flat color="primary" @click="delete_friend">删！</mu-button>
  </mu-dialog>


  <mu-dialog title="新增/修改一个友链" width="600" max-width="80%" :esc-press-close="false" :overlay-close="false" :open.sync="openAlert2">
    <mu-form ref="form" :model="form" label-width="100">
      <mu-form-item   label="名字" prop="friendname" :rules="friendnameRules">
        <mu-text-field v-model="form.friendname" prop="friendname"></mu-text-field>
      </mu-form-item>
      <mu-form-item label="介绍" prop="frienddesc" :rules="frienddescRules">
        <mu-text-field v-model="form.frienddesc" prop="frienddesc" ></mu-text-field>
      </mu-form-item>
      <mu-form-item label="链接" prop="friendurl" :rules="friendurlRules">
        <mu-text-field v-model="form.friendurl" prop="friendurl"></mu-text-field>
      </mu-form-item>
      <mu-form-item  label="头像" prop="friendavatar" :rules="friendavatarRules">
        <mu-text-field v-model="form.friendavatar" prop="friendavatar"></mu-text-field>
      </mu-form-item>
    </mu-form>
    <mu-button slot="actions" flat color="primary" @click="submit">确定</mu-button>
    <mu-button slot="actions" flat color="primary" @click="closeAlertDialog2">取消</mu-button>
  </mu-dialog>

</div>
</template>

<script>
import {request} from "../../../api/request";
import {get_friends} from "../../../api/friend/friend";

export default {
name: "Friends",
  data () {
    return {
      friendnameRules: [
        { validate: (val) => !!val, message: '必须填写友链名'},
        { validate: (val) => val.length >= 1, message: '用户名长度大于3'}
      ],
      frienddescRules: [
        { validate: (val) => !!val, message: '必须填写描述'},
        { validate: (val) => val.length >= 1, message: '用户名长度大于3'}
      ],
      friendurlRules: [
        { validate: (val) => !!val, message: '必须填写连接'},
        { validate: (val) => val.length >= 1, message: '用户名长度大于3'}
      ],
      friendavatarRules: [
        { validate: (val) => !!val, message: '必须填写头像'},
        { validate: (val) => val.length >= 1, message: '用户名长度大于3'}
      ],
      columns: [
        { title: '友链名', width: 200, name: 'friendname'},
        { title: '友链简介', width: 200, name: 'frienddesc'},
        { title: '友链地址', width: 200, name: 'friendurl'},
        { title: '头像', width: 200, name: 'friendavatar'},
        { title: '操作', name: 'options', width: 300, align: 'center' },
      ],
      form:{
        id:null,
        friendname:'',
        frienddesc:'',
        friendurl:'',
        friendavatar:'',
      },
      list: [
      ],
      openAlert: false,
      openAlert2: false
    };
  },
  methods: {
    openAlertDialog (friend) {
      this.form.id = friend.id
      this.openAlert = true;
    },
    closeAlertDialog () {
      this.openAlert = false;
    },
    openAlertDialog2 (friend) {
      if(friend!==null){
        this.form.id = friend.id
        this.form.friendname = friend.friendname
        this.form.frienddesc = friend.frienddesc
        this.form.friendurl = friend.friendurl
        this.form.friendavatar = friend.friendavatar
      }
      this.openAlert2 = true;
    },
    closeAlertDialog2 () {
      this.openAlert2 = false;
    },
    submit () {
      this.$refs.form.validate().then((result) => {
       if(result){
          if(this.form.id===null){
            request({
              url:"/admin/friends",
              method:"post",
              data:{
                friendname:this.form.friendname,
                frienddesc:this.form.frienddesc,
                friendurl:this.form.friendurl,
                friendavatar:this.form.friendavatar
              }
            }).then(res=>{
              this.shuffle_friends_list()
              this.form.id=null
            })
          }else{
            request({
              url:"/admin/friends",
              method:"post",
              data:{
                id:this.form.id,
                friendname:this.form.friendname,
                frienddesc:this.form.frienddesc,
                friendurl:this.form.friendurl,
                friendavatar:this.form.friendavatar
              }
            }).then(res => {
              this.shuffle_friends_list()
              this.form.id=null
            })
          }
         this.openAlert2=false
       }
      });
    },
    delete_friend(){
      request({
        url:"/admin/delete/friend",
        method:'get',
        params:{
          id:this.form.id
        }
      }).then(res=>{
        this.shuffle_friends_list()
        this.form.id=null;
      })
      this.openAlert=false
    },
    shuffle_friends_list(){
      get_friends().then(res=>{
        this.list=res.data
      })
    }

  },
  created() {
    this.shuffle_friends_list()
  }
}
</script>

<style scoped>

</style>