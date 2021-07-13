package com.sai.course.controller;

import com.sai.course.domain.Course;
import com.sai.course.service.CourseService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> create(@RequestBody Course course, @RequestHeader("username") String username) {
        return courseService.create(course, username);
    }

    @GetMapping(path = "/all")
    public ResponseEntity<?> getAllCourses() {
        return courseService.getAllCourses();
    }

    @PutMapping()
    public ResponseEntity<?> update(@RequestBody Course course) {
        return courseService.update(course);
    }

    @DeleteMapping(path="/{courseName}")
    public ResponseEntity<?> delete(@PathVariable("courseName") String courseName) {
        return courseService.delete(courseName);
    }

}
