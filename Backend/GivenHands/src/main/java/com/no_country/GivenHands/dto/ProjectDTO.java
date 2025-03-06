package com.no_country.GivenHands.dto;

import com.no_country.GivenHands.model.enumeration.Activity;
import com.no_country.GivenHands.model.enumeration.Skill;

import java.time.LocalDate;

public record ProjectDTO(
        String name,
        String description,
        String location,
        Activity typeOfActivity,
        LocalDate startDate,
        LocalDate endDate,
        Skill skillsRequired,
        Long organizationId
) {

}
