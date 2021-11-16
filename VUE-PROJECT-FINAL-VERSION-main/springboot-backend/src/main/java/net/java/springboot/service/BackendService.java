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

    public String isLoginExist(String username, String password) {
        String RES = "";
        if (studentRepository.findByUsernameAndPassword(username, password) != null) {
            RES = STUDENT;
        }
        if (monitorRepository.findByUsernameAndPassword(username, password) != null) {
            RES = MONITOR;
        }
        if (supervisorRepository.findByUsernameAndPassword(username, password) != null) {
            RES = SUPERVISOR;
        }
        if (internshipManagerRepository.findByUsernameAndPassword(username, password) != null) {
            RES = MANAGER;
        }
        else if (RES.equals(""))
            RES = NONE;

        System.out.println(RES);
       return RES;
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
