package ru.nsu.sportinformationsystem.stadium;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/sport_places/stadiums")
public class StadiumController {
    private final StadiumService stadiumService;

    @Autowired
    public StadiumController(StadiumService stadiumService) {
        this.stadiumService = stadiumService;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("stadiums", stadiumService.findAll());
        return "sportPlace/stadium/allStadiums";
    }

    @GetMapping("/by_capacity")
    public String listByCapacity(Model model, @RequestParam(value = "min_capacity", required = false) Integer minCapacity) {
        if (minCapacity == null) {
            minCapacity = 0;
        }
        model.addAttribute("minCapacity", minCapacity);
        model.addAttribute("stadiums", stadiumService.findByMinCapacity(minCapacity));
        return "sportPlace/stadium/stadiumsByCapacity";
    }
}
