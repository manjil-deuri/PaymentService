package com.java.novice.PaymentService.service;

import com.java.novice.PaymentService.model.PaymentRequest;
import com.java.novice.PaymentService.model.PaymentResponse;

public interface PaymentService {
    Long doPayment(PaymentRequest paymentRequest);

    PaymentResponse getPaymentDetailsByOrderId(long orderId);
}
