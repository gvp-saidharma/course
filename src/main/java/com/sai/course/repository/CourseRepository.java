package com.sai.course.repository;

import com.sai.course.domain.Course;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface CourseRepository extends CrudRepository<Course, Integer> {

    Optional<Course> findByCourseName(String courseName);

    Boolean existsByCourseName(String courseName);

}