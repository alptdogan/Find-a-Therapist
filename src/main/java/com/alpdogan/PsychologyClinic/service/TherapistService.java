package com.alpdogan.PsychologyClinic.service;

import com.alpdogan.PsychologyClinic.entity.Clients;
import com.alpdogan.PsychologyClinic.repository.TherapistRepository;
import com.alpdogan.PsychologyClinic.entity.Therapist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TherapistService {

    @Autowired
    public TherapistRepository therapistRepository;

    public Therapist getTherapistByUsername(String username) {
        return therapistRepository.findByUsername(username);
    }

    public List<Clients> getClientByFirstName(String firstName) {
        return therapistRepository.findByFirstName(firstName);
    }
    @Transactional
    public List<Therapist> getAllTherapists() {
        return this.therapistRepository.findAll();
    }
    @Transactional
    public Therapist getTherapistById(int id) {
        return therapistRepository.findById(id);
    }

    @Transactional
    public String createTherapist(Therapist therapist) {
        therapistRepository.save(therapist);
        return "Therapist Added with id: " + therapist.getId();
    }

    @Transactional
    public void updateTherapistById(int id, Therapist therapist) {
        therapist.setId(id);
        therapistRepository.save(therapist);
    }

    @Transactional
    public void deleteTherapist(int id) {
        therapistRepository.delete(therapistRepository.findById(id));
    }

}
