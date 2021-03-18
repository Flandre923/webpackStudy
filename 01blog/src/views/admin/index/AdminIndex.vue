<template>
  <div>
    <admin-home-topitem></admin-home-topitem>
    <router-view></router-view>
    <adminfooter></adminfooter>
  </div>
</template>

<script>
import AdminHomeTopitem from "@/components/admin/home/AdminHomeTopitem";
import Adminfooter from "@/components/admin/home/Adminfooter";
export default {
name: "AdminIndex",
  components: {Adminfooter, AdminHomeTopitem},
  data () {
  return{

  }
  }
}
</script>

<style scoped>

</style>