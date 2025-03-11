package com.no_country.GivenHands.model;

import com.no_country.GivenHands.model.enumeration.Cause;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Organization")
public class Organization {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "register_user_id", nullable = false)
    private RegisterUser registerUser;

    @Column (nullable = false)
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

    @OneToMany(mappedBy = "organization", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Project> projects;


    public Organization() {
    }

    public Organization(Long id, RegisterUser registerUser, String name, String description, Cause cause, Address address, int phone, String webSite, String socialMedia, List<Project> projects) {
        this.id = id;
        this.registerUser = registerUser;
        this.name = name;
        this.description = description;
        this.cause = cause;
        this.address = address;
        this.phone = phone;
        this.webSite = webSite;
        this.socialMedia = socialMedia;
        this.projects = projects;
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

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }
}
