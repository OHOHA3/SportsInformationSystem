package ru.nsu.sportinformationsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.nsu.sportinformationsystem.model.Court;
import ru.nsu.sportinformationsystem.outputModel.CourtCoatingOutput;
import ru.nsu.sportinformationsystem.repository.CourtRepository;

import java.util.List;

@Service
public class CourtService {
    private final CourtRepository courtRepository;

    @Autowired
    public CourtService(CourtRepository courtRepository) {
        this.courtRepository = courtRepository;
    }
    public List<CourtCoatingOutput> findAllWithCoating() {
        return courtRepository.findAllWithCoating();
    }
    public List<Court> findByCoatingTypeId(int coatingTypeId) {
        return courtRepository.findAllByCoatingTypeId(coatingTypeId);
    }
}
