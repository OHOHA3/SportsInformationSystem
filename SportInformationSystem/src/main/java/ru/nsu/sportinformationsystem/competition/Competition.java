package ru.nsu.sportinformationsystem.competition;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;

@Getter
@Setter
public class Competition {
    @Id
    private int id;
    private String name;
    private int sportId;
    private int placeId;
    private LocalDate competitionDate;
}
