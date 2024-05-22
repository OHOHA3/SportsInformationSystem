package ru.nsu.sportinformationsystem.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.nsu.sportinformationsystem.model.SportsRank;

@Repository
public interface SportsRankRepository extends CrudRepository<SportsRank, Integer> {
}
