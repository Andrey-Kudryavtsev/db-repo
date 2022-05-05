package ru.nsu.kudryavtsev.andrey.alphaproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.nsu.kudryavtsev.andrey.alphaproject.model.Order;
import ru.nsu.kudryavtsev.andrey.alphaproject.service.OrderService;

@RestController
@RequestMapping("/api")
public class OrderController {
    @Autowired
    OrderService orderService;

//    @PostMapping("/order")
//    public ResponseEntity<Order> createOrder(@RequestBody Order order) {
//
//    }
}
