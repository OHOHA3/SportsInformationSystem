package ru.nsu.sportinformationsystem.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Embedded;

import static org.springframework.data.relational.core.mapping.Embedded.OnEmpty.USE_EMPTY;


@Getter
@Setter
public class TrainerSport {
    @Id
    @Embedded(onEmpty = USE_EMPTY)
    private Pk pk;
    private int qualificationId;

    private record Pk(int trainerId, int sportId) {
    }
}
