package com.java.novice.PaymentService.service;

import com.java.novice.PaymentService.model.PaymentRequest;

public interface PaymentService {
    Long doPayment(PaymentRequest paymentRequest);
}
