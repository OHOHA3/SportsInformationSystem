package ru.nsu.sportinformationsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.nsu.sportinformationsystem.service.*;

import java.time.LocalDate;

@Controller
@RequestMapping("/competitions")
public class CompetitionController {
    private final CompetitionService competitionService;
    private final OrganizerService organizerService;
    private final SportService sportService;
    private final SportPlaceService sportPlaceService;
    private final CompetitionAthleteService competitionAthleteService;

    @Autowired
    public CompetitionController(CompetitionService competitionService, OrganizerService organizerService, SportService sportService, SportPlaceService sportPlaceService, CompetitionAthleteService competitionAthleteService) {
        this.competitionService = competitionService;
        this.organizerService = organizerService;
        this.sportService = sportService;
        this.sportPlaceService = sportPlaceService;
        this.competitionAthleteService = competitionAthleteService;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("competitions", competitionService.findAll());
        model.addAttribute("organizers", organizerService.findAll());
        model.addAttribute("places", sportPlaceService.findAll());
        model.addAttribute("sports", sportService.findAll());
        return "competition/allCompetitions";
    }

    @GetMapping("/by_date")
    public String listByDates(Model model, @RequestParam("from") String from, @RequestParam("to") String to, @RequestParam(value = "organizer_id", required = false) Integer organizerId) {
        model.addAttribute("from", from);
        model.addAttribute("to", to);
        LocalDate dateFrom = from.isEmpty() ? LocalDate.now().minusYears(100) : LocalDate.parse(from);
        LocalDate dateTo = to.isEmpty() ? LocalDate.now() : LocalDate.parse(to);
        if (organizerId == null) {
            model.addAttribute("competitions", competitionService.findByCompetitionDate(dateFrom, dateTo));
            model.addAttribute("organizer", null);
        } else {
            model.addAttribute("competitions", competitionService.findByCompetitionDateAndTrainerId(dateFrom, dateTo, organizerId));
            model.addAttribute("organizers", organizerService.findAll());
        }
        return "competition/competitionsByDate";
    }

    @GetMapping("/by_place")
    public String listByPlace(Model model, @RequestParam("place_id") int placeId, @RequestParam(value = "sport_id", required = false) Integer sportId) {
        model.addAttribute("place", sportPlaceService.getById(placeId).getName());
        if (sportId == null) {
            model.addAttribute("competitions", competitionService.findByPlaceId(placeId));
            model.addAttribute("sport", null);
        } else {
            model.addAttribute("competitions", competitionService.findByPlaceIdAndSportId(placeId, sportId));
            model.addAttribute("sport", sportService.getById(sportId).getName());
        }
        return "competition/competitionsByPlace";
    }

    @GetMapping("/winners")
    public String listWinners(Model model,@RequestParam("competition_id") int competitionId) {
        model.addAttribute("competition", competitionService.getById(competitionId));
        model.addAttribute("winners", competitionAthleteService.findWinnersByCompetitionId(competitionId));
        return "competition/winners";
    }
}
