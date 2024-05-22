package ru.nsu.sportinformationsystem.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;

@Getter
@Setter
public class SportClub {
    @Id
    private Integer id;
    private String name;
    private LocalDate creationDate;
}
