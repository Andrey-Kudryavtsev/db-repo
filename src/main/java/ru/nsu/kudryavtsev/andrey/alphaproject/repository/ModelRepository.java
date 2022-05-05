package ru.nsu.kudryavtsev.andrey.alphaproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nsu.kudryavtsev.andrey.alphaproject.model.Model;

import java.util.List;
import java.util.Optional;

public interface ModelRepository extends JpaRepository<Model, Long> {
    List<Model> findModelByNameContaining(String name);
    Optional<Model> findModelByName(String name);
}
