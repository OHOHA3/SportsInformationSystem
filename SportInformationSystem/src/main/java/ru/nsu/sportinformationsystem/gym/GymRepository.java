package ru.nsu.sportinformationsystem.gym;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GymRepository extends CrudRepository<Gym, Long> {
    @Query("""
            SELECT gi.id AS id,
            gi.name AS name,
            gi.type_id AS type_id,
            gi.address AS address,
            gi. simulators_count AS simulators_count
            FROM Gym_info AS gi
            """)
    List<Gym> findAll();

    @Query("""
            SELECT gi.id AS id,
            gi.name AS name,
            gi.type_id AS type_id,
            gi.address AS address,
            gi.simulators_count AS simulators_count
            FROM Gym_info AS gi
            WHERE gi.simulators_count >= :simulatorsCount
            """)
    List<Gym> findAllBySimulatorsCountGreaterThanEqual(@Param("simulatorsCount") int simulatorsCount);
}
