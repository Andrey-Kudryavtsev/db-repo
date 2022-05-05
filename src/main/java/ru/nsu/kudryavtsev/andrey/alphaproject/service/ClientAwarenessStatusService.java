package ru.nsu.kudryavtsev.andrey.alphaproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.nsu.kudryavtsev.andrey.alphaproject.model.ClientAwarenessStatus;
import ru.nsu.kudryavtsev.andrey.alphaproject.repository.ClientAwarenessStatusRepository;

import java.util.List;

@Service
public class ClientAwarenessStatusService {
    @Autowired
    ClientAwarenessStatusRepository clientAwarenessStatusRepository;

    public List<ClientAwarenessStatus> findAll() {
        return clientAwarenessStatusRepository.findAll();
    }

    public ClientAwarenessStatus save(ClientAwarenessStatus clientAwarenessStatus) {
        return clientAwarenessStatusRepository.save(clientAwarenessStatus);
    }
}
