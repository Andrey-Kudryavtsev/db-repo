package ru.nsu.kudryavtsev.andrey.alphaproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.nsu.kudryavtsev.andrey.alphaproject.model.PhysicalPerson;
import ru.nsu.kudryavtsev.andrey.alphaproject.service.PhysicalPersonService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class PhysicalPersonController {
    @Autowired
    PhysicalPersonService physicalPersonService;

    @PostMapping("/physical")
    public ResponseEntity<PhysicalPerson> createJuridicalPerson(@RequestBody PhysicalPerson physicalPerson) {
        try {
            PhysicalPerson savedPhysicalPerson = physicalPersonService.save(new PhysicalPerson(physicalPerson.getFullName(), physicalPerson.getPhoneNumber()));
            return new ResponseEntity<>(savedPhysicalPerson, HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/physical")
    public ResponseEntity<List<PhysicalPerson>> getAllPhysicalPersons(@RequestParam(required = false) String name) {
        try {
            List<PhysicalPerson> physicalPersons = new ArrayList<>();
            if (name == null) {
                physicalPersons.addAll(physicalPersonService.findAll());
            } else {
                physicalPersons.addAll(physicalPersonService.findByFullNameContaining(name));
            }
            if (physicalPersons.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(physicalPersons, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
