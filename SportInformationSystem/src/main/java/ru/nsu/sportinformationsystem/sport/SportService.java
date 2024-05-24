package ru.nsu.sportinformationsystem.sport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public Sport getById(int id) {
        return sportRepository.findById(id).orElse(null);
    }
}
