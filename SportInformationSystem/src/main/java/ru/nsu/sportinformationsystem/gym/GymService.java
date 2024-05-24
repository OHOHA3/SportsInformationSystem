package ru.nsu.sportinformationsystem.gym;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
