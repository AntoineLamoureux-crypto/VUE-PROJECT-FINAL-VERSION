<template>
  <main>
    <ul v-for="cv in cvs" :key="cv.id">
      <CV :cv='cv' />
    </ul>
  </main>
</template>

<script>
let username = sessionStorage.getItem("userName");
import CV from "./CV.vue"

export default {
  components: { CV },
  name: "CVList",
  data() {
    return {
      cvs: [],
    };
  },
  beforeMount() {
    fetch(
      "http://localhost:9090/getAll/student/CVS/" +
        username.substring(1, username.length - 1),
      {
        method: "GET",
        headers: {
          "Content-type": "application/json",
        },
      }
    )
      .then((response) => response.json())
      .then((data) => (this.cvs = data));
  },
};
</script>

<style>
</style>