package ru.nsu.sportinformationsystem.mapper;

import org.springframework.stereotype.Component;
import ru.nsu.sportinformationsystem.model.Competition;
import ru.nsu.sportinformationsystem.model.SportPlace;
import ru.nsu.sportinformationsystem.outputModel.PlaceCompetitionOutput;

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
