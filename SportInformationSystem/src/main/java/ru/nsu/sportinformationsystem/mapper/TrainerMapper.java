package ru.nsu.sportinformationsystem.mapper;

import org.springframework.stereotype.Component;
import ru.nsu.sportinformationsystem.model.Sport;
import ru.nsu.sportinformationsystem.model.Trainer;
import ru.nsu.sportinformationsystem.outputModel.TrainerSportOutput;

import java.util.List;

@Component
public class TrainerMapper {

    public TrainerSportOutput toTrainerSportOutput(Trainer trainer, List<Sport> sports) {
        TrainerSportOutput trainerSportOutput = new TrainerSportOutput();
        trainerSportOutput.setFirstName(trainer.getFirstName());
        trainerSportOutput.setLastName(trainer.getLastName());
        trainerSportOutput.setFatherName(trainer.getFatherName());
        trainerSportOutput.setSportList(sports.stream().map(Sport::getName).toList());
        return trainerSportOutput;
    }
}
