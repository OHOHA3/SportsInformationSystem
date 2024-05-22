package ru.nsu.sportinformationsystem.repository;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.nsu.sportinformationsystem.model.AthleteSport;
import ru.nsu.sportinformationsystem.outputModel.AthleteRankOutput;

import java.util.List;

@Repository
public interface AthleteSportRepository extends CrudRepository<AthleteSport, AthleteSport.Pk> {
    @Query("""
            SELECT a.first_name AS first_name,
            a.last_name AS last_name,
            sr.name AS sports_rank
            FROM Athlete AS a JOIN Athlete_sport AS a_s
            ON a.id = a_s.athlete_id JOIN Sport AS s
            ON a_s.sport_id = s.id LEFT JOIN Sports_rank AS sr
            ON a_s.sports_rank_id = sr.id
            WHERE s.id = :sportId
            """)
    List<AthleteRankOutput> findAllBySportId(@Param("sportId") int sportId);
    @Query("""
            SELECT a.first_name AS first_name,
            a.last_name AS last_name,
            sr.name AS sports_rank
            FROM Athlete AS a JOIN Athlete_sport AS a_s
            ON a.id = a_s.athlete_id JOIN Sport AS s
            ON a_s.sport_id = s.id JOIN Sports_rank AS sr
            ON a_s.sports_rank_id = sr.id
            WHERE s.id = :sportId AND sr.id >= :rankId
            """)
    List<AthleteRankOutput> findAllBySportIdAndRankId(@Param("sportId") int sportId, @Param("rankId") int rankId);
}
