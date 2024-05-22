package ru.nsu.sportinformationsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.nsu.sportinformationsystem.mapper.AthleteSportMapper;
import ru.nsu.sportinformationsystem.model.Athlete;
import ru.nsu.sportinformationsystem.outputModel.AthleteRankOutput;
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
    private final AthleteSportMapper athleteSportMapper;

    @Autowired
    public AthleteSportService(AthleteRepository athleteRepository, SportRepository sportRepository, AthleteSportRepository athleteSportRepository, AthleteSportMapper athleteSportMapper) {
        this.athleteRepository = athleteRepository;
        this.sportRepository = sportRepository;
        this.athleteSportRepository = athleteSportRepository;
        this.athleteSportMapper = athleteSportMapper;
    }

    @Transactional
    public List<AthleteSportOutput> findAllBySportsCount(int count) {
        List<Athlete> athletes = athleteRepository.findAllBySportsCount(count);
        return athletes.stream().map(athlete -> athleteSportMapper
                .toAthleteSportOutput(athlete, sportRepository.findAllByAthleteId(athlete.getId()))).toList();
    }

    public List<AthleteRankOutput> findAllBySportId(int sportId) {
        return athleteSportRepository.findAllBySportId(sportId);
    }

    public List<AthleteRankOutput> findAllBySportIdAndRankId(int sportId, int rankId) {
        return athleteSportRepository.findAllBySportIdAndRankId(sportId, rankId);
    }

    @Transactional
    public List<AthleteSportRankOutput> findAllByTrainerId(int trainerId) {
        List<Athlete> athletes = athleteRepository.findAllByTrainerId(trainerId);
        return athletes.stream().map(athlete -> athleteSportMapper
                .toAthleteSportRankOutput(athlete, sportRepository.findAllByAthleteIdAndTrainerId(athlete.getId(), trainerId))).toList();
    }

    @Transactional
    public List<AthleteSportRankOutput> findAllByTrainerIdAndRankId(int trainerId, int rankId) {
        List<Athlete> athletes = athleteRepository.findAllByTrainerIdAndRankId(trainerId, rankId);
        return athletes.stream().map(athlete -> athleteSportMapper
                .toAthleteSportRankOutput(athlete, sportRepository.findAllByAthleteIdAndTrainerIdAndRankId(athlete.getId(), trainerId, rankId))).toList();
    }
}
