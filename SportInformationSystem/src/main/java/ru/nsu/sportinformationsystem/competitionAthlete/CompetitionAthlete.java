package ru.nsu.sportinformationsystem.competitionAthlete;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Embedded;
import ru.nsu.sportinformationsystem.athleteSport.AthleteSport;

import static org.springframework.data.relational.core.mapping.Embedded.OnEmpty.USE_NULL;

@Getter
@Setter
public class CompetitionAthlete implements Persistable<CompetitionAthlete.Pk> {
    @Id
    @Embedded(onEmpty = USE_NULL)
    private AthleteSport.Pk pk;
    private int place;

    @Override
    public CompetitionAthlete.Pk getId() {
        return null;
    }

    @Override
    public boolean isNew() {
        return false;
    }

    @Getter
    @Setter
    public static class Pk {
        Integer competitionId;
        Integer athleteId;
    }
}
