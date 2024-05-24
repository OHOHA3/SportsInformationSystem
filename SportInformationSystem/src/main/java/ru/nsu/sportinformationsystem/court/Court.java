package ru.nsu.sportinformationsystem.court;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.relational.core.mapping.Table;
import ru.nsu.sportinformationsystem.sportPlace.SportPlace;

@Getter
@Setter
@Table("court_info")
public class Court extends SportPlace {
    private int coatingTypeId;
}
