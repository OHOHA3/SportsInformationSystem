package ru.nsu.sportinformationsystem.sportsRank;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SportsRankRepository extends CrudRepository<SportsRank, Integer> {
}
