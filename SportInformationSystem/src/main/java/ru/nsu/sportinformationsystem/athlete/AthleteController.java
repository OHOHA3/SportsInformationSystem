package ru.nsu.sportinformationsystem.athlete;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.nsu.sportinformationsystem.athleteSport.AthleteSportService;
import ru.nsu.sportinformationsystem.sport.SportService;
import ru.nsu.sportinformationsystem.sportClub.SportClubService;
import ru.nsu.sportinformationsystem.sportsRank.SportsRankService;
import ru.nsu.sportinformationsystem.trainer.TrainerService;

@Controller
@RequestMapping("/athletes")
public class AthleteController {
    private final AthleteService athleteService;
    private final SportClubService sportClubService;
    private final AthleteSportService athleteSportService;
    private final SportService sportService;
    private final SportsRankService sportsRankService;
    private final TrainerService trainerService;

    @Autowired
    public AthleteController(AthleteService athleteService, SportClubService sportClubService, AthleteSportService athleteSportService, SportService sportService, SportsRankService sportsRankService, TrainerService trainerService) {
        this.athleteService = athleteService;
        this.sportClubService = sportClubService;
        this.athleteSportService = athleteSportService;
        this.sportService = sportService;
        this.sportsRankService = sportsRankService;
        this.trainerService = trainerService;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("athletes", athleteService.findAll());
        model.addAttribute("sportsCount", 1);
        model.addAttribute("sports", sportService.findAll());
        model.addAttribute("ranks", sportsRankService.findAll());
        model.addAttribute("trainers", trainerService.findAll());
        return "athlete/allAthletes";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        Athlete athlete = athleteService.getById(id);
        model.addAttribute("athlete", athlete);
        if (athlete.getClubId() != null) {
            model.addAttribute("sportClub", sportClubService.getById(athlete.getClubId()));
        }
        return "athlete/athletePage";
    }

    @GetMapping("/new")
    public String newAthlete(@ModelAttribute("athlete") Athlete athlete, Model model) {
        model.addAttribute("sportClubs", sportClubService.makeDefaultDropList());
        return "athlete/newAthlete";
    }

    @PostMapping()
    public String create(@ModelAttribute("athlete") Athlete athlete) {
        athleteService.save(athlete);
        return "redirect:/athletes";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        Athlete athlete = athleteService.getById(id);
        model.addAttribute("athlete", athlete);
        model.addAttribute("sportClubs", sportClubService.makeDropListForAthlete(athlete.getClubId()));
        return "athlete/editAthlete";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("athlete") Athlete athlete, @PathVariable("id") int id) {
        athleteService.update(id, athlete);
        return "redirect:/athletes";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id) {
        athleteService.delete(id);
        return "redirect:/athletes";
    }

    @GetMapping("/by_sports_count")
    public String listBySportsCount(Model model, @RequestParam("count") int count) {
        model.addAttribute("count", count);
        model.addAttribute("athletes", athleteSportService.findBySportsCount(count));
        return "athlete/athletesBySportsCount";
    }

    @GetMapping("/by_sport")
    public String listBySport(Model model, @RequestParam("sport_id") int sportId, @RequestParam(value = "rank_id", required = false) Integer rankId) {
        model.addAttribute("sport", sportService.getById(sportId).getName());
        if (rankId == null) {
            model.addAttribute("athletes", athleteService.findBySportId(sportId));
            model.addAttribute("rank", null);
        } else {
            model.addAttribute("athletes", athleteService.findBySportIdAndRankId(sportId, rankId));
            model.addAttribute("rank", sportsRankService.getById(rankId).getName());
        }
        return "athlete/athletesBySport";
    }

    @GetMapping("/by_trainer")
    public String listByTrainer(Model model, @RequestParam("trainer_id") int trainerId, @RequestParam(value = "rank_id", required = false) Integer rankId) {
        model.addAttribute("trainer", trainerService.getById(trainerId));
        if (rankId == null) {
            model.addAttribute("athletes", athleteSportService.findByTrainerId(trainerId));
            model.addAttribute("rank", null);
        } else {
            model.addAttribute("athletes", athleteSportService.findByTrainerIdAndRankId(trainerId, rankId));
            model.addAttribute("rank", sportsRankService.getById(rankId).getName());
        }
        return "athlete/athletesByTrainer";
    }

    @GetMapping("/by_competition_date")
    public String listByDates(Model model, @RequestParam("from") String from, @RequestParam("to") String to) {
        model.addAttribute("from", from);
        model.addAttribute("to", to);
        model.addAttribute("athletes", athleteService.findByCompetitionDate(from, to));
        return "athlete/athletesDidNotParticipate";
    }
}
