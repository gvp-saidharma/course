package com.sai.course.service;

import com.sai.course.domain.Course;
import com.sai.course.domain.Payment;
import com.sai.course.model.UserCourse;
import com.sai.course.repository.CourseRepository;
import com.sai.course.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PaymentService {

    @Autowired private PaymentRepository paymentRepository;
    @Autowired private CourseRepository courseRepository;

    public ResponseEntity<?> payment(Payment payment, String username) {
        System.out.println(payment.getCourseName());
        System.out.println(courseRepository.existsByCourseName(payment.getCourseName()));
        if (!courseRepository.existsByCourseName(payment.getCourseName())) {
            return ResponseEntity.badRequest().body("Error: courseName is not created!");
        }
        payment.setCreatedBy(username);
        return ResponseEntity.ok(paymentRepository.save(payment));
    }

    public ResponseEntity<?> getMyCourses(String username) {
        List<List<String>> objs = paymentRepository.findCourseByUser(username);

        List<UserCourse> userCourses = new ArrayList<UserCourse>();
        for(int i=0;i<objs.size(); i++) {
            System.out.println(objs.get(i).get(0));
            System.out.println(objs.get(i).get(1));
            System.out.println(objs.get(i).get(2));
            UserCourse userCourse = new UserCourse(objs.get(i).get(0), objs.get(i).get(1), objs.get(i).get(2));
            userCourses.add(userCourse);
        }
        return ResponseEntity.ok(userCourses);
    }
}
