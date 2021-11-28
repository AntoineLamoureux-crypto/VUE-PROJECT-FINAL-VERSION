<template>
  <div class="container">
    <div>
      <h2>Déposer votre CV</h2>
      <hr />
      <label
        >Fichier
        <input type="file" @change="handleFileUpload($event)" />
      </label>
      <br>
      <br />
      <button class="btn btn-outline-success" v-on:click="submitFile()">Submit</button>
    </div>
  </div>
</template>

<script>
import axios from "axios";

export default {
  name: "CVModalDeposit",
  data() {
    return {
      file: "",
    };
  },
  methods: {
    handleFileUpload(event) {
      this.file = event.target.files[0];
    },
    submitFile() {
      let formData = new FormData();
      let username = sessionStorage.getItem("userName");
      formData.append("document", this.file);
      axios.post(
        "http://localhost:9090/save/CV/" + username.substring(1, username.length -1),
        formData
      );
    },
  },
};
</script>

<style>
</style>