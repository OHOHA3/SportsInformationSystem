package ru.nsu.sportinformationsystem.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.nsu.sportinformationsystem.model.AthleteSport;

@Repository
public interface AthleteSportRepository extends CrudRepository<AthleteSport, AthleteSport.Pk> {
}
