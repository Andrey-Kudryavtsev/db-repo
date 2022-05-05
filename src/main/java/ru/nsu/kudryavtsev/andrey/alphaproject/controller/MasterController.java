package ru.nsu.kudryavtsev.andrey.alphaproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.nsu.kudryavtsev.andrey.alphaproject.model.Master;
import ru.nsu.kudryavtsev.andrey.alphaproject.service.MasterService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class MasterController {
    @Autowired
    MasterService masterService;

    @PostMapping("/masters")
    public ResponseEntity<Master> createMaster(@RequestBody Master master) {
        try {
            Master savedMaster = masterService.save(new Master(master.getFullName()));
            return new ResponseEntity<>(savedMaster, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/masters")
    public ResponseEntity<List<Master>> getAllMasters(@RequestParam(required = false) String name) {
        try {
            List<Master> masters = new ArrayList<>();
            if (name == null) {
                masters.addAll(masterService.findAll());
            } else {
                masters.addAll(masterService.findByNameContaining(name));
            }
            if (masters.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(masters, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
