package ru.nsu.kudryavtsev.andrey.alphaproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nsu.kudryavtsev.andrey.alphaproject.model.Master;

import java.util.List;

public interface MasterRepository extends JpaRepository<Master, Long> {
    List<Master> findMasterByFullNameContaining(String fullName);
}
