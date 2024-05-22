package ru.nsu.sportinformationsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.nsu.sportinformationsystem.model.Trainer;
import ru.nsu.sportinformationsystem.repository.TrainerRepository;

import java.util.List;

@Service
public class TrainerService {
    private final TrainerRepository trainerRepository;

    @Autowired
    public TrainerService(TrainerRepository trainerRepository) {
        this.trainerRepository = trainerRepository;
    }

    public List<Trainer> findAll() {
        return (List<Trainer>) trainerRepository.findAll();
    }

    public Trainer getById(int id) {
        return trainerRepository.findById(id).orElse(null);
    }
}
