package com.sai.course.repository;

import com.sai.course.domain.Payment;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PaymentRepository extends CrudRepository<Payment, Integer> {

    Optional<Payment> findByCourseName(String courseName);

    Boolean existsByCourseName(String courseName);

    //@Query("SELECT p.courseName as courseName, c.createdBy as createdBy , c.description as description FROM Payment p LEFT JOIN course c ON p.courseName = c.courseName WHERE p.createdBy = ?1")
    @Query("SELECT p.courseName as courseName, c.createdBy as createdBy , c.description as description FROM Payment p LEFT JOIN Course c ON p.courseName = c.courseName WHERE p.createdBy = ?1")
    List<List<String>> findCourseByUser(String createdBy);

}
