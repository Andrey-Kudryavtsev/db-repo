package ru.nsu.kudryavtsev.andrey.alphaproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.nsu.kudryavtsev.andrey.alphaproject.model.Client;
import ru.nsu.kudryavtsev.andrey.alphaproject.repository.ClientRepository;

import java.util.List;

@Service
public class ClientService {
    @Autowired
    ClientRepository clientRepository;

    public Client save(Client client) {
        return clientRepository.save(client);
    }

    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    public void deleteAll() {
        clientRepository.deleteAll();
    }

    public void deleteById(Long id) {
        clientRepository.deleteById(id);
    }
}
