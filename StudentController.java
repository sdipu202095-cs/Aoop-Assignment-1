package com.example.demo.controller;

import com.example.demo.model.Student;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    
    private static final List<Student> students = new ArrayList<>();
    
    static {
        students.add(new Student("S001", "Alice Johnson", "alice@uiu.edu.bd", 3.85));
        students.add(new Student("S002", "Bob Smith", "bob@uiu.edu.bd", 3.72));
        students.add(new Student("S003", "Carol White", "carol@uiu.edu.bd", 3.90));
        students.add(new Student("S004", "David Brown", "david@uiu.edu.bd", 3.65));
    }

    @GetMapping
    public List<Student> getAllStudents() {
        return students;
    }

    @GetMapping("/{id}")
    public Student getStudent(@PathVariable String id) {
        Optional<Student> student = students.stream()
                .filter(s -> s.getId().equals(id))
                .findFirst();
        return student.orElse(null);
    }

    @PostMapping
    public Student addStudent(@RequestBody Student student) {
        students.add(student);
        return student;
    }

    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable String id, @RequestBody Student updatedStudent) {
        Optional<Student> existingStudent = students.stream()
                .filter(s -> s.getId().equals(id))
                .findFirst();
        
        if (existingStudent.isPresent()) {
            Student student = existingStudent.get();
            student.setName(updatedStudent.getName());
            student.setEmail(updatedStudent.getEmail());
            student.setCgpa(updatedStudent.getCgpa());
            return student;
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public boolean deleteStudent(@PathVariable String id) {
        return students.removeIf(s -> s.getId().equals(id));
    }
}
