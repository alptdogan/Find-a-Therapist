package com.alpdogan.PsychologyClinic.service;

import com.alpdogan.PsychologyClinic.entity.Clients;
import com.alpdogan.PsychologyClinic.repository.ClientsRepository;
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

    @Autowired
    public ClientsRepository clientsRepository;

    public List<Clients> getClientById(int id) {
        return therapistRepository.findClientsById(id);
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
    public Therapist createTherapist(Therapist therapist) {
        if (therapist.getClients() != null && therapist.getClients().size() > 0) {
            clientsRepository.saveAll(therapist.getClients());
        }

        return therapistRepository.save(therapist);
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
