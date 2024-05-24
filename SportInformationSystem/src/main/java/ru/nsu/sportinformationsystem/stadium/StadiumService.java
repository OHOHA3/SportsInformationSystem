package ru.nsu.sportinformationsystem.stadium;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StadiumService {
    private final StadiumRepository stadiumRepository;

    @Autowired
    public StadiumService(StadiumRepository stadiumRepository) {
        this.stadiumRepository = stadiumRepository;
    }

    public List<Stadium> findAll() {
        return stadiumRepository.findAll();
    }

    public List<Stadium> findByMinCapacity(int capacity) {
        return stadiumRepository.findAllByCapacityGreaterThanEqual(capacity);
    }
}
