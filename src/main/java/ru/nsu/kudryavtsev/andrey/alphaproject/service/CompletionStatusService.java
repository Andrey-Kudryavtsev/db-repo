package ru.nsu.kudryavtsev.andrey.alphaproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.nsu.kudryavtsev.andrey.alphaproject.model.CompletionStatus;
import ru.nsu.kudryavtsev.andrey.alphaproject.repository.CompletionStatusRepository;

import java.util.List;

@Service
public class CompletionStatusService {
    @Autowired
    CompletionStatusRepository completionStatusRepository;

    public List<CompletionStatus> findAll() {
        return completionStatusRepository.findAll();
    }

    public CompletionStatus save(CompletionStatus completionStatus) {
        return completionStatusRepository.save(completionStatus);
    }
}
