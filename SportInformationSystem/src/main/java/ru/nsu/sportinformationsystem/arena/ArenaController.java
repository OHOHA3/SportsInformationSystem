package ru.nsu.sportinformationsystem.arena;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/sport_places/arenas")
public class ArenaController {
    private final ArenaService arenaService;

    @Autowired
    public ArenaController(ArenaService arenaService) {
        this.arenaService = arenaService;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("arenas", arenaService.findAll());
        return "sportPlace/arena/allArenas";
    }

    @GetMapping("/by_area")
    public String listByArea(Model model, @RequestParam(value = "min_area", required = false) Integer area) {
        if (area == null) {
            area = 0;
        }
        model.addAttribute("minArea", area);
        model.addAttribute("arenas", arenaService.findByMinArea(area));
        return "sportPlace/arena/arenasByArea";
    }
}
