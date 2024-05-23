package ru.nsu.sportinformationsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.nsu.sportinformationsystem.model.Organizer;
import ru.nsu.sportinformationsystem.outputModel.OrganizerCountOutput;
import ru.nsu.sportinformationsystem.repository.OrganizerRepository;

import java.time.LocalDate;
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

    public List<OrganizerCountOutput> findByDate(String from, String to) {
        LocalDate dateFrom = from.isEmpty() ? LocalDate.now().minusYears(100) : LocalDate.parse(from);
        LocalDate dateTo = to.isEmpty() ? LocalDate.now() : LocalDate.parse(to);
        return organizerRepository.findAllByDate(dateFrom, dateTo);
    }
}
