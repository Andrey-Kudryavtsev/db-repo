package ru.nsu.kudryavtsev.andrey.alphaproject.service;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.nsu.kudryavtsev.andrey.alphaproject.model.Device;
import ru.nsu.kudryavtsev.andrey.alphaproject.repository.DeviceRepository;

import javax.persistence.EntityGraph;
import java.util.List;

@Service
public class DeviceService {
    @Autowired
    DeviceRepository deviceRepository;

    public List<Device> findAll() {
        return deviceRepository.findAll();
    }

    public void deleteAll() {
        deviceRepository.deleteAll();
    }

    public Device save(Device device) {
        return deviceRepository.save(device);
    }
}
