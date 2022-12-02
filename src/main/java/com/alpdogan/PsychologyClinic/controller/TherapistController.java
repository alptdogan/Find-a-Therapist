package com.alpdogan.PsychologyClinic.controller;

import com.alpdogan.PsychologyClinic.entity.Clients;
import com.alpdogan.PsychologyClinic.entity.Therapist;
import com.alpdogan.PsychologyClinic.service.ClientsService;
import com.alpdogan.PsychologyClinic.service.TherapistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/therapists")
public class TherapistController {

    @Autowired
    private TherapistService therapistService;

    @GetMapping
    public String displayTherapists(Model model) {

        List<Therapist> therapists = therapistService.getAllTherapists();
        model.addAttribute("therapist", therapists);

        return "list-therapists";

    }

    @GetMapping("/register")
    public String registerTherapist(Model model) {

        Therapist therapist = new Therapist();
        model.addAttribute("therapist", therapist);

        return "new-therapist";

    }

    @GetMapping("/new")
    public String displayTherapistForm (Model model) {

        Therapist therapist = new Therapist();
        model.addAttribute("therapist", therapist);

        return "new-therapist";

    }

    @PostMapping("/addTherapist")
    public String createTherapist (@ModelAttribute ("therapist") Therapist therapist) {

        therapistService.createTherapist(therapist);

        return "redirect:/therapists";

    }

    @GetMapping("/update")
    public String displayTherapistUpdateForm(@RequestParam("id") int id, Model model) {

        Therapist therapist = therapistService.getTherapistById(id);
        model.addAttribute("therapist", therapist);

        return "new-therapist";

    }

    @GetMapping("/delete")
    public String deleteTherapist(@RequestParam("id") int id, Model model) {

        therapistService.deleteTherapist(id);

        return "redirect:/therapists";

    }

    @GetMapping("/details")
    public String displayTherapistDetails(@RequestParam("id") int id, Model model) {

        Therapist therapists = therapistService.getTherapistById(id);
        model.addAttribute("therapist", therapists);

        return "therapist-details";

    }

}


















