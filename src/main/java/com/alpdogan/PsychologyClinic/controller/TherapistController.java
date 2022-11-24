package com.alpdogan.PsychologyClinic.controller;

import com.alpdogan.PsychologyClinic.entity.Clients;
import com.alpdogan.PsychologyClinic.entity.Therapist;
import com.alpdogan.PsychologyClinic.service.TherapistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/therapist")
public class TherapistController {

    @Autowired
    private TherapistService therapistService;

    @GetMapping("/clients")
    public List<Clients> getClientByFirstName(@PathVariable String firstName) {
        return therapistService.getClientByFirstName(firstName);
    }

    @GetMapping("/all")
    public List<Therapist> getAllTherapists() {
        return therapistService.getAllTherapists();
    }

    @GetMapping("/get/{_id}")
    public Therapist getTherapistById(@PathVariable("id") int id) {
        Therapist therapist = therapistService.getTherapistById(id);
        return therapist;
    }

    @ResponseBody
    @PostMapping("/add")
    public Therapist addTherapist(@RequestBody Therapist therapist) {
        therapistService.createTherapist(therapist);
        return therapist;
    }

    @ResponseBody
    @PutMapping("/update/{_id}")
    public String updateTherapist(@PathVariable("id") int id, @RequestBody Therapist therapist) {
        therapistService.updateTherapistById(id, therapist);
        return therapist + " is updated.";
    }

    @DeleteMapping("/delete/{_id}")
    public String deleteTherapist(@PathVariable("id") int id) {
        therapistService.deleteTherapist(id);
        return "The therapist has been deleted.";
    }

}


















