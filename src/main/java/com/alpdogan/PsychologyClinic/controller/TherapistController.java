package com.alpdogan.PsychologyClinic.controller;

import com.alpdogan.PsychologyClinic.entity.Clients;
import com.alpdogan.PsychologyClinic.entity.Therapist;
import com.alpdogan.PsychologyClinic.service.TherapistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/therapist")
public class TherapistController {

    @Autowired
    private TherapistService therapistService;

    @GetMapping("/clients")
    public ResponseEntity<List<Clients>> getClientByFirstName(@PathVariable String firstName) {
        List<Clients> clients =  therapistService.getClientByFirstName(firstName);
        return new ResponseEntity<>(clients, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Therapist>> getAllTherapists() {
        List<Therapist> therapists = therapistService.getAllTherapists();
        return new ResponseEntity<>(therapists, HttpStatus.OK);
    }

    @GetMapping("/get/{_id}")
    public ResponseEntity<Therapist> getTherapistById(@PathVariable("id") int id) {
        Therapist therapist = therapistService.getTherapistById(id);
        return new ResponseEntity<>(therapist, HttpStatus.OK);
    }

    @ResponseBody
    @PostMapping("/add")
    public ResponseEntity<Therapist> addTherapist(@RequestBody Therapist therapist) {
        therapistService.createTherapist(therapist);
        return new ResponseEntity<>(therapist, HttpStatus.OK);
    }

    @ResponseBody
    @PutMapping("/update/{_id}")
    public ResponseEntity<String> updateTherapist(@PathVariable("id") int id, @RequestBody Therapist therapist) {
        therapistService.updateTherapistById(id, therapist);
        String saveText = "The therapist has been updated.";
        return new ResponseEntity<>(saveText, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{_id}")
    public ResponseEntity<String> deleteTherapist(@PathVariable("id") int id) {
        therapistService.deleteTherapist(id);
        String deleteText = "The therapist has been deleted.";
        return new ResponseEntity<>(deleteText, HttpStatus.OK);
    }

}


















