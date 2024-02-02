package com.example.projectCRM.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "type_presta", nullable = false)
    private String typePresta;
    @Column(name = "designation")
    private String designation;
    @Column(name = "nb_days")
    private Integer nbDays;
    @Column(name = "unit_price", columnDefinition = "numeric")
    private Double unitPrice;
    @Transient
    private Double totalExcludeTaxe;
    @Transient
    private Double totalWithTaxe;
    @Enumerated
    @Column(name = "state")
    private StateOrder state;
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Order() {
    }

    public Order(String typePresta, String designation, Integer nbDays, Double unitPrice, StateOrder state) {
        this.typePresta = typePresta;
        this.designation = designation;
        this.nbDays = nbDays;
        this.unitPrice = unitPrice;
        this.state = state;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTypePresta() {
        return typePresta;
    }

    public void setTypePresta(String typePresta) {
        this.typePresta = typePresta;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public Integer getNbDays() {
        return nbDays;
    }

    public void setNbDays(Integer nbDays) {
        this.nbDays = nbDays;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Double getTotalExcludeTaxe() {
        this.totalExcludeTaxe = this.unitPrice * this.nbDays;
        return totalExcludeTaxe;
    }

    public Double getTotalWithTaxe() {
        this.totalWithTaxe = this.getTotalExcludeTaxe() * 1.2;
        return totalWithTaxe;
    }

    public StateOrder getState() {
        return state;
    }

    public void setState(StateOrder state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", typePresta='" + typePresta + '\'' +
                ", designation='" + designation + '\'' +
                ", nbDays=" + nbDays +
                ", unitPrice=" + unitPrice +
                ", totalExcludeTaxe=" + totalExcludeTaxe +
                ", totalWithTaxe=" + totalWithTaxe +
                ", state=" + state +
                ", client=" + client +
                '}';
    }
}
