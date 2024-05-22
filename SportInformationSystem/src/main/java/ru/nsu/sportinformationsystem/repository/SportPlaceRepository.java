package ru.nsu.sportinformationsystem.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.nsu.sportinformationsystem.model.SportPlace;

@Repository
public interface SportPlaceRepository extends CrudRepository<SportPlace, Integer> {
}
