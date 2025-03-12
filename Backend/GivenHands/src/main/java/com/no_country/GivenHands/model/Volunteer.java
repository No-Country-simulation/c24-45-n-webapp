package com.no_country.GivenHands.model;

import com.no_country.GivenHands.model.enumeration.Preference;
import com.no_country.GivenHands.model.enumeration.Skill;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.Period;
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

    @Embedded
    private Address address;

    private LocalDate birthday;

    @Enumerated(EnumType.STRING)
    private Preference preference;

    @Enumerated(EnumType.STRING)
    private Skill skills;

    @ManyToMany(mappedBy = "volunteers")
    private Set<Project> projects;

    public Volunteer(Long id, RegisterUser registerUser, String name, String lastname, int age, int phone, Address address, LocalDate birthday, Preference preference, Skill skills, Set<Project> projects) {
        this.id = id;
        this.registerUser = registerUser;
        this.name = name;
        this.lastname = lastname;
        this.age = age;
        this.phone = phone;
        this.address = address;
        this.birthday = birthday;
        this.preference = preference;
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

    public void setAge(int age) {
        this.age = age;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Skill getSkills() {return skills;    }

    public void setSkills(Skill skills) { this.skills = skills;    }

    public Set<Project> getProjects() {
        return projects;
    }

    public void setProjects(Set<Project> projects) {
        this.projects = projects;
    }

    public LocalDate getBirthday() {  return birthday;    }

    public Preference getPreference() {  return preference;    }

    public void setPreference(Preference preference) {this.preference = preference;    }

    // Método para calcular la edad dinámicamente
    @Transient
    public int getAge() {
        if (birthday == null) {
            return 0; // Si no hay fecha de nacimiento, se devuelve 0
        }
        return Period.between(birthday, LocalDate.now()).getYears();
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
        this.age = (birthday != null) ? Period.between(birthday, LocalDate.now()).getYears() : 0;
    }

}
