package ru.nsu.sportinformationsystem.repository;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.nsu.sportinformationsystem.model.SportPlace;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface SportPlaceRepository extends CrudRepository<SportPlace, Integer> {
    @Query("""
            SELECT sp.id AS id,
            sp.name AS name,
            sp.type_id AS type_id,
            sp.address AS address
            FROM Sport_place AS sp JOIN Competition AS c
            ON sp.id = c.place_id
            WHERE c.competition_date BETWEEN :from AND :to
            """)
    List<SportPlace> findAllByCompetitionDate(@Param("from") LocalDate from, @Param("to") LocalDate to);
}
