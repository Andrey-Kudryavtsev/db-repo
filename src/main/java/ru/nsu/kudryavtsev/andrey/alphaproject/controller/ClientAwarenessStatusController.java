package ru.nsu.kudryavtsev.andrey.alphaproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.nsu.kudryavtsev.andrey.alphaproject.model.ClientAwarenessStatus;
import ru.nsu.kudryavtsev.andrey.alphaproject.service.ClientAwarenessStatusService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ClientAwarenessStatusController {
    @Autowired
    ClientAwarenessStatusService clientAwarenessStatusService;

    @PostMapping("/client_awareness_status")
    public ResponseEntity<ClientAwarenessStatus> createClientAwarenessStatus(@RequestBody ClientAwarenessStatus clientAwarenessStatus) {
        try {
            ClientAwarenessStatus savedClientAwarenessStatus = clientAwarenessStatusService.save(new ClientAwarenessStatus(clientAwarenessStatus.getName()));
            return new ResponseEntity<>(savedClientAwarenessStatus, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/client_awareness_status")
    public ResponseEntity<List<ClientAwarenessStatus>> getAllClientAwarenessStatuses() {
        try {
            List<ClientAwarenessStatus> clientAwarenessStatuses = new ArrayList<>();
            clientAwarenessStatuses.addAll(clientAwarenessStatusService.findAll());
            if (clientAwarenessStatuses.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(clientAwarenessStatuses, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
