package ru.nsu.sportinformationsystem.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.nsu.sportinformationsystem.model.SportClub;

@Repository
public interface SportClubRepository extends CrudRepository<SportClub, Integer> {
}
