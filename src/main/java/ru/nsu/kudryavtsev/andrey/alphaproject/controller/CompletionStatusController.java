package ru.nsu.kudryavtsev.andrey.alphaproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.nsu.kudryavtsev.andrey.alphaproject.model.CompletionStatus;
import ru.nsu.kudryavtsev.andrey.alphaproject.service.CompletionStatusService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CompletionStatusController {
    @Autowired
    CompletionStatusService completionStatusService;

    @PostMapping("/completion_status")
    public ResponseEntity<CompletionStatus> createCompletionStatus(@RequestBody CompletionStatus completionStatus) {
        try {
            CompletionStatus savedCompletionStatus = completionStatusService.save(new CompletionStatus(completionStatus.getName()));
            return new ResponseEntity<>(savedCompletionStatus, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/completion_status")
    public ResponseEntity<List<CompletionStatus>> getAllCompletionStatuses() {
        try {
            List<CompletionStatus> completionStatuses = new ArrayList<>();
            completionStatuses.addAll(completionStatusService.findAll());
            if (completionStatuses.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(completionStatuses, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
