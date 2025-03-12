package com.no_country.GivenHands.dto;

import com.no_country.GivenHands.model.Volunteer;
import com.no_country.GivenHands.model.enumeration.Preference;
import com.no_country.GivenHands.model.enumeration.Skill;

import java.time.LocalDate;

public record RequestVolunteerDTO(
    String name,
    String lastname,
    LocalDate birthday,
    String country,
    String state,
    String city,
    Preference preference,
    Integer phone,
    String street,
    String cp,
    Skill skills
) {

}
