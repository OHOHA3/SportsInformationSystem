package ru.nsu.sportinformationsystem.athlete.output;

import lombok.Getter;
import lombok.Setter;
import ru.nsu.sportinformationsystem.sport.SportRankOutput;

import java.util.List;

@Getter
@Setter
public class AthleteSportRankOutput {
    private String firstName;
    private String lastName;
    private String fatherName;
    private List<SportRankOutput> sportRankList;
}
