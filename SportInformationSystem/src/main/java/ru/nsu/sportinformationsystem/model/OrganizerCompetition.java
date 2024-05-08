package ru.nsu.sportinformationsystem.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Embedded;

import static org.springframework.data.relational.core.mapping.Embedded.OnEmpty.USE_NULL;

@Getter
@Setter
public class OrganizerCompetition {
    @Id
    @Embedded(onEmpty = USE_NULL)
    private Pk pk;

    private record Pk(int organizerId, int competitionId) {
    }
}
