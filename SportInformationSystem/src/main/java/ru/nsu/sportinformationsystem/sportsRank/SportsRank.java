package ru.nsu.sportinformationsystem.sportsRank;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter
@Setter
public class SportsRank {
    @Id
    private int id;
    private String name;
}
