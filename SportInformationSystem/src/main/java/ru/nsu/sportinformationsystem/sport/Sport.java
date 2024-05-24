package ru.nsu.sportinformationsystem.sport;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class Sport {
    @Id
    private int id;
    private String name;
    private String description;
}
