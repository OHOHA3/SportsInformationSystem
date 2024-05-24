package ru.nsu.sportinformationsystem.arena;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.relational.core.mapping.Table;
import ru.nsu.sportinformationsystem.sportPlace.SportPlace;

@Getter
@Setter
@Table("arena_info")
public class Arena extends SportPlace {
    private int area;
}
