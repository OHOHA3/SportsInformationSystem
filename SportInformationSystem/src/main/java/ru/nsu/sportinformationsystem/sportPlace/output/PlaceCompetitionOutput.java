package ru.nsu.sportinformationsystem.sportPlace.output;

import lombok.Getter;
import lombok.Setter;
import ru.nsu.sportinformationsystem.competition.Competition;

import java.util.List;

@Getter
@Setter
public class PlaceCompetitionOutput {
    String name;
    String address;
    List<Competition> competitions;
}
