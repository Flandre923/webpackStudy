<template>
<div>
  <mu-container>
    <mu-paper :z-depth="4" class="my-5">
      <div class="p-4">
        <mu-button color="primary" small class="" @click="openAlertDialog2">新增</mu-button>
      </div>
      <mu-data-table stripe :columns="columns" :data="list">
        <template slot-scope="scope">
          <td>{{scope.row.animename}}</td>
          <td>{{scope.row.animeoriginname}}</td>
          <td>{{scope.row.animeimg}}</td>
          <td>{{scope.row.animeprogress}}</td>
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
    <mu-button slot="actions" flat color="primary" @click="delete_anime">删！</mu-button>
  </mu-dialog>


  <mu-dialog title="新增一个tag" width="600" max-width="80%" :esc-press-close="false" :overlay-close="false" :open.sync="openAlert2">
    <mu-form ref="form" :model="form" class="mu-demo-form" label-width="100">
      <mu-form-item prop="animename" label="剧名"  :rules="animenameules">
        <mu-text-field  prop="animename"  v-model="form.animename"></mu-text-field>
      </mu-form-item>
      <mu-form-item prop="animeoriginname" label="介绍"  :rules="animeoriginnameRules">
        <mu-text-field prop="animeoriginname" v-model="form.animeoriginname"></mu-text-field>
      </mu-form-item>
      <mu-form-item prop="animeimg" label="图像"  :rules="animeimgRules">
        <mu-text-field prop="animeimg" v-model="form.animeimg"></mu-text-field>
      </mu-form-item>
      <mu-form-item prop="animeprogress" label="进度"  :rules="animeprogressRules">
        <mu-text-field prop="animeprogress" v-model.number="form.animeprogress"></mu-text-field>
      </mu-form-item>
      <mu-form-item prop="animedesc" label="关于文章的简介"  :rules="animedescRules">
        <mu-text-field prop="animedesc" v-model="form.animedesc" multi-line :rows="4" full-width></mu-text-field><br/>
      </mu-form-item>
    </mu-form>
    <mu-button slot="actions" flat color="primary" @click="submit">确定</mu-button>
    <mu-button slot="actions" flat color="primary" @click="closeAlertDialog2">取消</mu-button>
  </mu-dialog>

</div>
</template>

<script>
import {request} from "../../../api/request";
import {get_animes} from "../../../api/anime/anime";

export default {
  name: "Anime",
  data () {
    return {
      animenameules: [
        { validate: (val) => !!val, message: '必须番剧名字'},
        { validate: (val) => val.length >= 1, message: '用户名长度大于1'}
      ],
      animeoriginnameRules: [
        { validate: (val) => !!val, message: '必须番剧瞄述'},
        { validate: (val) => val.length >= 1, message: '用户名长度大于1'}
      ],
      animeimgRules: [
        { validate: (val) => !!val, message: '必须番剧图片'},
        { validate: (val) => val.length >= 1, message: '用户名长度大于1'}
      ],
      animeprogressRules: [
        { validate: (val) => !!val, message: '必须填写番剧进度'},
      ],
      animedescRules: [
        { validate: (val) => !!val, message: '必须填写番剧进度'},
        { validate: (val) => val.length >= 10, message: '用户名长度大于10'}
      ],
      columns: [
        { title: '番剧', width: 200, name: 'animename'},
        { title: '介绍', width: 200, name: 'animeoriginname'},
        { title: '图像', width: 200, name: 'animeimg'},,
        { title: '进度', width: 200, name: 'animeprogress'},
        { title: '操作', name: 'options', width: 300, align: 'center' },
      ],
      form:{
        id:null,
        animename:'',
        animeoriginname:'',
        animedesc:'',
        animeimg:'',
        animeprogress:0,
      },
      list: [
      ],
      openAlert: false,
      openAlert2: false
    };
  },
  methods: {
    openAlertDialog (anime) {
      this.form.id = anime.id
      this.openAlert = true;
    },
    closeAlertDialog () {
      this.openAlert = false;
    },
    openAlertDialog2 (anime) {
      if(anime!==null){
        this.form.id = anime.id
        this.form.animename = anime.animename
        this.form.animeoriginname = anime.animeoriginname
        this.form.animeimg = anime.animeimg
        this.form.animeprogress = anime.animeprogress
        this.form.animedesc = anime.animedesc
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
              url:"/admin/anime",
              method:"post",
              data:{
                animename:this.form.animename,
                animeoriginname:this.form.animeoriginname,
                animeimg:this.form.animeimg,
                animeprogress:this.form.animeprogress,
                animedesc:this.form.animedesc
              }
            }).then(res=>{
              this.shuffle_anime()
              this.form.id=null
            })
          }else{
            request({
              url:"/admin/anime",
              method:"post",
              data:{
                id:this.form.id,
                animename:this.form.animename,
                animeoriginname:this.form.animeoriginname,
                animeimg:this.form.animeimg,
                animeprogress:this.form.animeprogress,
                animedesc:this.form.animedesc
              }
            }).then(res => {
              this.shuffle_anime()
              this.form.id=null
            })
          }
          this.openAlert2=false
        }
      });
    },
    delete_anime(){
      request({
        url:"/admin/delete/anime",
        method:'get',
        params:{
          id:this.form.id
        }
      }).then(res=>{
        this.shuffle_anime()
        this.form.id=null;
      })
      this.openAlert=false
    },
    shuffle_anime(){
      get_animes().then(res=>{
        this.list=res.data
      })
    }

  },
  created() {
    this.shuffle_anime()
  }
}
</script>

<style scoped>

</style>