package ru.nsu.kudryavtsev.andrey.alphaproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.nsu.kudryavtsev.andrey.alphaproject.model.Model;
import ru.nsu.kudryavtsev.andrey.alphaproject.repository.ModelRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ModelService {
    @Autowired
    ModelRepository modelRepository;

    public List<Model> findAll() {
        return modelRepository.findAll();
    }

    public List<Model> findByNameContaining(String name) {
        return modelRepository.findModelByNameContaining(name);
    }

    public Optional<Model> findByName(String name) {
        return modelRepository.findModelByName(name);
    }

    public Optional<Model> findById(Long id) {
        return modelRepository.findById(id);
    }

    public Model save(Model model) {
        return modelRepository.save(model);
    }

    public void deleteAll() {
        modelRepository.deleteAll();
    }

    public void deleteById(Long id) {
        modelRepository.deleteById(id);
    }
}
