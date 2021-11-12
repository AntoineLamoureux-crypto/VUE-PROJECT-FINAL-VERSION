import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'
import Login from '../views/Login.vue'
import Register from '../views/Register.vue'
import StudentRegister from '../views/StudentRegister.vue'
import MonitorRegister from '../views/MonitorRegister.vue'
import SupervisorRegister from '../views/SupervisorRegister.vue'
import Students from '../components/Students.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },
  {
    path: '/login',
    name: 'Login',
    component: Login
  },
  {
    path: '/students',
    name: 'Students',
    component: Students
  },
  {
    path: '/register',
    name: 'Register',
    component: Register
  },
  {
    path: '/signUpStudent',
    name: 'Student register',
    component: StudentRegister
  },
  {
    path: '/signUpMonitor',
    name: 'Monitor register',
    component: MonitorRegister
  },
  {
    path: '/signUpSupervisor',
    name: 'Supervisor register',
    component: SupervisorRegister
  },
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
