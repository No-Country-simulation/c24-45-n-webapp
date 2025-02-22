package com.no_country.GivenHands.model;

import com.no_country.GivenHands.model.enumeration.Cause;
import com.no_country.GivenHands.model.enumeration.Rol;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "organizations")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Organization {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column (unique = true)
    private String name;
    private String description;
    @Enumerated(EnumType.STRING)
    private Cause cause;
    private String email;
    private Address address;
    private int phone;
    private String webSite;
    private String socialMedia;
    @Enumerated(EnumType.STRING)
    private Rol rol;
}
