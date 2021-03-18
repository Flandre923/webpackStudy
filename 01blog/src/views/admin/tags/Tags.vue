<template>
<div>
  <mu-container>
    <mu-paper :z-depth="4" class="my-5">
      <div class="p-4">
        <mu-button color="primary" small class="" @click="openAlertDialog2">新增</mu-button>
      </div>
      <mu-data-table stripe :columns="columns" :data="list">
        <template slot-scope="scope">
          <td>{{scope.row.name}}</td>
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
    <mu-button slot="actions" flat color="primary" @click="delete_tag">删！</mu-button>
  </mu-dialog>


  <mu-dialog title="新增一个tag" width="600" max-width="80%" :esc-press-close="false" :overlay-close="false" :open.sync="openAlert2">
    <mu-form ref="form" :model="form" class="mu-demo-form">
      <mu-form-item label="tag"  prop="tag" :rules="tagRules">
        <mu-text-field v-model="form.tag" prop="tag"></mu-text-field>
      </mu-form-item>
    </mu-form>
    <mu-button slot="actions" flat color="primary" @click="add_tag_or_edit_tag">确定</mu-button>
    <mu-button slot="actions" flat color="primary" @click="closeAlertDialog2()">取消</mu-button>
  </mu-dialog>


</div>
</template>

<script>
import {get_tags} from "@/api/blog/blog.js"
import {request} from "@/api/request";

export default {
  name: "Tags",
  data () {
    return {
      tagRules: [
        { validate: (val) => !!val, message: '必须填写用户名'},
        { validate: (val) => val.length >= 1, message: '用户名长度大于1'}
      ],
      columns: [
        { title: '名字', width: 500, name: 'name'},
        { title: '操作', name: 'options', width: 500, align: 'center' },
      ],
      form:{
        tag:'',
        id: 0 ,
      },
      list: [
      ],
      openAlert: false,
      openAlert2: false
    };
  },
  methods: {
    // 对话框1 打开
    openAlertDialog (tag) {
      this.form.id = tag.id
      this.openAlert = true;
    },
    // 对话框1 管理
    closeAlertDialog () {
      this.openAlert = false;
    },
    openAlertDialog2 (tag) {
      if(tag!==null){
        this.form.tag = tag.name
        this.form.id  = tag.id
      }
      this.openAlert2 = true;
    },
    closeAlertDialog2 () {
      this.openAlert2 = false;
    },
    add_tag_or_edit_tag(){
      this.$refs.form.validate().then((result) => {
        if(result){
          if(this.form.id!=0){
            request({
              url:"/admin/tags",
              method:'post',
              data:{
                name:this.form.tag,
                id:this.form.id
              }
            }).then(res=>{
              this.shuffle_tag()
              console.log(res)
            })
          }else {
            request({
              url:"/admin/tags",
              method:'post',
              data:{
                name:this.form.tag
              }
            }).then(res=>{
              // 刷新列表
              this.shuffle_tag()
              console.log(res)
            })
          }
          //关闭对话框
          this.openAlert2=false
        }
      });
    },
    delete_tag(){
      request({
        url:"/admin/delete/tag",
        method:'get',
        params:{
          id:this.form.id
        }
      }).then(res=>{
        // 刷新列表
        this.shuffle_tag()
        console.log(res)
      })
      //对话关闭
      this.openAlert = false

    },
    shuffle_tag(){
      get_tags().then(res=>{
        this.list = res.data;
      })
    },
  },
  created() {
    this.shuffle_tag()
  }
}
</script>

<style scoped>

</style>