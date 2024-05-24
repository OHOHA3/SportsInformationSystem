package ru.nsu.sportinformationsystem.stadium;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StadiumRepository extends CrudRepository<Stadium, Integer> {
    @Query("""
            SELECT si.id AS id,
            si.name AS name,
            si.type_id AS type_id,
            si.address AS address,
            si.capacity AS capacity
            FROM Stadium_info AS si
            """)
    List<Stadium> findAll();

    @Query("""
            SELECT si.id AS id,
            si.name AS name,
            si.address AS address,
            si.capacity AS capacity
            FROM Stadium_info AS si WHERE si.capacity >= :capacity
            """)
    List<Stadium> findAllByCapacityGreaterThanEqual(@Param("capacity") int capacity);
}
