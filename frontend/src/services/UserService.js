import axios from 'axios'

const GET_ALL_STUDENT_API_URL = 'http://localhost:9090/getAll/students'

class UserService {
    getStudents() {
        return axios.get(GET_ALL_STUDENT_API_URL) 
    }
}

export default new UserService()