package ru.nsu.sportinformationsystem.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.nsu.sportinformationsystem.model.TrainerAthlete;

@Repository
public interface TrainerAthleteRepository extends CrudRepository<TrainerAthlete, TrainerAthlete.Pk> {
}
