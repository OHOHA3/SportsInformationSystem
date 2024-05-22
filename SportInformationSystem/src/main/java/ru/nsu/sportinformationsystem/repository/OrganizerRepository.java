package ru.nsu.sportinformationsystem.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.nsu.sportinformationsystem.model.Organizer;
@Repository
public interface OrganizerRepository extends CrudRepository<Organizer, Integer> {
}
