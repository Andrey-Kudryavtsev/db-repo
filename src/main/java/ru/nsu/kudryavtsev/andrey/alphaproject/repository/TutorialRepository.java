package ru.nsu.kudryavtsev.andrey.alphaproject.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.nsu.kudryavtsev.andrey.alphaproject.model.Tutorial;

public interface TutorialRepository extends JpaRepository<Tutorial, Long> {
    List<Tutorial> findTutorialByPublished(boolean published);
    List<Tutorial> findTutorialByTitleContaining(String title);
}
