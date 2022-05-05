package ru.nsu.kudryavtsev.andrey.alphaproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nsu.kudryavtsev.andrey.alphaproject.model.JuridicalPerson;

import java.util.List;

public interface JuridicalPersonRepository extends JpaRepository<JuridicalPerson, Long> {
    List<JuridicalPerson> findJuridicalPersonByNameContaining(String name);
}
