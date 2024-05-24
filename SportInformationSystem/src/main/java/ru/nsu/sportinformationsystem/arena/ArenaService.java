package ru.nsu.sportinformationsystem.arena;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
