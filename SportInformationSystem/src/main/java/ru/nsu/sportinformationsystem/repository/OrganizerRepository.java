package ru.nsu.sportinformationsystem.repository;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.nsu.sportinformationsystem.model.Organizer;
import ru.nsu.sportinformationsystem.outputModel.OrganizerCountOutput;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface OrganizerRepository extends CrudRepository<Organizer, Integer> {
    @Query("""
            SELECT o.first_name AS first_name,
                o.last_name AS last_name,
                o.father_name AS father_name,
                organizations.organization_count AS organization_count
            FROM Organizer AS o LEFT JOIN
            (SELECT io.id AS iid,
            count(*) AS organization_count
            FROM Organizer AS io JOIN Organizer_competition AS oc
            ON io.id = oc.organizer_id JOIN Competition AS c
            ON c.id = oc.competition_id
            WHERE c.competition_date BETWEEN :dateFrom AND :dateTo
            GROUP BY io.id) AS organizations
            ON o.id = organizations.iid
            """)
    List<OrganizerCountOutput> findAllByDate(LocalDate dateFrom, LocalDate dateTo);
}
