package ru.nsu.sportinformationsystem.trainerAthlete;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.nsu.sportinformationsystem.sport.SportRepository;
import ru.nsu.sportinformationsystem.trainer.Trainer;
import ru.nsu.sportinformationsystem.trainer.TrainerMapper;
import ru.nsu.sportinformationsystem.trainer.TrainerRepository;
import ru.nsu.sportinformationsystem.trainer.output.TrainerSportOutput;

import java.util.List;

@Service
public class TrainerAthleteService {
    private final TrainerRepository trainerRepository;
    private final SportRepository sportRepository;
    private final TrainerMapper trainerMapper;

    @Autowired
    public TrainerAthleteService(TrainerRepository trainerRepository, SportRepository sportRepository, TrainerMapper trainerMapper) {
        this.trainerRepository = trainerRepository;
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
