package com.sai.course.controller;

import com.sai.course.domain.Payment;
import com.sai.course.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/mycourse")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping(path = "/payment", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> create(@RequestBody Payment payment, @RequestHeader("username") String username) {
        return paymentService.payment(payment, username);
    }

    @GetMapping()
    public ResponseEntity<?> getMyCourses(@RequestHeader("username") String username) {
        return paymentService.getMyCourses(username);
    }
}
