package com.no_country.GivenHands.model;

import com.no_country.GivenHands.model.enumeration.Activity;
import com.no_country.GivenHands.model.enumeration.Skill;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "projects")
public class Project {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column (unique = true)
        private String name;

        private String description;

        private String location;

        @Enumerated(EnumType.STRING)
        private Activity typeOfActivity;

        private boolean status;

        private LocalDate startDate;

        private LocalDate endDate;

        @Enumerated(EnumType.STRING)
        private Skill skillsRequired;

        @ManyToOne
        @JoinColumn(name = "organization_id")
        private Organization organization;

        @ManyToMany
        @JoinTable(
                name = "project_volunteer",
                joinColumns = @JoinColumn(name = "project_id"),
                inverseJoinColumns = @JoinColumn(name = "volunteer_id")
        )
        private Set<Volunteer> volunteers;

        public Project(Long id, String name, String description, String location, Activity typeOfActivity, boolean status, LocalDate startDate, LocalDate endDate, Skill skillsRequired, Organization organization, Set<Volunteer> volunteers) {
                this.id = id;
                this.name = name;
                this.description = description;
                this.location = location;
                this.typeOfActivity = typeOfActivity;
                this.status = status;
                this.startDate = startDate;
                this.endDate = endDate;
                this.skillsRequired = skillsRequired;
                this.organization = organization;
                this.volunteers = volunteers;
        }

        public Project() {
        }

        public Long getId() {
                return id;
        }

        public void setId(Long id) {
                this.id = id;
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

        public String getLocation() {
                return location;
        }

        public void setLocation(String location) {
                this.location = location;
        }

        public Activity getTypeOfActivity() {
                return typeOfActivity;
        }

        public void setTypeOfActivity(Activity typeOfActivity) {
                this.typeOfActivity = typeOfActivity;
        }

        public boolean isStatus() {
                return status;
        }

        public void setStatus(boolean status) {
                this.status = status;
        }

        public LocalDate getStartDate() {
                return startDate;
        }

        public void setStartDate(LocalDate startDate) {
                this.startDate = startDate;
        }

        public LocalDate getEndDate() {
                return endDate;
        }

        public void setEndDate(LocalDate endDate) {
                this.endDate = endDate;
        }

        public Skill getSkillsRequired() {
                return skillsRequired;
        }

        public void setSkillsRequired(Skill skillsRequired) {
                this.skillsRequired = skillsRequired;
        }

        public Organization getOrganization() {
                return organization;
        }

        public void setOrganization(Organization organization) {
                this.organization = organization;
        }

        public Set<Volunteer> getVolunteers() {
                return volunteers;
        }

        public void setVolunteers(Set<Volunteer> volunteers) {
                this.volunteers = volunteers;
        }
}
