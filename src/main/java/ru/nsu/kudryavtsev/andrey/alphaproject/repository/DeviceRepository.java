package ru.nsu.kudryavtsev.andrey.alphaproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.nsu.kudryavtsev.andrey.alphaproject.model.Device;

import java.util.List;

public interface DeviceRepository extends JpaRepository<Device, Long> {

}
