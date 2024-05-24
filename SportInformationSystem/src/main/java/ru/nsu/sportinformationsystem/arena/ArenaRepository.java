package ru.nsu.sportinformationsystem.arena;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArenaRepository extends CrudRepository<Arena, Integer> {
    @Query("""
            SELECT ai.id AS id,
            ai.name AS name,
            ai.type_id AS type_id,
            ai.address AS address,
            ai.area AS area
            FROM Arena_info AS ai
            """)
    List<Arena> findAll();

    @Query("""
            SELECT ai.id AS id,
            ai.name AS name,
            ai.type_id AS type_id,
            ai.address AS address,
            ai.area AS area
            FROM Arena_info AS ai
            WHERE ai.area >= :area
            """)
    List<Arena> findAllByAreaGreaterThanEqual(@Param("area") int area);
}
