package ru.nsu.sportinformationsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.nsu.sportinformationsystem.mapper.AthleteMapper;
import ru.nsu.sportinformationsystem.model.Athlete;
import ru.nsu.sportinformationsystem.outputModel.AthleteSportOutput;
import ru.nsu.sportinformationsystem.outputModel.AthleteSportRankOutput;
import ru.nsu.sportinformationsystem.repository.AthleteRepository;
import ru.nsu.sportinformationsystem.repository.AthleteSportRepository;
import ru.nsu.sportinformationsystem.repository.SportRepository;

import java.util.List;

@Service
public class AthleteSportService {
    private final AthleteRepository athleteRepository;
    private final SportRepository sportRepository;
    private final AthleteSportRepository athleteSportRepository;
    private final AthleteMapper athleteMapper;

    @Autowired
    public AthleteSportService(AthleteRepository athleteRepository, SportRepository sportRepository, AthleteSportRepository athleteSportRepository, AthleteMapper athleteMapper) {
        this.athleteRepository = athleteRepository;
        this.sportRepository = sportRepository;
        this.athleteSportRepository = athleteSportRepository;
        this.athleteMapper = athleteMapper;
    }

    @Transactional
    public List<AthleteSportOutput> findBySportsCount(int count) {
        List<Athlete> athletes = athleteRepository.findAllBySportsCount(count);
        return athletes.stream().map(athlete -> athleteMapper
                .toAthleteSportOutput(athlete, sportRepository.findAllByAthleteId(athlete.getId()))).toList();
    }

    @Transactional
    public List<AthleteSportRankOutput> findByTrainerId(int trainerId) {
        List<Athlete> athletes = athleteRepository.findAllByTrainerId(trainerId);
        return athletes.stream().map(athlete -> athleteMapper
                .toAthleteSportRankOutput(athlete, sportRepository.findAllByAthleteIdAndTrainerId(athlete.getId(), trainerId))).toList();
    }

    @Transactional
    public List<AthleteSportRankOutput> findByTrainerIdAndRankId(int trainerId, int rankId) {
        List<Athlete> athletes = athleteRepository.findAllByTrainerIdAndRankId(trainerId, rankId);
        return athletes.stream().map(athlete -> athleteMapper
                .toAthleteSportRankOutput(athlete, sportRepository.findAllByAthleteIdAndTrainerIdAndRankId(athlete.getId(), trainerId, rankId))).toList();
    }
}
