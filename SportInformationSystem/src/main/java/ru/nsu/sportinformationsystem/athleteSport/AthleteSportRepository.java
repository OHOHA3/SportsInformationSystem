package ru.nsu.sportinformationsystem.athleteSport;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AthleteSportRepository extends CrudRepository<AthleteSport, AthleteSport.Pk> {
}
