package com.alpdogan.PsychologyClinic.controller;

import com.alpdogan.PsychologyClinic.entity.Clients;
import com.alpdogan.PsychologyClinic.entity.Therapist;
import com.alpdogan.PsychologyClinic.service.ClientsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientsController {

    @Autowired
    private ClientsService clientsService;

    @GetMapping("/all")
    public ResponseEntity<List<Clients>> getAllClients() {
        List<Clients> clients = clientsService.getAllClients();
        return new ResponseEntity<>(clients, HttpStatus.OK);
    }

    @GetMapping("/get/{_id}")
    public ResponseEntity<Clients> getClientById(@PathVariable("id") int id) {
       Clients clients = clientsService.getClientById(id);
        return new ResponseEntity<>(clients, HttpStatus.OK);
    }

    @ResponseBody
    @PostMapping("/add")
    public ResponseEntity<Clients> addClient(@RequestBody Clients clients) {
        clientsService.createClient(clients);
        return new ResponseEntity<>(clients, HttpStatus.OK);
    }

    @ResponseBody
    @PutMapping("/update/{_id}")
    public ResponseEntity<String> updateClient(@PathVariable("id") int id, @RequestBody Clients clients) {
        clientsService.updateClientById(id, clients);
        String saveText = clients + " is updated.";
        return new ResponseEntity<>(saveText, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{_id}")
    public ResponseEntity<String> deleteClient(@PathVariable("id") int id) {
        clientsService.deleteClient(id);
        String deleteText = "The client has been deleted.";
        return new ResponseEntity<>(deleteText, HttpStatus.OK);
    }

}


















