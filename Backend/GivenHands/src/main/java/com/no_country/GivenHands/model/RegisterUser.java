package com.no_country.GivenHands.model;

import com.no_country.GivenHands.model.enumeration.Rol;
import jakarta.persistence.*;

@Entity
@Table(name = "registerUser")
public class RegisterUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userName;
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private Rol rol;

    public RegisterUser(Long id, String userName, String email, String password, Rol rol) {
        this.id = id;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.rol = rol;
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
}
