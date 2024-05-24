package ru.nsu.sportinformationsystem.trainer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.nsu.sportinformationsystem.trainer.output.TrainerQualificationOutput;

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

    public List<TrainerQualificationOutput> findBySportId(int sportId) {
        return trainerRepository.findAllBySportId(sportId);
    }
}
