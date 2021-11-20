<template>
  <main class="container">
    <div class="card">
      <div class="card-body">
        <h5 class="card-title">{{ student.id }}</h5>
        <h5 class="card-title">{{ student.firstName }}</h5>
        <h5 class="card-title">{{ student.lastName }}</h5>
        <h5 class="card-title">{{ student.username }}</h5>
        <button class="btn btn-primary" @click="back()">Back</button>
      </div>
    </div>
  </main>
</template>

<script>
import router from '../router/index.js'

export default {
  name: "StudentModel",
  props: ["student"],
  
  methods: {
    back() {
      router.push({
        name: "Students"
      });
    },
  },
};
</script>

<style>
</style>