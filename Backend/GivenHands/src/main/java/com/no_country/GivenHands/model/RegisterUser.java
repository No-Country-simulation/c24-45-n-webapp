package com.no_country.GivenHands.model;

import com.no_country.GivenHands.model.enumeration.Rol;
import jakarta.persistence.*;

@Entity
@Table(name = "RegisterUser")
public class RegisterUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String userName;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    private Rol rol;

    @OneToOne(mappedBy = "registerUser", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Volunteer volunteer;

    @OneToOne(mappedBy = "registerUser", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Organization organization;

    public RegisterUser(Long id, String userName, String email, String password, Rol rol) {
        this.id = id;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.rol = rol;
    }

    public RegisterUser(Long id, String userName, String email, String password, Rol rol, Volunteer volunteer, Organization organization) {
        this.id = id;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.rol = rol;
        this.volunteer = volunteer;
        this.organization = organization;
    }

    public RegisterUser() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public Volunteer getVolunteer() {
        return volunteer;
    }

    public void setVolunteer(Volunteer volunteer) {
        this.volunteer = volunteer;
    }

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }
}
