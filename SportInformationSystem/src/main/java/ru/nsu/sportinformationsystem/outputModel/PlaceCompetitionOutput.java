package ru.nsu.sportinformationsystem.outputModel;

import lombok.Getter;
import lombok.Setter;
import ru.nsu.sportinformationsystem.model.Competition;

import java.util.List;

@Getter
@Setter
public class PlaceCompetitionOutput {
    String name;
    String address;
    List<Competition> competitions;
}
