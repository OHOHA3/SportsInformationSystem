package ru.nsu.sportinformationsystem.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter
@Setter
public class SportPlace {
    @Id
    private int id;
    private String name;
    private int typeId;
    private String address;
}
