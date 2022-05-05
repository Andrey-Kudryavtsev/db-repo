package ru.nsu.kudryavtsev.andrey.alphaproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.nsu.kudryavtsev.andrey.alphaproject.repository.OrderRepository;

@Service
public class OrderService {
    @Autowired
    OrderRepository orderRepository;
}
