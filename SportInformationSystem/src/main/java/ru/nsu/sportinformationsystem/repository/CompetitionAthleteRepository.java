package ru.nsu.sportinformationsystem.repository;

import org.springframework.data.repository.CrudRepository;
import ru.nsu.sportinformationsystem.model.CompetitionAthlete;

public interface CompetitionAthleteRepository extends CrudRepository<CompetitionAthlete, CompetitionAthlete.Pk> {
}
