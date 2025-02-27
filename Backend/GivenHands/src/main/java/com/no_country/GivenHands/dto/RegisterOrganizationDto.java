package com.no_country.GivenHands.dto;

import com.no_country.GivenHands.model.Address;
import com.no_country.GivenHands.model.enumeration.Cause;
import com.no_country.GivenHands.model.enumeration.Rol;

public record RegisterOrganizationDto(
        String userName,
        String email,
        String password,
        String password2,
        String name,
        String description,
        Cause cause,
        Address address,
        int phone,
        String webSite,
        String socialMedia
) {

}
