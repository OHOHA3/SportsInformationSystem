package ru.nsu.sportinformationsystem.sportPlace;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("sport_places")
public class SportPlaceController {
    private final SportPlaceService sportPlaceService;

    @Autowired
    public SportPlaceController(SportPlaceService sportPlaceService) {
        this.sportPlaceService = sportPlaceService;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("places", sportPlaceService.findAll());
        return "sportPlace/allSportPlaces";
    }

    @GetMapping("/by_date")
    public String listByDate(Model model, @RequestParam("from") String from, @RequestParam("to") String to) {
        model.addAttribute("from", from);
        model.addAttribute("to", to);
        model.addAttribute("places", sportPlaceService.findByCompetitionDate(from, to));
        return "sportPlace/sportPlacesByDate";
    }
}
