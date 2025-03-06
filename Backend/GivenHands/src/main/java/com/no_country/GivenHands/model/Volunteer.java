package com.no_country.GivenHands.model;

import com.no_country.GivenHands.model.enumeration.Skill;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "Volunteer")
public class Volunteer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "register_user_id", nullable = false)
    private RegisterUser registerUser;

    private String name;

    private String lastname;

    private int age;

    private int phone;

    private String location;

    @Embedded
    private Address address;

    private String disponibilidad;

    @Enumerated(EnumType.STRING)
    private Skill skills;

    @ManyToMany(mappedBy = "volunteers")
    private Set<Project> projects;

    public Volunteer(Long id, RegisterUser registerUser, String name, String lastname, int age, int phone, String location, Address address, String disponibilidad, Skill skills, Set<Project> projects) {
        this.id = id;
        this.registerUser = registerUser;
        this.name = name;
        this.lastname = lastname;
        this.age = age;
        this.phone = phone;
        this.location = location;
        this.address = address;
        this.disponibilidad = disponibilidad;
        this.skills = skills;
        this.projects = projects;
    }

    public Volunteer() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public RegisterUser getRegisterUser() {
        return registerUser;
    }

    public void setRegisterUser(RegisterUser registerUser) {
        this.registerUser = registerUser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(String disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public Skill getSkills() {
        return skills;
    }

    public void setSkills(Skill skills) {
        this.skills = skills;
    }

    public Set<Project> getProjects() {
        return projects;
    }

    public void setProjects(Set<Project> projects) {
        this.projects = projects;
    }
}
