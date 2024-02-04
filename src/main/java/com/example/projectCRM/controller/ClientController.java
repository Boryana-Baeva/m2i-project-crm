package com.example.projectCRM.controller;

import com.example.projectCRM.controller.dto.ClientDTO;
import com.example.projectCRM.controller.dto.ClientMapper;
import com.example.projectCRM.controller.dto.ClientUpdateDTO;
import com.example.projectCRM.model.Client;
import com.example.projectCRM.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api")
public class ClientController {
    @Autowired
    private ClientService clientService;

    @GetMapping("clients")
    public List<ClientDTO> getAllClients() {
        return clientService.getAll()
                .stream().map(ClientMapper::toDTO)
                .toList();
    }

    @PostMapping("clients")
    public ResponseEntity<?> save(@RequestBody Client client) {
        List<String> errors = clientService.getInputErrors(client, true);

        if(!errors.isEmpty()) {
            return ResponseEntity.badRequest().body(errors.toString());
        }
        else {
            clientService.save(client);
            return ResponseEntity.ok(client);
        }
    }

    @PostMapping("clients/dto")
    public ResponseEntity<?> save(@RequestBody ClientDTO clientDTO) {
        Client client = ClientMapper.toEntity(clientDTO);
        List<String> errors = clientService.getInputErrors(client, true);

        if(!errors.isEmpty()) {
            return ResponseEntity.badRequest().body(errors.toString());
        }
        else {
            clientService.save(client);
            ClientDTO response = ClientMapper.toDTO(client);
            return ResponseEntity.ok(response);
        }
    }

    @GetMapping("clients/{id}")
    public ResponseEntity<?> getClientById(@PathVariable Integer id) {
        Optional<Client> optional = clientService.getById(id);

        if(optional.isPresent()) {
            ClientDTO dto = ClientMapper.toDTO(optional.get());
            return ResponseEntity.ok(dto);
        }
        else {
            return ResponseEntity.badRequest().body("No existing client with id " + id + " !");
        }
    }

    @DeleteMapping("clients/{id}")
    public ResponseEntity<?> deleteClient(@PathVariable Integer id) {
        Optional<Client> optional = clientService.getById(id);

        if(optional.isPresent()) {
            clientService.delete(optional.get());
            return ResponseEntity.ok("Successfully deleted the client with id " + id + " !");
        }
        else {
            return ResponseEntity.badRequest().body("No existing client with id " + id + " !");
        }
    }

    @PutMapping("clients/{id}")
    public ResponseEntity<?> updateClient(@RequestBody ClientUpdateDTO dto, @PathVariable("id") Integer id) {
        Client client = ClientMapper.toUpdateEntity(dto);

        if(!id.equals(client.getId())) {
            return ResponseEntity.badRequest().body("ID Mismatch!");
        }
        else {
            List<String> errors = clientService.getInputErrors(client, false);

            if(!errors.isEmpty()) {
                return ResponseEntity.badRequest().body(errors.toString());
            }
            else {
                clientService.update(client);
                ClientDTO response = ClientMapper.toDTO(client);
                return ResponseEntity.ok(response);
            }
        }

    }

}
