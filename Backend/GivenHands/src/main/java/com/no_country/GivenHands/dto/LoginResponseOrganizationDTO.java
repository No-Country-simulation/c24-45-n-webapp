package com.no_country.GivenHands.dto;

import com.no_country.GivenHands.model.Address;
import com.no_country.GivenHands.model.enumeration.Cause;
import com.no_country.GivenHands.model.enumeration.Preference;
import com.no_country.GivenHands.model.enumeration.Skill;

import java.time.LocalDate;

public record LoginResponseOrganizationDTO(
        String token,
        Long userOrganizationId,
        String name,
        String description,
        Cause cause,
        int phone,
        String webSite,
        String socialMedia,
        UserDTO user
) {
    public record UserDTO(
            String userName,
            String email,
            String rol
    ){}
}
