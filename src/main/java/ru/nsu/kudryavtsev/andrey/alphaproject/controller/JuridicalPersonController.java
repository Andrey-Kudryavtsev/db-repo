package ru.nsu.kudryavtsev.andrey.alphaproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.nsu.kudryavtsev.andrey.alphaproject.model.Client;
import ru.nsu.kudryavtsev.andrey.alphaproject.model.JuridicalPerson;
import ru.nsu.kudryavtsev.andrey.alphaproject.model.Master;
import ru.nsu.kudryavtsev.andrey.alphaproject.service.ClientService;
import ru.nsu.kudryavtsev.andrey.alphaproject.service.JuridicalPersonService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class JuridicalPersonController {
    @Autowired
    JuridicalPersonService juridicalPersonService;

    @PostMapping("/juridical")
    public ResponseEntity<JuridicalPerson> createJuridicalPerson(@RequestBody JuridicalPerson juridicalPerson) {
        try {
            JuridicalPerson savedJuridicalPerson = juridicalPersonService.save(new JuridicalPerson(juridicalPerson.getName(), juridicalPerson.getPhoneNumber()));
            return new ResponseEntity<>(savedJuridicalPerson, HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/juridical")
    public ResponseEntity<List<JuridicalPerson>> getAllJuridicalPersons(@RequestParam(required = false) String name) {
        try {
            List<JuridicalPerson> juridicalPersons = new ArrayList<>();
            if (name == null) {
                juridicalPersons.addAll(juridicalPersonService.findAll());
            } else {
                juridicalPersons.addAll(juridicalPersonService.findByNameContaining(name));
            }
            if (juridicalPersons.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(juridicalPersons, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
