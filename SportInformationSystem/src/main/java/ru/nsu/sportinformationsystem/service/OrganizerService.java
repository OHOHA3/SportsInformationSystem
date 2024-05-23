package ru.nsu.sportinformationsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.nsu.sportinformationsystem.model.Organizer;
import ru.nsu.sportinformationsystem.repository.OrganizerRepository;

import java.util.List;

@Service
public class OrganizerService {
    private final OrganizerRepository organizerRepository;

    @Autowired
    public OrganizerService(OrganizerRepository organizerRepository) {
        this.organizerRepository = organizerRepository;
    }

    public List<Organizer> findAll() {
        return (List<Organizer>) organizerRepository.findAll();
    }
    public Organizer getById(int id) {
        return organizerRepository.findById(id).orElse(null);
    }
}
