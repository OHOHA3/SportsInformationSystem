package ru.nsu.sportinformationsystem.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@Setter
@Table("arena_info")
public class Arena extends SportPlace {
    private int area;
}
