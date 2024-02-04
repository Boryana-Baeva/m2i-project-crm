package com.example.projectCRM.service;

import com.example.projectCRM.model.Client;
import com.example.projectCRM.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getAll() {
        return clientRepository.findAll();
    }

    public Optional<Client> getById(Integer id) {
        return clientRepository.findById(id);
    }

    public void save(Client client) {
        clientRepository.save(client);
    }

    public void delete(Client client) {
        clientRepository.delete(client);
    }

    public void delete(Integer id) {
        clientRepository.deleteById(id);
    }

    public void update(Client client) {
        clientRepository.save(client);
    }

    public List<String> getInputErrors(Client client, boolean isPostMethod) {
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

        if(isPostMethod && this.getAll().stream()
                .anyMatch(c -> client.getEmail().equals(c.getEmail()))) {
            errors.add("A client with this email address already exists !");
        }

        return errors;
    }

}
