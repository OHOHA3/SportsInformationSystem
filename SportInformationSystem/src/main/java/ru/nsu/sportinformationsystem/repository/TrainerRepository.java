package ru.nsu.sportinformationsystem.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.nsu.sportinformationsystem.model.Trainer;

@Repository
public interface TrainerRepository extends CrudRepository<Trainer, Integer> {
}
