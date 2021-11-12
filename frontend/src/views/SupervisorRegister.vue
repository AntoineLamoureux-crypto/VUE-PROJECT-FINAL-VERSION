<template>
  <main class="form-signin">
    <form @submit.prevent="onSubmit">
      <h1 class="h3 mb-3">Sign Up Supervisor</h1>
      <div class="form-floating">
        <input
          v-model="username"
          type="text"
          class="form-control"
          placeholder="Username"
          required
        />
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
      <button
        class="w-100 btn btn-lg btn-danger btn-outline-danger"
        style="height: 50px; color: white"
        type="submit"
      >
        Register
      </button>
      <p class="mt-5 mb-3 text-muted">&copy; Antoine Lamoureux</p>
    </form>
  </main>
</template>

<script>

import router from '../router/index.js'

export default {
  name: "Supervisor register",
  data() {
    return {
      username: "",
      password: "",
      firstName: "",
      lastName: "",
      department: "",
    };
  },
  methods: {
    onSubmit(e) {
      e.preventDefault();
      const newSupervisor = {
        username: this.username,
        password: this.password,
        firstName: this.firstName,
        lastName: this.lastName,
        department: this.department
      };
      if (!newSupervisor.username.startsWith("S")) {
        this.errorMessage = "Supervisor username must start with 'S' ";
      } else {
        fetch("http://localhost:9898/api/signUp/supervisor", {
          method: "POST",
          headers: { "Content-type": "application/json" },
          body: JSON.stringify(newSupervisor),
        }).then(response => response.json())
        .then(data => (this.currentSupervisor = data.currentSupervisor));
        router.push('home')
      }
    },
  },
};
</script>

<style>
</style>