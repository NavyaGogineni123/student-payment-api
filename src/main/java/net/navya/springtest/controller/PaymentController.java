package net.navya.springtest.controller;

import net.navya.springtest.model.Payment;
import net.navya.springtest.serivce.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/payments")
@RestController
public class PaymentController {
    @Autowired
    PaymentService paymentService;

    @GetMapping("/student-id")
    public List<Payment> getPaymentMethods(@RequestParam int studentId){
        return paymentService.getPaymentMethodsByStudent(studentId);

    }
    @GetMapping("/student-name")
    public List<Payment> getByname(@RequestParam String name){
        return paymentService.getPaymentMethodsByStudentName(name);
    }
}
