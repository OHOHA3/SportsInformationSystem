package ru.nsu.sportinformationsystem.trainer;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.nsu.sportinformationsystem.trainer.output.TrainerQualificationOutput;

import java.util.List;

@Repository
public interface TrainerRepository extends CrudRepository<Trainer, Integer> {
    @Query("""
            SELECT t.id AS id,
            t.first_name AS first_name,
            t.last_name AS last_name,
            t.father_name AS father_name
            FROM Trainer AS t JOIN Trainer_athlete AS ta
            ON t.id = ta.trainer_id
            WHERE ta.athlete_id = :athleteId
            GROUP BY t.id
            """)
    List<Trainer> findAllByAthleteId(@Param("athleteId") int athleteId);

    @Query("""
            SELECT t.first_name AS first_name,
                t.last_name AS last_name,
                t.father_name AS father_name,
                tq.name AS qualification
                FROM Trainer AS t JOIN Trainer_sport AS ts
            ON t.id = ts.trainer_id LEFT JOIN Trainer_qualification AS tq
            ON ts.qualification_id = tq.id
            WHERE ts.sport_id = :sportId
            """)
    List<TrainerQualificationOutput> findAllBySportId(@Param("sportId") int sportId);
}
