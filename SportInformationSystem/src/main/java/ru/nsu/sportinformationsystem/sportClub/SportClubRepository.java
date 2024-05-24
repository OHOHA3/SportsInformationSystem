package ru.nsu.sportinformationsystem.sportClub;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface SportClubRepository extends CrudRepository<SportClub, Integer> {
    @Query("""
                SELECT sc.name AS name,
                members.member_count AS member_count
                FROM Sport_club AS sc LEFT JOIN
                (SELECT isc.id AS iid,
                count(*) AS member_count
                FROM Sport_club AS isc JOIN Athlete AS a
                ON isc.id = a.club_id JOIN Competition_athlete AS ca
                ON a.id = ca.athlete_id JOIN Competition c
                ON c.id = ca.competition_id
                WHERE c.competition_date BETWEEN :from AND :to
                GROUP BY isc.id) AS members
                ON sc.id = members.iid
            """)
    List<SportClubCountOutput> findAllByDate(@Param("from") LocalDate from, @Param("to") LocalDate to);
}
