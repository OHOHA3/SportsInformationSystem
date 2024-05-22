package ru.nsu.sportinformationsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.nsu.sportinformationsystem.model.Sport;
import ru.nsu.sportinformationsystem.repository.SportRepository;

import java.util.List;

@Service
public class SportService {
    private final SportRepository sportRepository;

    @Autowired
    public SportService(SportRepository sportRepository) {
        this.sportRepository = sportRepository;
    }

    public List<Sport> findAll() {
        return (List<Sport>) sportRepository.findAll();
    }

    public Sport getSportById(int id) {
        return sportRepository.findById(id).get();
    }
}
