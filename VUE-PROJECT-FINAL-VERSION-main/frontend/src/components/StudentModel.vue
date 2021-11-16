<template>
  <main class="container">
    <div class="card">
      <div class="card-body">
        <h5 class="card-title">{{ currentStudentId }}</h5>
        <button class="btn btn-primary" @click="back()">Back</button>
      </div>
    </div>
  </main>
</template>

<script>
import router from '../router/index.js'

export default {
  name: "StudentModel",
  props: ["currentStudentId"],
  
  methods: {
    back() {
      router.push({
        name: "Students"
      });
    },
  },
  created() {
    // Get the student details
  },
};
</script>

<style>
</style>