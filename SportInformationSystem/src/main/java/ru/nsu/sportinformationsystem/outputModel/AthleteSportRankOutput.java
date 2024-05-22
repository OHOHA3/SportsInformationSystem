package ru.nsu.sportinformationsystem.outputModel;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class AthleteSportRankOutput {
    private String firstName;
    private String lastName;
    private String fatherName;
    private List<SportRankOutput> sportRankList;
}
