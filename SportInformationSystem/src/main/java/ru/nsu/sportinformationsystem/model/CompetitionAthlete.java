package ru.nsu.sportinformationsystem.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Embedded;

import static org.springframework.data.relational.core.mapping.Embedded.OnEmpty.USE_NULL;

@Getter
@Setter
public class CompetitionAthlete {
    @Id
    @Embedded(onEmpty = USE_NULL)
    private Pk pk;
    private int place;

    private record Pk(int competitionId, int athleteId) {
    }
}
