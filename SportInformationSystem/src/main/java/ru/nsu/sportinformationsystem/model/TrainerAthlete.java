package ru.nsu.sportinformationsystem.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Embedded;

import static org.springframework.data.relational.core.mapping.Embedded.OnEmpty.USE_EMPTY;

@Getter
@Setter
public class TrainerAthlete {
    @Id
    @Embedded(onEmpty = USE_EMPTY)
    private Pk pk;

    private record Pk(int trainerId, int athleteId, int sportId) {
    }
}