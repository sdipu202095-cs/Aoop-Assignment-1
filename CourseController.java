package com.example.demo.controller;

import com.example.demo.model.Course;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/courses")
public class CourseController {
    
    private static final List<Course> courses = new ArrayList<>();
    
    static {
        courses.add(new Course("CSE2118", "Advanced Object-Oriented Programming", 3, "Sayef Reyadh"));
        courses.add(new Course("CSE2111", "Data Structures", 3, "Dr. Ahmed Hassan"));
        courses.add(new Course("CSE2112", "Algorithms", 3, "Dr. Fatima Khan"));
        courses.add(new Course("CSE2113", "Database Management Systems", 4, "Dr. Mohammad Ali"));
    }

    @GetMapping
    public List<Course> getAllCourses() {
        return courses;
    }

    @GetMapping("/{code}")
    public Course getCourse(@PathVariable String code) {
        Optional<Course> course = courses.stream()
                .filter(c -> c.getCode().equals(code))
                .findFirst();
        return course.orElse(null);
    }

    @PostMapping
    public Course addCourse(@RequestBody Course course) {
        courses.add(course);
        return course;
    }

    @PutMapping("/{code}")
    public Course updateCourse(@PathVariable String code, @RequestBody Course updatedCourse) {
        Optional<Course> existingCourse = courses.stream()
                .filter(c -> c.getCode().equals(code))
                .findFirst();
        
        if (existingCourse.isPresent()) {
            Course course = existingCourse.get();
            course.setName(updatedCourse.getName());
            course.setCredits(updatedCourse.getCredits());
            course.setInstructor(updatedCourse.getInstructor());
            return course;
        }
        return null;
    }

    @DeleteMapping("/{code}")
    public boolean deleteCourse(@PathVariable String code) {
        return courses.removeIf(c -> c.getCode().equals(code));
    }
}
