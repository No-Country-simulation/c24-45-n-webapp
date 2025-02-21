package com.no_country.GivenHands.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
@Entity
@Table(name = "projects")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
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
        private LocalDateTime startDate;
        private LocalDateTime endDate;
        @Enumerated(EnumType.STRING)
        private Skill skillsRequired;
        @ManyToOne
        @JoinColumn(name = "organization_id")
        private Organization organization;
        @ManyToOne
        @JoinColumn(name = "users_id")
        private User user;


    }
