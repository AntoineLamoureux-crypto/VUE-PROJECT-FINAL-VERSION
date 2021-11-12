<template>
  <main class="form-signin">
    <form @submit.prevent="onSubmit">
      <h1 class="h3  mb-3">Sign Up Monitor</h1>
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
          v-model="entrepriseName"
          type="text"
          class="form-control mb-3"
          placeholder="Nom d'entreprise"
          required
        />
        <label>Nom d'entreprise</label>
      </div>
      <div class="form-floating">
        <input
          v-model="jobTitle"
          type="text"
          class="form-control mb-3"
          placeholder="Nom de votre emploie"
          required
        />
        <label>Nom de votre emploie</label>
      </div>
      <button class="w-100 btn btn-lg btn-success btn-outline-success" style="height:50px; color:white" type="submit">
        Register
      </button>
      <p class="mt-5 mb-3 text-muted">&copy; Antoine Lamoureux</p>
    </form>
  </main>
</template>

<script>
export default {
  name: "Monitor register",
  data() {
    return {
      username: "",
      password: "",
      firstName: "",
      lastName: "",
      entrepriseName: "",
      jobTitle: ""
    };
  },
  methods: {
    onSubmit(e) {
      e.preventDefault();
      const newMonitor = {
        username: this.username,
        password: this.password,
        firstName: this.firstName,
        lastName: this.lastName,
        entrepriseName: this.entrepriseName,
        jobTitle: this.jobTitle
      }
      if (!newMonitor.username.startsWith('M')) {
        this.errorMessage = "Monitor username must start with 'M' "
      } else {
      fetch("http://localhost:9898/api/signUp/monitor", {
        method: 'POST', 
        headers: {'Content-type' : 'application/json'}, 
        body: JSON.stringify(newMonitor)})
      }
    },
  },
};
</script>

<style>
</style>