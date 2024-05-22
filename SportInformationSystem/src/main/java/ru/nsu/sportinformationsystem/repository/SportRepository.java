package ru.nsu.sportinformationsystem.repository;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.nsu.sportinformationsystem.model.Sport;
import ru.nsu.sportinformationsystem.outputModel.SportRankOutput;

import java.util.List;

@Repository
public interface SportRepository extends CrudRepository<Sport, Integer> {
    @Query("""
            SELECT s.id AS id,
            s.name AS name,
            s.description AS description
            FROM Sport AS s JOIN Athlete_sport AS a_s
            ON s.id = a_s.sport_id
            WHERE a_s.athlete_id = :athleteId
            """)
    List<Sport> findAllByAthleteId(@Param("athleteId") int athleteId);

    @Query("""
            SELECT s.name AS sport_name,
            sr.name AS rank_name
            FROM Athlete AS a JOIN Trainer_athlete AS ta
            ON a.id = ta.athlete_id JOIN Trainer AS t
            ON ta.trainer_id = t.id JOIN Athlete_sport AS a_s
            ON ta.athlete_id = a_s.athlete_id AND ta.sport_id = a_s.sport_id
            JOIN Sport AS s ON a_s.sport_id = s.id
            LEFT JOIN Sports_rank AS sr ON a_s.sports_rank_id = sr.id
            WHERE t.id = :trainerId AND a.id=:athleteId
            """)
    List<SportRankOutput> findAllByAthleteIdAndTrainerId(@Param("athleteId") int athleteId, @Param("trainerId") int trainerId);

    @Query("""
            SELECT s.name AS sport_name,
            sr.name AS rank_name
            FROM Athlete AS a JOIN Trainer_athlete AS ta
            ON a.id = ta.athlete_id JOIN Trainer AS t
            ON ta.trainer_id = t.id JOIN Athlete_sport AS a_s
            ON ta.athlete_id = a_s.athlete_id AND ta.sport_id = a_s.sport_id
            JOIN Sport AS s ON a_s.sport_id = s.id
            JOIN Sports_rank AS sr ON a_s.sports_rank_id = sr.id
            WHERE t.id = :trainerId AND a.id=:athleteId AND sr.id >= :rankId
            """)
    List<SportRankOutput> findAllByAthleteIdAndTrainerIdAndRankId(@Param("athleteId") int athleteId, @Param("trainerId") int trainerId, @Param("rankId") int rankId);
}
