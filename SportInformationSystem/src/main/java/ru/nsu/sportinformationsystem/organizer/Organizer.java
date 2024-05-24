package ru.nsu.sportinformationsystem.organizer;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter
@Setter
public class Organizer {
    @Id
    private int id;
    private String firstName;
    private String lastName;
    private String fatherName;
}
