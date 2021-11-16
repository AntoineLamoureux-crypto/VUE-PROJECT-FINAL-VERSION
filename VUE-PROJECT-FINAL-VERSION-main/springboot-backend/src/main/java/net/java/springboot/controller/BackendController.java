package net.java.springboot.controller;

import net.java.springboot.model.InternshipManager;
import net.java.springboot.model.Monitor;
import net.java.springboot.model.Student;
import net.java.springboot.model.Supervisor;
import net.java.springboot.service.BackendService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin("http://localhost:8080/")
public class BackendController {

    private final BackendService service;

    public BackendController(
            BackendService service) {
        this.service = service;
    }

    @GetMapping("/getAll/students")
    public List<Student> getAllStudents() {
        return service.getAllStudents();
    }

    @GetMapping("/login/exist/{username}/{password}")
    public String loginExist(@PathVariable String username, @PathVariable String password) {
        return service.isLoginExist(username, password);
    }

    @PostMapping("/signUp/student")
    public Student signUpStudent(@RequestBody Student student) {
        return service.signUp(student);
    }

    @PostMapping("/signUp/monitor")
    public Monitor signUpMonitor(@RequestBody Monitor monitor) {
        return service.signUp(monitor);
    }

    @PostMapping("/signUp/supervisor")
    public Supervisor signUpSupervisor(@RequestBody Supervisor supervisor) {
        return service.signUp(supervisor);
    }

    @GetMapping("/login/student/{username}/{password}")
    public Student loginStudent(@PathVariable String username, @PathVariable String password) {
        return service.loginStudent(username, password);
    }

    @GetMapping("/login/monitor/{username}/{password}")
    public Monitor loginMonitor(@PathVariable String username, @PathVariable String password) {
        return service.loginMonitor(username, password);
    }

    @GetMapping("/login/supervisor/{username}/{password}")
    public Supervisor loginSupervisor(@PathVariable String username, @PathVariable String password) {
        return service.loginSupervisor(username, password);
    }

    @GetMapping("/login/internshipManager/{username}/{password}")
    public InternshipManager loginInternshipManager(@PathVariable String username, @PathVariable String password) {
        return service.loginInternshipManager(username, password);
    }
}
