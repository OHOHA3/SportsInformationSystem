package ru.nsu.sportinformationsystem.athlete;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter
@Setter
public class Athlete {
    @Id
    private int id;
    private String firstName;
    private String lastName;
    private String fatherName;
    private Integer clubId;
}
