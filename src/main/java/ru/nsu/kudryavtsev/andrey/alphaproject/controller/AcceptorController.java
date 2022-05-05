package ru.nsu.kudryavtsev.andrey.alphaproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.nsu.kudryavtsev.andrey.alphaproject.model.Acceptor;
import ru.nsu.kudryavtsev.andrey.alphaproject.service.AcceptorService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class AcceptorController {
    @Autowired
    AcceptorService acceptorService;

    @PostMapping("/acceptors")
    public ResponseEntity<Acceptor> createAcceptor(@RequestBody Acceptor acceptor) {
        try {
            Acceptor savedAcceptor = acceptorService.save(new Acceptor(acceptor.getFullName()));
            return new ResponseEntity<>(savedAcceptor, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/acceptors")
    public ResponseEntity<List<Acceptor>> getAllAcceptors(@RequestParam(required = false) String name) {
        try {
            List<Acceptor> acceptors = new ArrayList<>();
            if (name == null) {
                acceptors.addAll(acceptorService.findAll());
            } else {
                acceptors.addAll(acceptorService.findByNameContaining(name));
            }
            if (acceptors.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(acceptors, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
