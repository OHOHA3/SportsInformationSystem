package ru.nsu.sportinformationsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.nsu.sportinformationsystem.model.Arena;
import ru.nsu.sportinformationsystem.repository.ArenaRepository;

import java.util.List;

@Service
public class ArenaService {
    private final ArenaRepository arenaRepository;

    @Autowired
    public ArenaService(ArenaRepository arenaRepository) {
        this.arenaRepository = arenaRepository;
    }

    public List<Arena> findAll() {
        return arenaRepository.findAll();
    }
    public List<Arena> findByMinArea(int area) {
        return arenaRepository.findAllByAreaGreaterThanEqual(area);
    }
}
