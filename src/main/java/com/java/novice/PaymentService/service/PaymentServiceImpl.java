package com.java.novice.PaymentService.service;

import com.java.novice.PaymentService.entity.TransactionDetails;
import com.java.novice.PaymentService.model.PaymentRequest;
import com.java.novice.PaymentService.repository.TransactionDetailsRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
@Log4j2
public class PaymentServiceImpl implements PaymentService{

    @Autowired
    private TransactionDetailsRepository transactionDetailsRepository;
    @Override
    public Long doPayment(PaymentRequest paymentRequest) {
        log.info("Recording payment details: {}", paymentRequest);
        TransactionDetails transactionDetails = TransactionDetails.builder()
                .paymentDate(Instant.now())
                .paymentMode(paymentRequest.getPaymentMode().name())
                .paymentStatus("SUCCESS")
                .orderId(paymentRequest.getOrderId())
                .referenceNumber(paymentRequest.getReferenceNumber())
                .amount(paymentRequest.getAmount())
                .build();
        transactionDetailsRepository.save(transactionDetails);
        log.info("Transacion completed with id {}",transactionDetails.getId());
        return transactionDetails.getId();
    }
}
