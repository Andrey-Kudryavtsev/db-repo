package ru.nsu.kudryavtsev.andrey.alphaproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.nsu.kudryavtsev.andrey.alphaproject.model.JuridicalPerson;
import ru.nsu.kudryavtsev.andrey.alphaproject.repository.JuridicalPersonRepository;

import java.util.List;

@Service
public class JuridicalPersonService {
    @Autowired
    JuridicalPersonRepository juridicalPersonRepository;

    public JuridicalPerson save(JuridicalPerson juridicalPerson) {
        return juridicalPersonRepository.save(juridicalPerson);
    }

    public List<JuridicalPerson> findAll() {
        return juridicalPersonRepository.findAll();
    }

    public List<JuridicalPerson> findByNameContaining(String name) {
        return juridicalPersonRepository.findJuridicalPersonByNameContaining(name);
    }
}
