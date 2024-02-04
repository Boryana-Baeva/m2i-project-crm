package com.example.projectCRM.controller.dto;

import com.example.projectCRM.model.Client;

public class ClientMapper {
    public static ClientDTO toDTO(Client client) {
        ClientDTO dto = new ClientDTO();

        dto.setCompany(client.getCompanyName());
        dto.setFirstName(client.getFirstName());
        dto.setLastName(client.getLastName());
        dto.setEmail(client.getEmail());
        dto.setPhone(client.getPhone());
        dto.setAddress(client.getAddress());
        dto.setZip(client.getZipCode());
        dto.setCity(client.getCity());
        dto.setCountry(client.getCountry());
        dto.setState(client.getState());

        return dto;
    }

    public static Client toEntity(ClientDTO dto) {
        Client entity = new Client();

        entity.setCompanyName(dto.getCompany());
        entity.setFirstName(dto.getFirstName());
        entity.setLastName(dto.getLastName());
        entity.setEmail(dto.getEmail());
        entity.setPhone(dto.getPhone());
        entity.setAddress(dto.getAddress());
        entity.setZipCode(dto.getZip());
        entity.setCity(dto.getCity());
        entity.setCountry(dto.getCountry());
        entity.setState(dto.getState());

        return entity;
    }

    public static ClientUpdateDTO toUpdateDTO(Client client) {
        ClientUpdateDTO dto = (ClientUpdateDTO)toDTO(client);
        dto.setId(client.getId());

        return dto;
    }

    public static Client toUpdateEntity(ClientUpdateDTO dto) {
        Client entity = toEntity(dto);
        entity.setId(dto.getId());

        return entity;
    }
}
