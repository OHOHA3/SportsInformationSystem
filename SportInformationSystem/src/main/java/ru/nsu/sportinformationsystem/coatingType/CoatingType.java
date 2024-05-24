package ru.nsu.sportinformationsystem.coatingType;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter
@Setter
public class CoatingType {
    @Id
    private int id;
    private String name;
}
