package ru.nsu.sportinformationsystem.competition;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface CompetitionRepository extends CrudRepository<Competition, Integer> {
    @Query("""
                SELECT c.id AS id,
                c.name AS name,
                c.sport_id AS sport_id,
                c.place_id AS place_id,
                c.competition_date AS competition_date
                FROM Competition AS c
                WHERE c.competition_date BETWEEN :dateFrom AND :dateTo
            """)
    List<Competition> findAllByCompetitionDate(@Param("dateFrom") LocalDate dateFrom, @Param("dateTo") LocalDate dateTo);

    @Query("""
                SELECT c.id AS id,
                c.name AS name,
                c.sport_id AS sport_id,
                c.place_id AS place_id,
                c.competition_date AS competition_date
                FROM Competition AS c JOIN Organizer_competition AS oc
                ON c.id = oc.competition_id
                WHERE c.competition_date BETWEEN :dateFrom AND :dateTo AND oc.organizer_id = :OrganizerId
            """)
    List<Competition> findAllByCompetitionDateAndTrainerId(@Param("dateFrom") LocalDate dateFrom, @Param("dateTo") LocalDate dateTo, @Param("OrganizerId") int OrganizerId);

    @Query("""
                SELECT c.id AS id,
                c.name AS name,
                c.place_id AS place_id,
                c.competition_date AS competition_date
                FROM Competition AS c
                WHERE c.place_id = :placeId
            """)
    List<Competition> findAllByPlaceId(@Param("placeId") int placeId);

    @Query("""
                SELECT c.id AS id,
                c.name AS name,
                c.place_id AS place_id,
                c.competition_date AS competition_date
                FROM Competition AS c JOIN Sport AS s
                ON c.sport_id = s.id
                WHERE c.place_id = :placeId AND s.id = :sportId
            """)
    List<Competition> findAllByPlaceIdAndSportId(@Param("placeId") int placeId, @Param("sportId") int sportId);
}
