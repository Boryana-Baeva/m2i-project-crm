package com.example.projectCRM.controller;

import com.example.projectCRM.model.Client;
import com.example.projectCRM.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api")
public class ClientController {
    @Autowired
    private ClientService clientService;

    @GetMapping("clients")
    public List<Client> getAllClients() {
        return clientService.getAll();
    }

    @PostMapping("clients")
    public ResponseEntity<?> save(@RequestBody Client client) {
        List<String> errors = getPostErrors(client);
        if(!errors.isEmpty()) {
            return ResponseEntity.badRequest().body(errors.toString());
        }
        else {
            clientService.save(client);
            return ResponseEntity.ok(client);
        }
    }

    private List<String> getPostErrors(Client client) {
        List<String> errors = new ArrayList<>();

        if(client.getFirstName() == null || client.getFirstName().isBlank()) {
            errors.add("Missing First Name !");
        }

        if(client.getLastName() == null || client.getLastName().isBlank()) {
            errors.add("Missing Last Name !");
        }

        if(client.getEmail() == null || client.getEmail().isBlank()) {
            errors.add("Missing Email !");
        }

        if(clientService.getAll().stream()
                .anyMatch(c -> client.getEmail().equals(c.getEmail()))) {
            errors.add("A client with this email address already exists !");
        }

        return errors;
    }

}
