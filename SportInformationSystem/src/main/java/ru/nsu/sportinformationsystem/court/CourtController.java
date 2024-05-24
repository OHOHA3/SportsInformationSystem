package ru.nsu.sportinformationsystem.court;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.nsu.sportinformationsystem.coatingType.CoatingTypeService;

@Controller
@RequestMapping("/sport_places/courts")
public class CourtController {
    private final CourtService courtService;
    private final CoatingTypeService coatingTypeService;

    @Autowired
    public CourtController(CourtService courtService, CoatingTypeService coatingTypeService) {
        this.courtService = courtService;
        this.coatingTypeService = coatingTypeService;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("courts", courtService.findAllWithCoating());
        model.addAttribute("coatingTypes", coatingTypeService.findAll());
        return "sportPlace/court/allCourts";
    }

    @GetMapping("/by_coating_type")
    public String listByCoatingType(Model model, @RequestParam(value = "coating_type_id") Integer coatingTypeId) {
        model.addAttribute("coatingType", coatingTypeService.getById(coatingTypeId).getName());
        model.addAttribute("courts", courtService.findByCoatingTypeId(coatingTypeId));
        return "sportPlace/court/courtsByCoatingType";
    }
}
