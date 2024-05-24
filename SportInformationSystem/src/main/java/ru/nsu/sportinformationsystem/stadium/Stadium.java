package ru.nsu.sportinformationsystem.stadium;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.relational.core.mapping.Table;
import ru.nsu.sportinformationsystem.sportPlace.SportPlace;

@Getter
@Setter
@Table("stadium_info")
public class Stadium extends SportPlace {
    private int capacity;
}
