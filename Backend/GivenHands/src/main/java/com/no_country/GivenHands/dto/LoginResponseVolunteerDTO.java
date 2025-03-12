package com.no_country.GivenHands.dto;

import com.no_country.GivenHands.model.Address;
import com.no_country.GivenHands.model.enumeration.Preference;
import com.no_country.GivenHands.model.enumeration.Skill;

import java.time.LocalDate;

public record LoginResponseVolunteerDTO(
        String token,
        Long volunteerId,
        String name,
        String lastname,
        LocalDate birthday,
        Address address,
//        String country,
//        String state,
//        String city,
        Preference preference,
        int phone,
//        String street,
//        String cp,
        Skill skills,
        UserDTO user
) {
    public record UserDTO(
            String userName,
            String email,
            String rol
    ){}
}
