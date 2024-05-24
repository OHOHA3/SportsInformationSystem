package ru.nsu.sportinformationsystem.trainer.output;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TrainerSportOutput {
    private String firstName;
    private String lastName;
    private String fatherName;
    private List<String> sportList;
}
