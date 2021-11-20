import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'
import Login from '../views/Login.vue'
import Register from '../views/Register.vue'
import StudentRegister from '../views/StudentRegister.vue'
import MonitorRegister from '../views/MonitorRegister.vue'
import SupervisorRegister from '../views/SupervisorRegister.vue'
import Students from '../components/Students.vue'
import StudentModel from '../components/StudentModel.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home,
    props: true
  },
  {
    path: '/login',
    name: 'Login',
    component: Login,
    props: true
  },
  {
    path: '/students',
    name: 'Students',
    component: Students,
    props: true
  },
  {
    path: '/studentDetails',
    name: 'StudentModel',
    component: StudentModel,
    props: true
  },
  {
    path: '/register',
    name: 'Register',
    component: Register,
    props: true
  },
  {
    path: '/signUpStudent',
    name: 'StudentRegister',
    component: StudentRegister,
    props: true
  },
  {
    path: '/signUpMonitor',
    name: 'MonitorRegister',
    component: MonitorRegister,
    props: true
  },
  {
    path: '/signUpSupervisor',
    name: 'SupervisorRegister',
    component: SupervisorRegister,
    props: true
  },
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
