package com.alpdogan.PsychologyClinic.controller;

import com.alpdogan.PsychologyClinic.entity.Clients;
import com.alpdogan.PsychologyClinic.service.ClientsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/clients")
public class ClientsController {

    @Autowired
    private ClientsService clientsService;

    @GetMapping
    public String displayClients (Model model) {

        List<Clients> clients = clientsService.getAllClients();
        model.addAttribute("clients", clients);

        return "list-clients";

    }

    @GetMapping("/new")
    public String displayClientForm (Model model) {

        Clients clients = new Clients();
        model.addAttribute("clients", clients);

        return "new-client";

    }

    @PostMapping("/addClient")
    public String createClient (Model model, Clients client) {

        clientsService.createClient(client);

        return "redirect:/clients";

    }

    @GetMapping("/update")
    public String displayClientUpdateForm(@RequestParam("id") int id, Model model) {

        Clients clients = clientsService.getClientById(id);
        model.addAttribute("clients", clients);

        return "new-client";

    }

    @DeleteMapping("/delete")
    public String deleteClient(@RequestParam("id") int id, Model model) {

        clientsService.deleteClient(id);

        return "redirect:/clients";

    }



    /*

    @GetMapping("/get/{_id}")
    public ResponseEntity<Clients> getClientById(@PathVariable("id") int id) {
       Clients clients = clientsService.getClientById(id);
        return new ResponseEntity<>(clients, HttpStatus.OK);
    }

     */

}


















