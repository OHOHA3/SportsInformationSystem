package ru.nsu.sportinformationsystem.court;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
