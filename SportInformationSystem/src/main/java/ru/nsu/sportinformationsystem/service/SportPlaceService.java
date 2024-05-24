package ru.nsu.sportinformationsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.nsu.sportinformationsystem.mapper.SportPlaceMapper;
import ru.nsu.sportinformationsystem.model.SportPlace;
import ru.nsu.sportinformationsystem.model.Stadium;
import ru.nsu.sportinformationsystem.outputModel.PlaceCompetitionOutput;
import ru.nsu.sportinformationsystem.repository.CompetitionRepository;
import ru.nsu.sportinformationsystem.repository.SportPlaceRepository;
import ru.nsu.sportinformationsystem.repository.StadiumRepository;

import java.time.LocalDate;
import java.util.List;

@Service
public class SportPlaceService {
    private final SportPlaceRepository sportPlaceRepository;
    private final CompetitionRepository competitionRepository;
    private final SportPlaceMapper sportPlaceMapper;
    @Autowired
    public SportPlaceService(SportPlaceRepository sportPlaceRepository, CompetitionRepository competitionRepository, SportPlaceMapper sportPlaceMapper) {
        this.sportPlaceRepository = sportPlaceRepository;
        this.competitionRepository = competitionRepository;
        this.sportPlaceMapper = sportPlaceMapper;
    }
    public List<SportPlace> findAll() {
        return (List<SportPlace>) sportPlaceRepository.findAll();
    }
    public SportPlace getById(int id) {
        return sportPlaceRepository.findById(id).orElse(null);
    }

    public List<PlaceCompetitionOutput> findByCompetitionDate(String from, String to) {
        LocalDate dateFrom = from.isEmpty() ? LocalDate.now().minusYears(100) : LocalDate.parse(from);
        LocalDate dateTo = to.isEmpty() ? LocalDate.now() : LocalDate.parse(to);
        List<SportPlace> sportPlaces = sportPlaceRepository.findAllByCompetitionDate(dateFrom, dateTo);
        return sportPlaces.stream().map(place -> sportPlaceMapper
                .toPlaceCompetitionOutput(place, competitionRepository.findAllByPlaceId(place.getId()))).toList();
    }
}
