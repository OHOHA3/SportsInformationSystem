package ru.nsu.sportinformationsystem.gym;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.relational.core.mapping.Table;
import ru.nsu.sportinformationsystem.sportPlace.SportPlace;

@Getter
@Setter
@Table("gym_info")
public class Gym extends SportPlace {
    private int simulatorsCount;
}