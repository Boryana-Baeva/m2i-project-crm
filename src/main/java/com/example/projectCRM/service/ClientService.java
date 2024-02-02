package com.example.projectCRM.service;

import com.example.projectCRM.model.Client;
import com.example.projectCRM.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}
