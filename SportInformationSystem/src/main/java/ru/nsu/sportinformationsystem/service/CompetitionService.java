package ru.nsu.sportinformationsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.nsu.sportinformationsystem.model.Competition;
import ru.nsu.sportinformationsystem.repository.CompetitionRepository;

import java.time.LocalDate;
import java.util.List;

@Service
public class CompetitionService {
    private final CompetitionRepository competitionRepository;

    @Autowired
    public CompetitionService(CompetitionRepository competitionRepository) {
        this.competitionRepository = competitionRepository;
    }

    public List<Competition> findAll() {
        return (List<Competition>) competitionRepository.findAll();
    }

    public List<Competition> findByCompetitionDate(LocalDate dateFrom, LocalDate dateTo) {
        return competitionRepository.findAllByCompetitionDate(dateFrom, dateTo);
    }

    public List<Competition> findByCompetitionDateAndTrainerId(LocalDate dateFrom, LocalDate dateTo, int TrainerId) {
        return competitionRepository.findAllByCompetitionDateAndTrainerId(dateFrom, dateTo, TrainerId);
    }

    public List<Competition> findByPlaceId(int placeId) {
        return competitionRepository.findAllByPlaceId(placeId);
    }
    public List<Competition> findByPlaceIdAndSportId(int placeId, int sportId) {
        return competitionRepository.findAllByPlaceIdAndSportId(placeId, sportId);
    }
    public Competition getById(int id) {
        return competitionRepository.findById(id).orElse(null);
    }
}
