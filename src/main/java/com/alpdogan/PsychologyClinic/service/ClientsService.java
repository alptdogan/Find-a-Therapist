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
    public Clients getClientById(int _id) {
        return clientsRepository.findBy_id(_id);
    }

    @Transactional
    public String createClient(Clients clients) {
        clientsRepository.save(clients);
        return "Client Added with id: " + clients.get_id();
    }

    @Transactional
    public void updateClientById(int _id, Clients clients) {
        clients.set_id(_id);
        clientsRepository.save(clients);
    }

    @Transactional
    public void deleteClient(int _id) {
        clientsRepository.delete(clientsRepository.findBy_id(_id));
    }

}
