package ru.nsu.kudryavtsev.andrey.alphaproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nsu.kudryavtsev.andrey.alphaproject.model.ClientAwarenessStatus;

public interface ClientAwarenessStatusRepository extends JpaRepository<ClientAwarenessStatus, Long> {
}
