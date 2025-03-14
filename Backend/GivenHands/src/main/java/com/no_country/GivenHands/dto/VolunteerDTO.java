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
        this(
                volunteer.getName(),
                volunteer.getLastname(),
                volunteer.getBirthday(),
                (volunteer.getAddress() != null) ? volunteer.getAddress().getCountry() : null,
                (volunteer.getAddress() != null) ? volunteer.getAddress().getState() : null,
                (volunteer.getAddress() != null) ? volunteer.getAddress().getCity() : null,
                volunteer.getPreference(),
                volunteer.getPhone(),
                (volunteer.getAddress() != null) ? volunteer.getAddress().getStreet() : null,
                (volunteer.getAddress() != null) ? volunteer.getAddress().getCp() : null,
                volunteer.getSkills(),
                (volunteer.getRegisterUser() != null) ? volunteer.getRegisterUser().getId() : null,
                (volunteer.getRegisterUser() != null) ?
                        new UserDTO(
                                volunteer.getRegisterUser().getUserName(),
                                volunteer.getRegisterUser().getEmail(),
                                volunteer.getRegisterUser().getRol()
                        ) : null
        );
    }
}
