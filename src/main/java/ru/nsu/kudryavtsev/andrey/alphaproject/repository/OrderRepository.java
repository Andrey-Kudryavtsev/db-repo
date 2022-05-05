package ru.nsu.kudryavtsev.andrey.alphaproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nsu.kudryavtsev.andrey.alphaproject.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
