package ru.nsu.sportinformationsystem.repository;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.nsu.sportinformationsystem.model.Athlete;
import ru.nsu.sportinformationsystem.outputModel.AthletePlaceOutput;
import ru.nsu.sportinformationsystem.outputModel.AthleteRankOutput;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface AthleteRepository extends CrudRepository<Athlete, Integer> {

    @Query("""
                    SELECT a.id AS id,
                    a.first_name AS first_name,
                    a.last_name AS last_name,
                    a.father_name AS father_name
                    FROM Athlete AS a JOIN Athlete_sport AS a_s
                    ON a.id = a_s.athlete_id JOIN
                    (SELECT ats.athlete_id AS ats_id, COUNT(*) AS cnt
                    FROM Athlete_sport AS ats
                    GROUP BY ats.athlete_id) AS counts
                    ON a_s.athlete_id = counts.ats_id
                    WHERE counts.cnt >= :count
                    GROUP BY id
            """)
    List<Athlete> findAllBySportsCount(@Param("count") int count);

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

    @Query("""
                    SELECT a.id AS id,
                    a.first_name AS first_name,
                    a.last_name AS last_name,
                    a.father_name AS father_name
                    FROM Athlete AS a JOIN Trainer_athlete AS ta
                    ON a.id = ta.athlete_id JOIN Trainer AS t
                    ON ta.trainer_id = t.id
                    WHERE t.id = :trainerId
                    GROUP BY a.id
            """)
    List<Athlete> findAllByTrainerId(@Param("trainerId") int trainerId);

    @Query("""
                    SELECT a.id AS id,
                    a.first_name AS first_name,
                    a.last_name AS last_name,
                    a.father_name AS father_name
                    FROM Athlete AS a JOIN Trainer_athlete AS ta
                    ON a.id = ta.athlete_id JOIN Trainer AS t
                    ON ta.trainer_id = t.id JOIN Athlete_sport AS a_s
                    ON ta.athlete_id = a_s.athlete_id AND ta.sport_id = a_s.sport_id
                    JOIN Sports_rank AS sr ON a_s.sports_rank_id = sr.id
                    WHERE t.id = :trainerId AND sr.id >= :rankId
                    GROUP BY a.id
            """)
    List<Athlete> findAllByTrainerIdAndRankId(@Param("trainerId") int trainerId, @Param("rankId") int rankId);

    @Query("""
                    SELECT a.id AS id,
                    a.first_name AS first_name,
                    a.last_name AS last_name,
                    a.father_name AS father_name
                    FROM Athlete AS a
                    WHERE a.id NOT IN (SELECT ca.athlete_id FROM
                    Competition_athlete AS ca JOIN Competition AS c
                    ON c.id = ca.competition_id
                    WHERE c.competition_date BETWEEN :from AND :to)
            """)
    List<Athlete> findAllByCompetitionDate(@Param("from") LocalDate from, @Param("to") LocalDate to);

    @Query("""
                    SELECT a.first_name AS first_name,
                    a.last_name AS last_name,
                    a.father_name AS father_name,
                    ca.place AS place
                    FROM Athlete AS a JOIN Competition_athlete AS ca
                    ON a.id  = ca.athlete_id JOIN Competition AS c
                    ON c.id = ca.competition_id
                    WHERE c.id = :competitionId AND ca.place >=1 AND ca.place <= 3
                    ORDER BY ca.place
            """)
    List<AthletePlaceOutput> findWinnersByCompetitionId(@Param("competitionId") int competitionId);
}
