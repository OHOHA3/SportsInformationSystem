package ru.nsu.sportinformationsystem.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@Setter
@Table("stadium_info")
public class Stadium extends SportPlace {
    private int capacity;
}
