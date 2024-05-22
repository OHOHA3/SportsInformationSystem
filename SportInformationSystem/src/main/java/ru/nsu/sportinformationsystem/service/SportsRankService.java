package ru.nsu.sportinformationsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.nsu.sportinformationsystem.model.SportsRank;
import ru.nsu.sportinformationsystem.repository.SportsRankRepository;

import java.util.List;

@Service
public class SportsRankService {
    private final SportsRankRepository sportsRankRepository;

    @Autowired
    public SportsRankService(SportsRankRepository sportsRankRepository) {
        this.sportsRankRepository = sportsRankRepository;
    }

    public List<SportsRank> findAll() {
        return (List<SportsRank>) sportsRankRepository.findAll();
    }

    public SportsRank getById(int id) {
        return sportsRankRepository.findById(id).orElse(null);
    }
}
