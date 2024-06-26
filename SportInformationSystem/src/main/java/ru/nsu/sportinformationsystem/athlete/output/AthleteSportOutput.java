package ru.nsu.sportinformationsystem.athlete.output;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class AthleteSportOutput {
    private String firstName;
    private String lastName;
    private String fatherName;
    private List<String> sportList;
}
