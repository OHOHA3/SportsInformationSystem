package ru.nsu.sportinformationsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.nsu.sportinformationsystem.mapper.TrainerMapper;
import ru.nsu.sportinformationsystem.model.Trainer;
import ru.nsu.sportinformationsystem.outputModel.TrainerSportOutput;
import ru.nsu.sportinformationsystem.repository.AthleteRepository;
import ru.nsu.sportinformationsystem.repository.SportRepository;
import ru.nsu.sportinformationsystem.repository.TrainerRepository;

import java.util.List;

@Service
public class TrainerAthleteService {
    private final TrainerRepository trainerRepository;
    private final AthleteRepository athleteRepository;
    private final SportRepository sportRepository;
    private final TrainerMapper trainerMapper;

    @Autowired
    public TrainerAthleteService(TrainerRepository trainerRepository, AthleteRepository athleteRepository, SportRepository sportRepository, TrainerMapper trainerMapper) {
        this.trainerRepository = trainerRepository;
        this.athleteRepository = athleteRepository;
        this.sportRepository = sportRepository;
        this.trainerMapper = trainerMapper;
    }

    @Transactional
    public List<TrainerSportOutput> findByAthleteId(int athleteId) {
        List<Trainer> trainers = trainerRepository.findAllByAthleteId(athleteId);
        return trainers.stream().map(trainer -> trainerMapper
                .toTrainerSportOutput(trainer, sportRepository.findAllByTrainerIdAndAthleteId(trainer.getId(), athleteId))).toList();
    }
}
