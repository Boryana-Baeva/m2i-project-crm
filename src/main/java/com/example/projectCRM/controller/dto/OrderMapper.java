package com.example.projectCRM.controller.dto;

import com.example.projectCRM.model.Order;

public class OrderMapper {
    public static OrderDTO toDTO(Order entity) {
        OrderDTO dto = new OrderDTO();

        dto.setType(entity.getTypePresta());
        dto.setDesignation(entity.getDesignation());
        dto.setDays(entity.getNbDays());
        dto.setUnitPrice(entity.getUnitPrice());
        dto.setTotalPriceBeforeTaxes(entity.getTotalExcludeTaxe());
        dto.setTotalPriceAfterTaxes(entity.getTotalWithTaxe());
        dto.setState(entity.getState());
        if(entity.getClient() != null)
            dto.setClient(ClientMapper.toDTO(entity.getClient()));

        return dto;
    }

    public static Order toEntity(OrderDTO dto) {
        Order entity = new Order();

        entity.setTypePresta(dto.getType());
        entity.setDesignation(dto.getDesignation());
        entity.setNbDays(dto.getDays());
        entity.setUnitPrice(dto.getUnitPrice());
        entity.setState(dto.getState());
        entity.getTotalExcludeTaxe();
        entity.getTotalWithTaxe();

        if(dto.getClient() != null)
            entity.setClient(ClientMapper.toEntity(dto.getClient()));

        return entity;
    }
}
