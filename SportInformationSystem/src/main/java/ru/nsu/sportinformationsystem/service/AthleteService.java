package ru.nsu.sportinformationsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.nsu.sportinformationsystem.model.Athlete;
import ru.nsu.sportinformationsystem.outputModel.AthleteRankOutput;
import ru.nsu.sportinformationsystem.repository.AthleteRepository;

import java.time.LocalDate;
import java.util.List;

@Service
public class AthleteService {
    private final AthleteRepository athleteRepository;

    @Autowired
    public AthleteService(AthleteRepository athleteRepository) {
        this.athleteRepository = athleteRepository;
    }

    public List<Athlete> findAll() {
        return (List<Athlete>) athleteRepository.findAll();
    }

    public Athlete getById(int id) {
        return athleteRepository.findById(id).orElse(null);
    }

    @Transactional
    public void save(Athlete athlete) {
        athleteRepository.save(athlete);
    }

    @Transactional
    public void update(int id, Athlete updatedAthlete) {
        updatedAthlete.setId(id);
        athleteRepository.save(updatedAthlete);
    }

    @Transactional
    public void delete(int id) {
        athleteRepository.deleteById(id);
    }

    public List<AthleteRankOutput> findBySportId(int sportId) {
        return athleteRepository.findAllBySportId(sportId);
    }

    public List<AthleteRankOutput> findBySportIdAndRankId(int sportId, int rankId) {
        return athleteRepository.findAllBySportIdAndRankId(sportId, rankId);
    }

    public List<Athlete> findByCompetitionDate(LocalDate from, LocalDate to) {
        return athleteRepository.findAllByCompetitionDate(from, to);
    }
}
