<template>
  <main>
    <div class="container">
      <div class="col-md-12">
        <div class="card">
          <div class="card-body">
            <div class="container">
              <div class="jumbotron">
                <div class="row w-100">
                  <div class="col-md-12">
                    <div class="card border-info mx-sm-1 p-3">
                      <div
                        class="card border-info shadow text-info p-3 my-card"
                      >
                        <span
                          class="fas fa-user-graduate"
                          aria-hidden="true"
                        ></span>
                      </div>
                      <div class="text-info text-center mt-3">
                        <h4>Student</h4>
                      </div>
                      <div class="col-md-12 text-center">
                        <button
                          type="button"
                          class="btn btn-outline-info text-center"
                          @click="$router.push('signUpStudent')"
                        >
                          Sign Up
                        </button>
                      </div>
                    </div>
                  </div>
                  <div class="col-md-12 mt-5">
                    <div class="card border-success mx-sm-1 p-3">
                      <div
                        class="
                          card
                          border-success
                          shadow
                          text-success
                          p-3
                          my-card
                        "
                      >
                        <span class="fa fa-eye" aria-hidden="true"></span>
                      </div>
                      <div class="text-success text-center mt-3">
                        <h4>Monitor</h4>
                      </div>
                      <div class="col-md-12 text-center">
                        <button
                          type="button"
                          class="btn btn-outline-success text-center"
                          @click="$router.push('signUpMonitor')"
                        >
                          Sign Up
                        </button>
                      </div>
                    </div>
                  </div>
                  <div class="col-md-12 mt-5">
                    <div class="card border-danger mx-sm-1 p-3">
                      <div
                        class="
                          card
                          border-danger
                          shadow
                          text-danger
                          p-3
                          my-card
                        "
                      >
                        <span class="fas fa-user-tie" aria-hidden="true"></span>
                      </div>
                      <div class="text-danger text-center mt-3">
                        <h4>Supervisor</h4>
                      </div>
                      <div class="col-md-12 text-center">
                        <button
                          type="button"
                          class="btn btn-outline-danger text-center"
                          @click="$router.push('signUpSupervisor')"
                        >
                          Sign Up
                        </button>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </main>
</template>

<script>
export default {
  name: "Register"
};
</script>

<style>
.my-card {
  position: absolute;
  left: 40%;
  top: -20px;
  border-radius: 50%;
}
.btn {
  position: relative;
  width: 100px;
  height: 40px;
  text-align: center;
}
</style>