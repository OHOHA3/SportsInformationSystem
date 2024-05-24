package ru.nsu.sportinformationsystem.sportPlace;

import org.springframework.stereotype.Component;
import ru.nsu.sportinformationsystem.competition.Competition;
import ru.nsu.sportinformationsystem.sportPlace.output.PlaceCompetitionOutput;

import java.util.List;

@Component
public class SportPlaceMapper {
    public PlaceCompetitionOutput toPlaceCompetitionOutput(SportPlace sportPlace, List<Competition> competitions) {
        PlaceCompetitionOutput placeCompetitionOutput = new PlaceCompetitionOutput();
        placeCompetitionOutput.setName(sportPlace.getName());
        placeCompetitionOutput.setAddress(sportPlace.getAddress());
        placeCompetitionOutput.setCompetitions(competitions);
        return placeCompetitionOutput;
    }
}
