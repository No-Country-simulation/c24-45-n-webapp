package com.no_country.GivenHands.dto;

import com.no_country.GivenHands.model.Volunteer;
import com.no_country.GivenHands.model.enumeration.Preference;
import com.no_country.GivenHands.model.enumeration.Skill;

import java.time.LocalDate;

public record VolunteerDTO(
        String name,
        String lastname,
        LocalDate birthday,
        String country,
        String state,
        String city,
        Preference preference,
        int phone,
        String street,
        String cp,
        Skill skills,
        Long userVolunteerId,
        UserDTO user // Nuevo campo para incluir los datos del usuario
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
                (volunteer.getRegisterUser() != null) ? volunteer.getRegisterUser().getId() : null,
                (volunteer.getRegisterUser() != null) ?
                        new UserDTO(volunteer.getRegisterUser().getUserName(),
                                volunteer.getRegisterUser().getEmail(),
                                volunteer.getRegisterUser().getRol()) : null
        );
    }
}
