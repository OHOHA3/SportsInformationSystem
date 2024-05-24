package ru.nsu.sportinformationsystem.repository;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.nsu.sportinformationsystem.model.Court;
import ru.nsu.sportinformationsystem.outputModel.CourtCoatingOutput;

import java.util.List;

@Repository
public interface CourtRepository extends CrudRepository<Court, Integer> {
    @Query("""
           SELECT ci.id AS id,
           ci.name AS name,
           ci.address AS address,
           ct.name AS coating_type
           FROM Court_info AS ci JOIN Coating_type AS ct
           ON ci.coating_type_id = ct.id
           """)
    List<CourtCoatingOutput> findAllWithCoating();
    @Query("""
           SELECT ci.id AS id,
           ci.name AS name,
           ci.address AS address,
           ct.name AS coating_type
           FROM Court_info AS ci JOIN Coating_type AS ct
           ON ci.coating_type_id = ct.id
           WHERE ci.coating_type_id = :coatingTypeId
           """)
    List<Court> findAllByCoatingTypeId(@Param("coatingTypeId") int coatingTypeId);
}
