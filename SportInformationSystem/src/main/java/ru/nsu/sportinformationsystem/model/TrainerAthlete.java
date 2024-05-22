package ru.nsu.sportinformationsystem.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Embedded;

import static org.springframework.data.relational.core.mapping.Embedded.OnEmpty.USE_NULL;

@Getter
@Setter
public class TrainerAthlete implements Persistable<TrainerAthlete.Pk> {
    @Id
    @Embedded(onEmpty = USE_NULL)
    private Pk pk;

    @Override
    public TrainerAthlete.Pk getId() {
        return null;
    }

    @Override
    public boolean isNew() {
        return false;
    }

    @Getter
    @Setter
    public static class Pk {
        Integer trainerId;
        Integer athleteId;
        Integer sportId;
    }
}