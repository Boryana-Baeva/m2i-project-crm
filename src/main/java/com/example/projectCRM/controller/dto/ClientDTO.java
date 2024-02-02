package com.example.projectCRM.controller.dto;

import com.example.projectCRM.model.StateClient;

public class ClientDTO {
    private String company;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String address;
    private String zip;
    private String city;
    private String country;
    private StateClient state;

    public ClientDTO() {
    }

    public ClientDTO(String company, String firstName, String lastName,
                     String email, String phone, String address, String zip,
                     String city, String country, StateClient state) {
        this.company = company;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.zip = zip;
        this.city = city;
        this.country = country;
        this.state = state;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public StateClient getState() {
        return state;
    }

    public void setState(StateClient state) {
        this.state = state;
    }
}
