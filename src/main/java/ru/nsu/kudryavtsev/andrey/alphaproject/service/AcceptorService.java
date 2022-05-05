package ru.nsu.kudryavtsev.andrey.alphaproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.nsu.kudryavtsev.andrey.alphaproject.model.Acceptor;
import ru.nsu.kudryavtsev.andrey.alphaproject.repository.AcceptorRepository;

import java.util.List;

@Service
public class AcceptorService {
    @Autowired
    AcceptorRepository acceptorRepository;

    public List<Acceptor> findAll() {
        return acceptorRepository.findAll();
    }

    public List<Acceptor> findByNameContaining(String name) {
        return acceptorRepository.findAcceptorByFullNameContaining(name);
    }

    public Acceptor save(Acceptor acceptor) {
        return acceptorRepository.save(acceptor);
    }
}
