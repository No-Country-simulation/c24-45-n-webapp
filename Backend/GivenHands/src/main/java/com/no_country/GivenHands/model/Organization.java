package com.no_country.GivenHands.model;

import com.no_country.GivenHands.model.enumeration.Cause;
import com.no_country.GivenHands.model.enumeration.Rol;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "organizations")
public class Organization {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private String username;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false)
    private String password;
    @Column (nullable = false, unique = true)
    private String name;
    @Column (nullable = false)
    private String description;
    @Enumerated(EnumType.STRING)
    @Column (nullable = false)
    private Cause cause;
    private Address address;
    @Column (nullable = false)
    private int phone;
    private String webSite;
    private String socialMedia;
    @Enumerated(EnumType.STRING)
    private Rol rol;

    public Organization() {
    }

    public Organization(Long id, String username, String email, String password, String name, String description, Cause cause, Address address, int phone, String webSite, String socialMedia, Rol rol) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.name = name;
        this.description = description;
        this.cause = cause;
        this.address = address;
        this.phone = phone;
        this.webSite = webSite;
        this.socialMedia = socialMedia;
        this.rol = rol;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Cause getCause() {
        return cause;
    }

    public void setCause(Cause cause) {
        this.cause = cause;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getWebSite() {
        return webSite;
    }

    public void setWebSite(String webSite) {
        this.webSite = webSite;
    }

    public String getSocialMedia() {
        return socialMedia;
    }

    public void setSocialMedia(String socialMedia) {
        this.socialMedia = socialMedia;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    @Override
    public String toString() {
        return "Organization{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", cause=" + cause +
                ", address=" + address +
                ", phone=" + phone +
                ", webSite='" + webSite + '\'' +
                ", socialMedia='" + socialMedia + '\'' +
                ", rol=" + rol +
                '}';
    }
}
