<template>
  <div class="container">
    <h1 class="text-center">Student List</h1>
    <table class="table table-striped">
      <thead>
        <th>Student ID</th>
        <th>Student Fist Name</th>
        <th>Student Last Name</th>
        <th>Student Department</th>
        <th>View details</th>
      </thead>
      <tbody>
        <tr v-for="student in students" v-bind:key="student.id">
          <td>{{ student.id }}</td>
          <td>{{ student.firstName }}</td>
          <td>{{ student.lastName }}</td>
          <td>{{ student.department }}</td>
          <td>
            <button
              type="button"
              class="btn btn-primary"
              @click="detailsClicked(student.id)"
            >
              More
            </button>
          </td>
        </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
import UserService from "../services/UserService";
import router from "../router/index.js"

export default {
  name: "Students",
  data() {
    return {
      students: [],
    };
  },
  methods: {
    getStudents() {
      UserService.getStudents().then((response) => {
        this.students = response.data;
      });
    },
    detailsClicked(studentId) {
      console.log(studentId)
      router.push({
        name: "StudentModel",
        params: {
          currentStudentId: studentId,
        },
      });
    },
  },
  created() {
    this.getStudents();
  },
};
</script>

<style>
</style>