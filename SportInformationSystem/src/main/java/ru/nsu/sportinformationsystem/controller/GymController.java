package ru.nsu.sportinformationsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.nsu.sportinformationsystem.service.GymService;

@Controller
@RequestMapping("/sport_places/gyms")
public class GymController {
    private final GymService gymService;

    @Autowired
    public GymController(GymService gymService) {
        this.gymService = gymService;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("gyms", gymService.findAll());
        return "sportPlace/gym/allGyms";
    }
    @GetMapping("/by_simulators_count")
    public String listBySimulatorsCount(Model model, @RequestParam(value = "min_count", required = false) Integer minCount) {
        if (minCount == null) {
            minCount = 0;
        }
        model.addAttribute("minCount", minCount);
        model.addAttribute("gyms", gymService.findByMinSimulatorsCount(minCount));
        return "sportPlace/gym/gymsBySimulatorsCount";
    }
}
