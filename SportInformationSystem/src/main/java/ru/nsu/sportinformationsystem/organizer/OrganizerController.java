package ru.nsu.sportinformationsystem.organizer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/organizers")
public class OrganizerController {
    private final OrganizerService organizerService;

    @Autowired
    public OrganizerController(OrganizerService organizerService) {
        this.organizerService = organizerService;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("organizers", organizerService.findAll());
        return "organizer/allOrganizers";
    }

    @GetMapping("/by_date")
    public String indexByDate(Model model, @RequestParam("from") String from, @RequestParam("to") String to) {
        model.addAttribute("from", from);
        model.addAttribute("to", to);
        model.addAttribute("organizers", organizerService.findByDate(from, to));
        return "organizer/organizersByDate";
    }
}
