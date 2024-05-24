package ru.nsu.sportinformationsystem.coatingType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoatingTypeService {
    private final CoatingTypeRepository coatingTypeRepository;

    @Autowired
    public CoatingTypeService(CoatingTypeRepository coatingTypeRepository) {
        this.coatingTypeRepository = coatingTypeRepository;
    }

    public List<CoatingType> findAll() {
        return (List<CoatingType>) coatingTypeRepository.findAll();
    }

    public CoatingType getById(int id) {
        return coatingTypeRepository.findById(id).orElse(null);
    }
}
