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

    @Autowired
    private ClientsService clientsService;

    @GetMapping
    public String displayTherapists(Model model) {

        List<Therapist> therapists = therapistService.getAllTherapists();
        model.addAttribute("therapists", therapists);

        return "list-therapists";

    }

    @GetMapping("/new")
    public String displayTherapistForm (Model model) {

        Therapist therapist = new Therapist();
        List<Clients> clients = clientsService.getAllClients();

        model.addAttribute("therapist", therapist);
        model.addAttribute("allClients", clients);

        return "new-therapist";

    }

    @PostMapping("/addTherapist")
    public String createTherapist (@ModelAttribute ("therapist") Therapist therapist) {

        therapistService.createTherapist(therapist);

        return "redirect:/therapists";

    }

    @ResponseBody
    @GetMapping("/update/{id}")
    public String displayTherapistUpdateForm(@PathVariable("id") int id, @RequestBody Therapist therapist, Model model) {

        therapistService.updateTherapistById(id, therapist);
        List<Clients> clients = clientsService.getAllClients();

        model.addAttribute("therapist", therapist);
        model.addAttribute("allClients", clients);

        return "redirect:/therapists";

    }

    @GetMapping("/delete/{id}")
    public String deleteTherapist(@PathVariable("id") int id, Model model) {

        therapistService.getTherapistById(id);
        therapistService.deleteTherapist(id);

        return "redirect:/therapists";

    }

}


















