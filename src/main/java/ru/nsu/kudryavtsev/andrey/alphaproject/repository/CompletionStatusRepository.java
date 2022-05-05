package ru.nsu.kudryavtsev.andrey.alphaproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nsu.kudryavtsev.andrey.alphaproject.model.CompletionStatus;

public interface CompletionStatusRepository extends JpaRepository<CompletionStatus, Long> {

}
