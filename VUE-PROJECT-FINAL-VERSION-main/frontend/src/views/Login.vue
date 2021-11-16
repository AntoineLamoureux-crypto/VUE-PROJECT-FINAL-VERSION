<template>
  <main class="form-signin">
    <form @submit.prevent="onSubmit">
      <h1 class="h3 mb-3 fw-normal">Veuillez vous connecter</h1>
      <p style="color: red; text: bold">{{ errorMessage }}</p>
      <div class="form-floating">
        <input
          v-model="username"
          type="text"
          class="form-control"
          placeholder="Username"
          required
          @focus="resetErrorMessage()"
        />
        <label for="floatingInput">Nom d'utilisateur</label>
      </div>
      <div class="form-floating">
        <input
          v-model="password"
          type="password"
          class="form-control"
          placeholder="Password"
          required
        />
        <label for="floatingPassword">Mot de passe</label>
      </div>

      <button
        class="w-100 btn btn-lg btn-primary"
        style="height: 50px; color: white"
        type="submit"
      >
        Sign in
      </button>
      <p class="mt-5 mb-3 text-muted">&copy; Antoine Lamoureux</p>
    </form>
  </main>
</template>

<script>
import router from '../router/index.js'

export default {
  name: "Login",
  data() {
    return {
      username: "",
      password: "",
      errorMessage: "",
    };
  },
  methods: {
    onSubmit(e) {
      e.preventDefault();
      const loginInfo = {
        username: this.username,
        password: this.password,
      };


      const currentUser = {
        username: this.username,
        password: this.password,
      };

      let userType = "";

      if (loginInfo.username.startsWith('E')) {
        this.userType = "student";
      }
      if (loginInfo.username.startsWith('S')) {
        this.userType = "supervisor";
      }
      if (loginInfo.username.startsWith('M')) {
        this.userType = "monitor";
      }
      if (currentUser.username.startsWith('I')) {
        this.userType = "manager";
      }
      else 
        this.userType = "NONE"
     

      if (userType == "NONE") {
        this.errorMessage = "Wrong username, please try again";
      } else {
        fetch(
          "http://localhost:9898/api/login/" +
            userType +
            "/" +
            loginInfo.username +
            "/" +
            loginInfo.password,
          {
            method: "GET",
            headers: { "Content-type": "application/json" },
          }
        )
          .then((response) => response.json())
          .then((data) => (this.currentUser = data));
          router.push('students')
          userType = ""
          console.log(currentUser)
      }
    },
    resetErrorMessage() {
      this.errorMessage = "";
    },
  },
};
</script>

<style>
.form-signin {
  width: 100%;
  max-width: 330px;
  padding: 15px;
  margin: auto;
}

.form-signin .checkbox {
  font-weight: 400;
}

.form-signin .form-floating:focus-within {
  z-index: 2;
}

.form-signin input[type="email"] {
  margin-bottom: -1px;
  border-bottom-right-radius: 0;
  border-bottom-left-radius: 0;
}

.form-signin input[type="password"] {
  margin-bottom: 10px;
  border-top-left-radius: 0;
  border-top-right-radius: 0;
}
</style>