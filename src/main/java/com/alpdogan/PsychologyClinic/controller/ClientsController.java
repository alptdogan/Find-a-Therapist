package com.alpdogan.PsychologyClinic.controller;

import com.alpdogan.PsychologyClinic.entity.Clients;
import com.alpdogan.PsychologyClinic.service.ClientsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientsController {

    @Autowired
    private ClientsService clientsService;

    @GetMapping("/all")
    public List<Clients> getAllClients() {
        return clientsService.getAllClients();
    }

    @GetMapping("/get/{_id}")
    public Clients getClientById(@PathVariable("id") int id) {
       Clients clients = clientsService.getClientById(id);
       return clients;
    }

    @ResponseBody
    @PostMapping("/add")
    public Clients addClient(@RequestBody Clients clients) {
        clientsService.createClient(clients);
        return clients;
    }

    @ResponseBody
    @PutMapping("/update/{_id}")
    public String updateClient(@PathVariable("id") int id, @RequestBody Clients clients) {
        clientsService.updateClientById(id, clients);
        return clients + " is updated.";
    }

    @DeleteMapping("/delete/{_id}")
    public String deleteClient(@PathVariable("id") int id) {
        clientsService.deleteClient(id);
        return "The client has been deleted.";
    }

}


















