package com.example.projectCRM.controller.dto;

import com.example.projectCRM.model.Client;
import com.example.projectCRM.model.StateOrder;

public class OrderDTO {
    private Integer id;
    private String type;
    private String designation;
    private Integer days;
    private Double unitPrice;
    private Double totalPriceBeforeTaxes;
    private Double totalPriceAfterTaxes;
    private StateOrder state;
    private ClientDTO client;

    public OrderDTO() {
    }

    public OrderDTO(String type, String designation, Integer days, Double unitPrice,
                    Double totalPriceBeforeTaxes, Double totalPriceAfterTaxes,
                    StateOrder state, ClientDTO client) {
        this.type = type;
        this.designation = designation;
        this.days = days;
        this.unitPrice = unitPrice;
        this.totalPriceBeforeTaxes = totalPriceBeforeTaxes;
        this.totalPriceAfterTaxes = totalPriceAfterTaxes;
        this.state = state;
        this.client = client;
    }

    public OrderDTO(Integer id, String type, String designation,
                    Integer days, Double unitPrice, Double totalPriceBeforeTaxes,
                    Double totalPriceAfterTaxes, StateOrder state, ClientDTO client) {
        this.id = id;
        this.type = type;
        this.designation = designation;
        this.days = days;
        this.unitPrice = unitPrice;
        this.totalPriceBeforeTaxes = totalPriceBeforeTaxes;
        this.totalPriceAfterTaxes = totalPriceAfterTaxes;
        this.state = state;
        this.client = client;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public Integer getDays() {
        return days;
    }

    public void setDays(Integer days) {
        this.days = days;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Double getTotalPriceBeforeTaxes() {
        return totalPriceBeforeTaxes;
    }

    public void setTotalPriceBeforeTaxes(Double totalPriceBeforeTaxes) {
        this.totalPriceBeforeTaxes = totalPriceBeforeTaxes;
    }

    public Double getTotalPriceAfterTaxes() {
        return totalPriceAfterTaxes;
    }

    public void setTotalPriceAfterTaxes(Double totalPriceAfterTaxes) {
        this.totalPriceAfterTaxes = totalPriceAfterTaxes;
    }

    public StateOrder getState() {
        return state;
    }

    public void setState(StateOrder state) {
        this.state = state;
    }

    public ClientDTO getClient() {
        return client;
    }

    public void setClient(ClientDTO client) {
        this.client = client;
    }
}
