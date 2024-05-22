package ru.nsu.sportinformationsystem.mapper;

import org.springframework.stereotype.Component;
import ru.nsu.sportinformationsystem.model.Athlete;
import ru.nsu.sportinformationsystem.model.Sport;
import ru.nsu.sportinformationsystem.outputModel.AthleteSportOutput;
import ru.nsu.sportinformationsystem.outputModel.AthleteSportRankOutput;
import ru.nsu.sportinformationsystem.outputModel.SportRankOutput;

import java.util.List;

@Component
public class AthleteSportMapper {
    public AthleteSportOutput toAthleteSportOutput(Athlete athlete, List<Sport> sportList) {
        AthleteSportOutput athleteSportOutput = new AthleteSportOutput();
        athleteSportOutput.setFirstName(athlete.getFirstName());
        athleteSportOutput.setLastName(athlete.getLastName());
        athleteSportOutput.setFatherName(athlete.getFatherName());
        athleteSportOutput.setSportList(sportList.stream().map(Sport::getName).toList());
        return athleteSportOutput;
    }

    public AthleteSportRankOutput toAthleteSportRankOutput(Athlete athlete, List<SportRankOutput> sportRankList) {
        AthleteSportRankOutput athleteSportRankOutput = new AthleteSportRankOutput();
        athleteSportRankOutput.setFirstName(athlete.getFirstName());
        athleteSportRankOutput.setLastName(athlete.getLastName());
        athleteSportRankOutput.setFatherName(athlete.getFatherName());
        athleteSportRankOutput.setSportRankList(sportRankList);
        return athleteSportRankOutput;
    }
}
