package ru.nsu.kudryavtsev.andrey.alphaproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.nsu.kudryavtsev.andrey.alphaproject.model.PhysicalPerson;
import ru.nsu.kudryavtsev.andrey.alphaproject.repository.PhysicalPersonRepository;

import java.util.List;

@Service
public class PhysicalPersonService {
    @Autowired
    PhysicalPersonRepository physicalPersonRepository;

    public PhysicalPerson save(PhysicalPerson physicalPerson) {
        return physicalPersonRepository.save(physicalPerson);
    }

    public List<PhysicalPerson> findAll() {
        return physicalPersonRepository.findAll();
    }

    public List<PhysicalPerson> findByFullNameContaining(String name) {
        return physicalPersonRepository.findPhysicalPersonByFullNameContaining(name);
    }
}
