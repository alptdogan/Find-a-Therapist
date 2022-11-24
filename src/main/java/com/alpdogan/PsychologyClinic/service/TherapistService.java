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

    public List<Clients> getClientByFirstName(String firstName) {
        return therapistRepository.findByFirstName(firstName);
    }
    @Transactional
    public List<Therapist> getAllTherapists() {
        return this.therapistRepository.findAll();
    }
    @Transactional
    public Therapist getTherapistById(int _id) {
        return therapistRepository.findBy_id(_id);
    }

    @Transactional
    public String createTherapist(Therapist therapist) {
        therapistRepository.save(therapist);
        return "Therapist Added with id: " + therapist.get_id();
    }

    @Transactional
    public void updateTherapistById(int _id, Therapist therapist) {
        therapist.set_id(_id);
        therapistRepository.save(therapist);
    }

    @Transactional
    public void deleteTherapist(int _id) {
        therapistRepository.delete(therapistRepository.findBy_id(_id));
    }

}
