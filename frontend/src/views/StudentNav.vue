<template>
  <nav class="navbar navbar-expand-md navbar-dark bg-dark mb-4">
    <div class="container-fluid">
      <ul></ul>

      <div>
        <ul class="navbar-nav me-auto mb-2 mb-md-0">
          <li class="nav-item">
            <router-link to="/CVList" class="nav-link"
              >Les nouvelles offres de stages</router-link
            >
          </li>
          <li class="nav-item">
            <router-link to="/CVList" class="nav-link"
              >Vos applications de stages</router-link
            >
          </li>
          <li class="nav-item">
            <router-link to="/" class="nav-link" @click="resetUserCreds()"
              >Logout</router-link
            >
          </li>
        </ul>
      </div>
    </div>
  </nav>
</template>

<script>
export default {
  name: "StudentNav",
  methods: {
    resetUserCreds() {
      sessionStorage.removeItem("userName");
      sessionStorage.removeItem("user");
    },
  },
};
</script>

<style>
</style>