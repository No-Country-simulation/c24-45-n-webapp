package com.no_country.GivenHands.dto;

import com.no_country.GivenHands.model.*;
import com.no_country.GivenHands.model.enumeration.Preference;
import com.no_country.GivenHands.model.enumeration.Skill;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import java.time.LocalDate;

public record VolunteerDTO(
        String name,
        String lastname,
        LocalDate birthday,
        String country,
        String state,
        String city,
        @Enumerated(EnumType.STRING)
        Preference preference,
        int phone,
        String street,
        String cp,
        @Enumerated(EnumType.STRING)
        Skill skills,
        Long userVolunteerId

) {
    public VolunteerDTO(Volunteer volunteer) {
        this(volunteer.getName(),
                volunteer.getLastname(),
                volunteer.getBirthday(),
                volunteer.getAddress().country(),
                volunteer.getAddress().state(),
                volunteer.getAddress().city(),
                volunteer.getPreference(),
                volunteer.getPhone(),
                volunteer.getAddress().street(),
                volunteer.getAddress().cp(),
                volunteer.getSkills(),
                volunteer.getRegisterUser().getId()
                );
    }
}
