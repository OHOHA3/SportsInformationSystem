package ru.nsu.sportinformationsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.nsu.sportinformationsystem.service.SportClubService;

import java.time.LocalDate;

@Controller
@RequestMapping("/sport_clubs")
public class SportClubController {
    private final SportClubService sportClubService;
    @Autowired
    public SportClubController(SportClubService sportClubService) {
        this.sportClubService = sportClubService;
    }
    @GetMapping()
    public String index(Model model) {
        model.addAttribute("sportClubs", sportClubService.findAll());
        return "sportClub/allSportClubs";
    }
    @GetMapping("/by_date")
    public String listByDate(Model model, @RequestParam("from") String from, @RequestParam("to") String to) {
        model.addAttribute("from", from);
        model.addAttribute("to", to);
        LocalDate dateFrom = from.isEmpty() ? LocalDate.now().minusYears(100) : LocalDate.parse(from);
        LocalDate dateTo = to.isEmpty() ? LocalDate.now() : LocalDate.parse(to);
        model.addAttribute("sportClubs", sportClubService.findByDate(dateFrom, dateTo));
        return "sportClub/sportClubsByDate";
    }
}
