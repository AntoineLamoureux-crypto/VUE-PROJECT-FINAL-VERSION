<template>
  <main>
    <h6>
     {{this.cv.pdfdocument.name}}
    </h6>
  </main>
</template>

<script>
export default {
  name: "CV",
  props: ["cv"],
};
</script>

<style>
</style>