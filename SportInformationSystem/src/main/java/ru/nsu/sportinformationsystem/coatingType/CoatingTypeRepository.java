package ru.nsu.sportinformationsystem.coatingType;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoatingTypeRepository extends CrudRepository<CoatingType, Integer> {
}
