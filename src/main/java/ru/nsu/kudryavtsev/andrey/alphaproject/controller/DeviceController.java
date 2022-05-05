package ru.nsu.kudryavtsev.andrey.alphaproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.nsu.kudryavtsev.andrey.alphaproject.model.Device;
import ru.nsu.kudryavtsev.andrey.alphaproject.model.Model;
import ru.nsu.kudryavtsev.andrey.alphaproject.repository.DeviceRepository;
import ru.nsu.kudryavtsev.andrey.alphaproject.repository.ModelRepository;
import ru.nsu.kudryavtsev.andrey.alphaproject.service.DeviceService;
import ru.nsu.kudryavtsev.andrey.alphaproject.service.ModelService;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class DeviceController {
    @Autowired
    DeviceService deviceService;
    @Autowired
    ModelService modelService;

    @GetMapping("/devices")
    public ResponseEntity<List<Device>> getAllDevices() {
        try {
            List<Device> devices = new ArrayList<>();
            devices.addAll(deviceService.findAll());
            if (devices.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(devices, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/devices")
    public ResponseEntity<Device> createDevice(@RequestParam String modelName, @RequestBody Device device) {
        try {
            Optional<Model> model = modelService.findByName(modelName);
            if (model.isPresent()) {
                Device savedDevice = deviceService.save(new Device(device.getSerialNumber(), model.get()));
                return new ResponseEntity<>(savedDevice, HttpStatus.CREATED);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/devices")
    public ResponseEntity<HttpStatus> deleteAllDevices() {
        try {
            deviceService.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
