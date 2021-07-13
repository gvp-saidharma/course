package com.sai.course.service;


import com.sai.course.domain.Course;
import com.sai.course.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public ResponseEntity<?> create(Course course, String username) {
        if (courseRepository.existsByCourseName(course.getCourseName())) {
            return ResponseEntity.badRequest().body("Error: courseName is already taken!");
        } else if(course.getPrice() == null) {
            return ResponseEntity.badRequest().body("Error: price is not given!");
        }
        course.setCreatedBy(username);
        return ResponseEntity.ok(courseRepository.save(course));
    }

    public ResponseEntity<?> getAllCourses() {
        return ResponseEntity.ok(courseRepository.findAll());
    }

    public ResponseEntity<?> update(Course course) {
        if (!courseRepository.existsByCourseName(course.getCourseName())) {
            return ResponseEntity.badRequest().body("Error: courseName doesn't exists!");
        }
        return ResponseEntity.ok(courseRepository.save(course));
    }

    public ResponseEntity<?> delete(String courseName) {
        Optional<Course> course = courseRepository.findByCourseName(courseName);
        if (course != null) {
            return ResponseEntity.badRequest().body("Error: courseName doesn't exists!");
        }
        courseRepository.deleteById(course.get().getId());
        return ResponseEntity.ok(courseName + " successfully deleted");
    }
}
