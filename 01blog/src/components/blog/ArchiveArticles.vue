<template>
  <mu-container>
    <mu-paper :z-depth="1">
      <mu-data-table :columns="columns" @sort-change="handleSortChange" :data="list">
          <template slot-scope="scope">
            <td @click="a">{{scope.row.title}}</td>
            <td class="is-center" @click="a">{{scope.row.createtime}}</td>
          </template>
      </mu-data-table>
    </mu-paper>
  </mu-container>
</template>

<script>
import {timefomat} from "@/util/timeformat.js"
export default {
  name: "ArchiveArticles",
  data(){
    return{
      sort: {
        name: '',
        order: 'asc'
      },
      columns: [
        { title: '标题', width: 400, name: 'title' },
        { title: '创建日期', name: 'createtime', width: 250, align: 'center'},
      ],
      list: [

      ]
    }
  },
  props:{
    cateblog:{}
  },
  methods:{
    handleSortChange ({name, order}) {
    },
    handledata(){
      for(let data of this.cateblog.blogs){
        console.log(data),
        this.list.push({
          title: data.title,
          summary: data.summary,
          createtime: timefomat(data.createTime)
        })
      }
    },
    a(){
      console.log('123')
    }
  },
  created() {
    this.handledata();
  }
}
</script>

<style scoped>

</style>