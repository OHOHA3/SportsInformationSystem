package ru.nsu.sportinformationsystem.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter
@Setter
public class Trainer {
    @Id
    private int id;
    private String firstName;
    private String lastName;
    private String fatherName;
}
