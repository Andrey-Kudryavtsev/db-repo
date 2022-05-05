package ru.nsu.kudryavtsev.andrey.alphaproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nsu.kudryavtsev.andrey.alphaproject.model.PhysicalPerson;

import java.util.List;

public interface PhysicalPersonRepository extends JpaRepository<PhysicalPerson, Long> {
    List<PhysicalPerson> findPhysicalPersonByFullNameContaining(String name);
}
