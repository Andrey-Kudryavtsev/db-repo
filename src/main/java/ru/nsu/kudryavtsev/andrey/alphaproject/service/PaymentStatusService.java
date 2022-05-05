package ru.nsu.kudryavtsev.andrey.alphaproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.nsu.kudryavtsev.andrey.alphaproject.model.PaymentStatus;
import ru.nsu.kudryavtsev.andrey.alphaproject.repository.PaymentStatusRepository;

import java.util.List;

@Service
public class PaymentStatusService {
    @Autowired
    PaymentStatusRepository paymentStatusRepository;

    public List<PaymentStatus> findAll() {
        return paymentStatusRepository.findAll();
    }

    public PaymentStatus save(PaymentStatus paymentStatus) {
        return paymentStatusRepository.save(paymentStatus);
    }
}
