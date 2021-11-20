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
import router from "../router/index.js";

export default {
  name: "Login",
  data() {
    return {
      username: "",
      password: "",
      errorMessage: "",
      userType: "",
      currentUser : {
        username: "",
        password: "",
        id: ""
      }
    };
  },
  methods: {
    onSubmit(e) {
      e.preventDefault();
      let loginInfo = {
        username: this.username,
        password: this.password,
      };


      if (loginInfo.username.startsWith("E") || loginInfo.username.startsWith('e')) {
        this.userType = "student";
      }
      if (loginInfo.username.startsWith("S") || loginInfo.username.startsWith('s')) {
        this.userType = "supervisor";
      }
      if (loginInfo.username.startsWith("M") || loginInfo.username.startsWith('m')) {
        this.userType = "monitor";
      }
      if (loginInfo.username.startsWith("G") || loginInfo.username.startsWith('g')) {
        this.userType = "manager";
      } else if (this.userType === ""){
        this.userType = "NONE";
      }

      console.log('User type with this : -> ' + this.userType)

      if (this.userType == "NONE") {
        this.errorMessage = "User as to start with [ 'E' , 'S', 'M', 'G' ]";
      } else {
        fetch(
          "http://localhost:9898/api/login/" +
            this.userType +
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


        console.log("Current user with this prop : -> " + this.currentUser.username)
          
        if (this.currentUser.id == null) {
          this.errorMessage = "Username does not exists";
        } else {
          router.push({
            name: "StudentModel",
            params: {
              student: loginInfo,
            },
          });
        }
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