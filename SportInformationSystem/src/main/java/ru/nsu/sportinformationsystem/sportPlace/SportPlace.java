package ru.nsu.sportinformationsystem.sportPlace;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter
@Setter
public class SportPlace {
    @Id
    private int id;
    private String name;
    private String address;
    private int typeId;
}
