package ru.nsu.kudryavtsev.andrey.alphaproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nsu.kudryavtsev.andrey.alphaproject.model.Acceptor;

import java.util.List;

public interface AcceptorRepository extends JpaRepository<Acceptor, Long> {
    List<Acceptor> findAcceptorByFullNameContaining(String fullName);
}
