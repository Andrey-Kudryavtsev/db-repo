package ru.nsu.kudryavtsev.andrey.alphaproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.nsu.kudryavtsev.andrey.alphaproject.model.Model;
import ru.nsu.kudryavtsev.andrey.alphaproject.repository.ModelRepository;
import ru.nsu.kudryavtsev.andrey.alphaproject.service.ModelService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ModelController {
    @Autowired
    ModelService modelService;

    @GetMapping("/models")
    public ResponseEntity<List<Model>> getAllModels(@RequestParam(required = false) String name) {
        try {
            List<Model> models = new ArrayList<>();
            if (name == null) {
                models.addAll(modelService.findAll());
            } else {
                models.addAll(modelService.findByNameContaining(name));
            }
            if (models.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(models, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/models/{id}")
    public ResponseEntity<Model> getModel(@PathVariable("id") Long id) {
        try {
            Optional<Model> model = modelService.findById(id);
            return model.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/models")
    public ResponseEntity<Model> createModel(@RequestBody Model model) {
        try {
            Model _model = modelService.save(new Model(model.getName()));
            return new ResponseEntity<>(_model, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/models/{id}")
    public ResponseEntity<Model> updateModel(@PathVariable("id") Long id, @RequestBody Model model) {
        try {
            Optional<Model> model_opt = modelService.findById(id);
            if (model_opt.isPresent()) {
                Model _model = model_opt.get();
                _model.setName(model.getName());
                Model savedModel = modelService.save(_model);
                return new ResponseEntity<>(savedModel, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/models/{id}")
    public ResponseEntity<HttpStatus> deleteModel(@PathVariable("id") Long id) {
        try {
            modelService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/models")
    public ResponseEntity<HttpStatus> deleteAllModels() {
        try {
            modelService.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
