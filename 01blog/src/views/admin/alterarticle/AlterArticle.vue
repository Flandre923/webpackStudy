<template>
<div>
  <mu-container>
    <mu-paper :z-depth="4" class="my-5">
      <mu-data-table stripe :columns="columns" :data="list">
        <template slot="expand" slot-scope="prop">
          <div style="padding: 24px;" >{{prop.row.summary}}</div>
        </template>
        <template slot-scope="scope">
          <td>{{scope.row.title}}</td>
          <td class="is-right">{{scope.row.number}}</td>
          <td class="is-right">{{scope.row.readTime}}</td>
          <td class="is-right flex p-4 space-x-2 items-center justify-center" >
            <router-link :to="{name: 'EditArticle' , params:{blogId: scope.row.id}}" >
              <mu-button color="primary" small>编辑</mu-button>
            </router-link>
            <mu-button color="secondary" small @click="openAlertDialog(scope.row.id)">删除</mu-button>
          </td>
        </template>
      </mu-data-table>

      <mu-flex justify-content="center" class="py-5">
        <mu-pagination :total="total" :current.sync="current" :page-size="page_size" @change="page_change"></mu-pagination>
      </mu-flex>
    </mu-paper>
  </mu-container>


  <mu-dialog title="是否确认要删除？" width="600" max-width="80%" :esc-press-close="false" :overlay-close="false" :open.sync="openAlert">
    是否确认删除，此操作不可逆！！
    <mu-button slot="actions" flat color="primary" @click="closeAlertDialog">不删除</mu-button>
    <mu-button slot="actions" flat color="primary" @click="deleteblog">删！</mu-button>
  </mu-dialog>

</div>
</template>

<script>
import {request} from "../../../api/request";
import {getBlogs} from "../../../api/home/home";

export default {
  name: "AlterArticle",
  data () {
    return {
      current:1,
      page_size:5,
      total:10,
      columns: [
        { title: '标题', width: 400, name: 'title'},
        { title: '字数', name: 'number', width: 200, align: 'center',},
        { title: '阅读时间', name: 'readTime', width: 200, align: 'center' },
        { title: '操作', name: 'options', width: 300, align: 'center' },
      ],
      list: [
        {
          title: 'Frozen Yogurt',
          summary: 159,
          update: 6.0,
        },
      ],
      blogs:null,
      id:null,
      openAlert: false
    };
  },
  methods: {
    //
    page_change(){
      request({
        url:"/admin/blog",
        method:'get',
        params:{
          current:this.current,
          size:this.page_size,
        }
      }).then(res=>{
        let arr = []
        for(let blog of res.data.data){
          arr.push({
            title:blog.title,
            summary:blog.summary,
            id:blog.id,
            readTime:blog.readTime,
            number:blog.number,
          })
        }
        this.list = arr;
        this.total = res.data.total
        console.log(res)
      })
    },
    openAlertDialog (id) {
      this.id=id
      this.openAlert = true;
    },
    closeAlertDialog () {
      this.openAlert = false;
      this.id=null;
    },
    deleteblog(){
      request({
        url:"/admin/blog/delete",
        method:'get',
        params:{
          id:this.id
        }
      }).then(res=>{
        this.openAlert = false
        this.shuffle_blogs()
        this.id=null;
      })
    },
    shuffle_blogs(){
      request({
        url:"/admin/blog",
        method:'get',
        params:{
          current:this.current,
          size:this.page_size,
        }
      }).then(res=>{
        let arr = []
        for(let blog of res.data.data){
          arr.push({
            title:blog.title,
            summary:blog.summary,
            id:blog.id,
            readTime:blog.readTime,
            number:blog.number,
          })
        }
        this.list = arr;
        this.total = res.data.total
        console.log(res)
      })
    }
  },
  created() {
   this.shuffle_blogs();
  }
}
</script>

<style scoped>

</style>