package com.no_country.GivenHands.model;

import jakarta.persistence.*;
import org.springframework.stereotype.Component;

@Embeddable
public class Address {
    private String country;
    private String state;
    private String city;
    private String street;
    private String cp;

    // Constructor vacío para JPA
    public Address() {}

    // Constructor con parámetros
    public Address(String country, String state, String city, String street, String cp) {
        this.country = country;
        this.state = state;
        this.city = city;
        this.street = street;
        this.cp = cp;
    }

    // Getters y Setters
    public String getCountry() { return country; }
    public void setCountry(String country) { this.country = country; }

    public String getState() { return state; }
    public void setState(String state) { this.state = state; }

    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }

    public String getStreet() { return street; }
    public void setStreet(String street) { this.street = street; }

    public String getCp() { return cp; }
    public void setCp(String cp) { this.cp = cp; }
}
