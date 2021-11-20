package net.java.springboot.service;

import net.java.springboot.model.InternshipManager;
import net.java.springboot.model.Monitor;
import net.java.springboot.model.Student;
import net.java.springboot.model.Supervisor;
import net.java.springboot.repository.InternshipManagerRepository;
import net.java.springboot.repository.MonitorRepository;
import net.java.springboot.repository.StudentRepository;
import net.java.springboot.repository.SupervisorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BackendService {

    @Autowired
    private final StudentRepository studentRepository;

    @Autowired
    private final MonitorRepository monitorRepository;

    @Autowired
    private final SupervisorRepository supervisorRepository;

    @Autowired
    private final InternshipManagerRepository internshipManagerRepository;

    private final String NONE = "NONE";

    private final String STUDENT = "STUDENT";
    private final String MONITOR = "MONITOR";
    private final String SUPERVISOR = "SUPERVISOR";
    private final String MANAGER = "MANAGER";

    BackendService(StudentRepository studentRepository,
                   MonitorRepository monitorRepository,
                   SupervisorRepository supervisorRepository,
                   InternshipManagerRepository internshipManagerRepository) {
        this.studentRepository = studentRepository;
        this.monitorRepository = monitorRepository;
        this.supervisorRepository = supervisorRepository;
        this.internshipManagerRepository = internshipManagerRepository;
    }

    public List<Student> getAllStudents() {
        List<Student> students = studentRepository.findAll();
        return students.isEmpty() ? null : students;
    }

    public Student getStudentById(int studentId) {
        Student student = studentRepository.getById(studentId);
        return student;
    }

    public Student signUp(Student student) {
        return studentRepository.save(student);
    }

    public Monitor signUp(Monitor monitor) {
        return monitorRepository.save(monitor);
    }

    public Supervisor signUp(Supervisor supervisor) {
        return supervisorRepository.save(supervisor);
    }

    public Student loginStudent(String username, String password) {
        return studentRepository.findByUsernameAndPassword(username, password);
    }

    public Boolean isLoginExist(String username, String password) {
        boolean res = false;
        if (studentRepository.findByUsernameAndPassword(username, password) != null) {
            res = true;
        }
        if (monitorRepository.findByUsernameAndPassword(username, password) != null) {
            res = true;
        }
        if (supervisorRepository.findByUsernameAndPassword(username, password) != null) {
            res = true;
        }
        if (internshipManagerRepository.findByUsernameAndPassword(username, password) != null) {
            res = true;
        }
        System.out.println("Res-> " + res);
       return res;
    }

    public Monitor loginMonitor(String username, String password) {
        return monitorRepository.findByUsernameAndPassword(username, password);
    }

    public Supervisor loginSupervisor(String username, String password) {
        return supervisorRepository.findByUsernameAndPassword(username, password);
    }

    public InternshipManager loginInternshipManager(String username, String password) {
        return internshipManagerRepository.findByUsernameAndPassword(username, password);
    }

}
