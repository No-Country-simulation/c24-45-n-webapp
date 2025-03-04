package com.no_country.GivenHands.model;

import com.no_country.GivenHands.model.enumeration.Rol;
import com.no_country.GivenHands.model.enumeration.Skill;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column (unique = true)
    private String name;
    private String lastname;
    private int age;
    private String email;
    private int phone;
    private String location;
    @Enumerated(EnumType.STRING)
    private Rol rol;
    @Embedded
    private Address address;
    private String disponibilidad;
    @Enumerated(EnumType.STRING)
    private Skill skills;
}
