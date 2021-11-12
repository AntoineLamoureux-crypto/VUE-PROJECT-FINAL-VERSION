<template>
  <div class="container">
    <h1 class="text-center">Student List</h1>
    <table class="table table-striped">
      <thead>
        <th>Student ID</th>
        <th>Student Fist Name</th>
        <th>Student Last Name</th>
        <th>Student Department</th>
      </thead>
      <tbody>
        <tr v-for="student in students" v-bind:key="student.id">
          <td>{{ student.id }}</td>
          <td>{{ student.firstName }}</td>
          <td>{{ student.lastName }}</td>
          <td>{{ student.department }}</td>
        </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
import UserService from '../services/UserService'

export default {
    name: 'Students',
    data() {
        return {
            students : []
        }
    },
    methods: {
        getStudents() {
            UserService.getStudents().then((response) => {
                this.students = response.data;
            });
        }
    },
    created() {
        this.getStudents()
    }
}
</script>

<style>
</style>