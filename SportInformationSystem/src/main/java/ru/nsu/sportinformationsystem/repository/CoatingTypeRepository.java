package ru.nsu.sportinformationsystem.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.nsu.sportinformationsystem.model.CoatingType;

@Repository
public interface CoatingTypeRepository extends CrudRepository<CoatingType, Integer> {
}
