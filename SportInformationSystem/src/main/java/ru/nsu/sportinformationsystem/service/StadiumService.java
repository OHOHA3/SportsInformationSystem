package ru.nsu.sportinformationsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.nsu.sportinformationsystem.model.Stadium;
import ru.nsu.sportinformationsystem.repository.StadiumRepository;

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
