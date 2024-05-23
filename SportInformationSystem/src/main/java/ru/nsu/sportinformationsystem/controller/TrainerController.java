package ru.nsu.sportinformationsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.nsu.sportinformationsystem.service.AthleteService;
import ru.nsu.sportinformationsystem.service.SportService;
import ru.nsu.sportinformationsystem.service.TrainerAthleteService;
import ru.nsu.sportinformationsystem.service.TrainerService;

@Controller
@RequestMapping("/trainers")
public class TrainerController {
    private final TrainerService trainerService;
    private final AthleteService athleteService;
    private final TrainerAthleteService trainerAthleteService;
    private final SportService sportService;

    @Autowired
    public TrainerController(TrainerService trainerService, AthleteService athleteService, TrainerAthleteService trainerAthleteService, SportService sportService) {
        this.trainerService = trainerService;
        this.athleteService = athleteService;
        this.trainerAthleteService = trainerAthleteService;
        this.sportService = sportService;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("trainers", trainerService.findAll());
        model.addAttribute("athletes", athleteService.findAll());
        model.addAttribute("sports", sportService.findAll());
        return "trainer/allTrainers";
    }

    @GetMapping("/by_athlete")
    public String listByAthlete(Model model, @RequestParam("athlete_id") int athleteId) {
        model.addAttribute("athlete", athleteService.getById(athleteId));
        model.addAttribute("trainers", trainerAthleteService.findByAthleteId(athleteId));
        return "trainer/trainersByAthlete";
    }

    @GetMapping("/by_sport")
    public String listBySport(Model model, @RequestParam("sport_id") int sportId) {
        model.addAttribute("sport", sportService.getById(sportId).getName());
        model.addAttribute("trainers", trainerService.findBySportId(sportId));
        return "trainer/trainersBySport";
    }
}
