package ru.nsu.sportinformationsystem.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@Setter
@Table("gym_info")
public class Gym extends SportPlace {
    private int simulatorsCount;
}