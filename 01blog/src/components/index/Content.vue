<template>
  <div class="container mx-auto">
    <div class="w-full flex items-center justify-center">
      <div class="w-3/4 flex h-full mt-4 border-double border
         rounded border-gray-800 hover:shadow-outline bg-blue-100">
          <artiles-component :artiles="blog"></artiles-component>
          <asp-jpeg :jpeg="blog.picture"></asp-jpeg>
      </div>
    </div>
  </div>
</template>

<script>
import ArtilesComponent from "./common/ArtilesComponent";
import AspJpeg from "./common/AspJpeg";
export default {
  name: "Content",
  components:{
    ArtilesComponent,AspJpeg
  },
  props:{
    blog:{}
  },
  data(){
    return{

    }
  }
}
</script>

<style scoped>

</style>