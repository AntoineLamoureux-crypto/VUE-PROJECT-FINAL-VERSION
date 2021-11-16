<template>
  <main class="form-signin">
    <form @submit.prevent="onSubmit">
      <h1 class="h3 mb-3">Sign Up Student</h1>
       <p style="color:red; ">{{ errorMessage }}</p>
      <div class="form-floating">
        <input
          v-model="username"
          type="text"
          class="form-control"
          placeholder="Username"
          required
          @focus="resetErrorMessage()"
        />
        <small>Le nom d'utilisateur doit commencer par 'E'</small>
        <label>Nom d'utilisateur</label>
      </div>
      <div class="form-floating">
        <input
          v-model="password"
          type="password"
          class="form-control"
          placeholder="Password"
          required
        />
        <label>Mot de passe</label>
      </div>
      <div class="form-floating">
        <input
          v-model="firstName"
          type="text"
          class="form-control"
          placeholder="Prénom"
          required
        />
        <label>Prénom</label>
      </div>
      <div class="form-floating">
        <input
          v-model="lastName"
          type="text"
          class="form-control"
          placeholder="Nom"
          required
        />
        <label>Nom</label>
      </div>
      <div class="form-floating">
        <input
          v-model="department"
          type="text"
          class="form-control mb-3"
          placeholder="Departement"
          required
        />
        <label>Departement</label>
      </div>
      <button class="w-100 btn btn-lg btn-info btn-outline-info" style="height: 50px; color:white" type="submit">
        Register
      </button>
      <p class="mt-5 mb-3 text-muted">&copy; Antoine Lamoureux</p>
    </form>
  </main>
</template>

<script>

import router from '../router/index.js'

export default {
  name: "StudentRegister",
  data() {
    return {
      username: "",
      password: "",
      firstName: "",
      lastName: "",
      department: "",
      errorMessage : ""
    };
  },
  methods: {
    onSubmit(e) {
      e.preventDefault();
      const newStudent = {
        username: this.username,
        password: this.password,
        firstName: this.firstName,
        lastName: this.lastName,
        department: this.department
      }
      
      if (!newStudent.username.startsWith('E')) {
        console.log(newStudent.username)
        this.errorMessage = "Commencer votre username par 'E' "
      } else if (newStudent.username.startsWith('E')) {
      fetch("http://localhost:9898/api/signUp/student", {
        method: 'POST', 
        headers: {'Content-type' : 'application/json'}, 
        body: JSON.stringify(newStudent)})
        router.push('students')
      }
      else {
        this.errorMessage = "Error"
      }
    },
    resetErrorMessage() {
      this.errorMessage = ""
    }
  },
};
</script>

<style>
</style>