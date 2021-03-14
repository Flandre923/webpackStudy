<template>
  <nav>
    <ul class="flex items-center">
      <li class="text-xl mr-16 rounded font-medium text-pink-600 cursor-pointer
      p-3 border-b-4 hover:border-yellow-800"
          @click="goTo()">
        <slot></slot>
      </li>
    </ul>
  </nav>
</template>

<script>
export default {
  name: "Item",
  props:{
    url:{}
  },
  methods:{
    goTo() {
      this.$router.push(this.url)
    }
  }
}
</script>

<style scoped>

</style>