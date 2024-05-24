package ru.nsu.sportinformationsystem.athlete;

import org.springframework.stereotype.Component;
import ru.nsu.sportinformationsystem.athlete.output.AthleteSportOutput;
import ru.nsu.sportinformationsystem.athlete.output.AthleteSportRankOutput;
import ru.nsu.sportinformationsystem.sport.Sport;
import ru.nsu.sportinformationsystem.sport.SportRankOutput;

import java.util.List;

@Component
public class AthleteMapper {
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
