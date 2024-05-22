package ru.nsu.sportinformationsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.nsu.sportinformationsystem.outputModel.AthletePlaceOutput;
import ru.nsu.sportinformationsystem.repository.AthleteRepository;
import ru.nsu.sportinformationsystem.repository.CompetitionRepository;

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
