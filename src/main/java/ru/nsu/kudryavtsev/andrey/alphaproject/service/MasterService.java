package ru.nsu.kudryavtsev.andrey.alphaproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.nsu.kudryavtsev.andrey.alphaproject.model.Master;
import ru.nsu.kudryavtsev.andrey.alphaproject.model.Model;
import ru.nsu.kudryavtsev.andrey.alphaproject.repository.MasterRepository;

import java.util.List;

@Service
public class MasterService {
    @Autowired
    MasterRepository masterRepository;

    public List<Master> findAll() {
        return masterRepository.findAll();
    }

    public List<Master> findByNameContaining(String name) {
        return masterRepository.findMasterByFullNameContaining(name);
    }

    public Master save(Master master) {
        return masterRepository.save(master);
    }
}
