package com.java.novice.PaymentService.controller;

import com.java.novice.PaymentService.model.PaymentResponse;
import com.java.novice.PaymentService.service.PaymentService;
import com.java.novice.PaymentService.model.PaymentRequest;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment")
@Log4j2
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping
    public ResponseEntity<Long> processPayment(@RequestBody PaymentRequest paymentRequest){

        return new ResponseEntity<>(paymentService.doPayment(paymentRequest),HttpStatus.OK);
    }
    @GetMapping("/order/{orderId}")
    public ResponseEntity<PaymentResponse> getPaymentDetailsByOrderId(@PathVariable("orderId") long orderId){
        return new ResponseEntity<>(paymentService.getPaymentDetailsByOrderId(orderId),HttpStatus.OK);
    }


}
