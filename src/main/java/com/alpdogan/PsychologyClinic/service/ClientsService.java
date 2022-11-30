package com.alpdogan.PsychologyClinic.service;


import com.alpdogan.PsychologyClinic.entity.Clients;
import com.alpdogan.PsychologyClinic.repository.ClientsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
public class ClientsService {

    @Autowired
    private ClientsRepository clientsRepository;

    @Transactional
    public List<Clients> getAllClients() {
        return this.clientsRepository.findAll();
    }
    @Transactional
    public Clients getClientById(int id) {
        return clientsRepository.findById(id);
    }

    @Transactional
    public void createClient(Clients clients) {
        clientsRepository.save(clients);
    }

    @Transactional
    public void updateClientById(int id, Clients clients) {
        clients.setId(id);
        clientsRepository.save(clients);
    }

    @Transactional
    public void deleteClient(int id) {
        clientsRepository.delete(clientsRepository.findById(id));
    }

}
