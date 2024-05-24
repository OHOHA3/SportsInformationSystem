package ru.nsu.sportinformationsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.nsu.sportinformationsystem.model.Gym;
import ru.nsu.sportinformationsystem.repository.GymRepository;

import java.util.List;

@Service
public class GymService {
    private final GymRepository gymRepository;

    @Autowired
    public GymService(GymRepository gymRepository) {
        this.gymRepository = gymRepository;
    }
    public List<Gym> findAll() {
        return gymRepository.findAll();
    }
    public List<Gym> findByMinSimulatorsCount(int simulatorsCount) {
        return gymRepository.findAllBySimulatorsCountGreaterThanEqual(simulatorsCount);
    }
}
