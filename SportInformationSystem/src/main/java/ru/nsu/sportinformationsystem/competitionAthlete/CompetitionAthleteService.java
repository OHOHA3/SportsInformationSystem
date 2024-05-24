package ru.nsu.sportinformationsystem.competitionAthlete;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.nsu.sportinformationsystem.athlete.AthleteRepository;
import ru.nsu.sportinformationsystem.athlete.output.AthletePlaceOutput;
import ru.nsu.sportinformationsystem.competition.CompetitionRepository;

import java.util.List;

@Service
public class CompetitionAthleteService {
    private final CompetitionRepository competitionRepository;
    private final AthleteRepository athleteRepository;

    @Autowired
    public CompetitionAthleteService(CompetitionRepository competitionRepository, AthleteRepository athleteRepository) {
        this.competitionRepository = competitionRepository;
        this.athleteRepository = athleteRepository;
    }

    public List<AthletePlaceOutput> findWinnersByCompetitionId(int competitionId) {
        return athleteRepository.findWinnersByCompetitionId(competitionId);
    }
}
