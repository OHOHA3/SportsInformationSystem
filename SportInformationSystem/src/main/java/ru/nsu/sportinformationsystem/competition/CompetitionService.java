package ru.nsu.sportinformationsystem.competition;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public List<Competition> findByCompetitionDate(String from, String to) {
        LocalDate dateFrom = from.isEmpty() ? LocalDate.now().minusYears(100) : LocalDate.parse(from);
        LocalDate dateTo = to.isEmpty() ? LocalDate.now() : LocalDate.parse(to);
        return competitionRepository.findAllByCompetitionDate(dateFrom, dateTo);
    }

    public List<Competition> findByCompetitionDateAndTrainerId(String from, String to, int TrainerId) {
        LocalDate dateFrom = from.isEmpty() ? LocalDate.now().minusYears(100) : LocalDate.parse(from);
        LocalDate dateTo = to.isEmpty() ? LocalDate.now() : LocalDate.parse(to);
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
