package ru.nsu.sportinformationsystem.trainer;

import org.springframework.stereotype.Component;
import ru.nsu.sportinformationsystem.sport.Sport;
import ru.nsu.sportinformationsystem.trainer.output.TrainerSportOutput;

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
