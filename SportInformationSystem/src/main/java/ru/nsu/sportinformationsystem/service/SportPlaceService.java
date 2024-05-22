package ru.nsu.sportinformationsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.nsu.sportinformationsystem.model.SportPlace;
import ru.nsu.sportinformationsystem.repository.SportPlaceRepository;

import java.util.List;

@Service
public class SportPlaceService {
    private final SportPlaceRepository sportPlaceRepository;
    @Autowired
    public SportPlaceService(SportPlaceRepository sportPlaceRepository) {
        this.sportPlaceRepository = sportPlaceRepository;
    }
    public List<SportPlace> findAll() {
        return (List<SportPlace>) sportPlaceRepository.findAll();
    }
    public SportPlace getById(int id) {
        return sportPlaceRepository.findById(id).orElse(null);
    }
}
