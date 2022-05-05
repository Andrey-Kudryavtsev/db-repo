package ru.nsu.kudryavtsev.andrey.alphaproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.nsu.kudryavtsev.andrey.alphaproject.model.PaymentStatus;
import ru.nsu.kudryavtsev.andrey.alphaproject.service.PaymentStatusService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class PaymentStatusController {
    @Autowired
    PaymentStatusService paymentStatusService;

    @PostMapping("/payment_status")
    public ResponseEntity<PaymentStatus> createPaymentStatus(@RequestBody PaymentStatus paymentStatus) {
        try {
            PaymentStatus savedPaymentStatus = paymentStatusService.save(new PaymentStatus(paymentStatus.getName()));
            return new ResponseEntity<>(savedPaymentStatus, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/payment_status")
    public ResponseEntity<List<PaymentStatus>> getAllPaymentStatuses() {
        try {
            List<PaymentStatus> paymentStatuses = new ArrayList<>();
            paymentStatuses.addAll(paymentStatusService.findAll());
            if (paymentStatuses.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(paymentStatuses, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
