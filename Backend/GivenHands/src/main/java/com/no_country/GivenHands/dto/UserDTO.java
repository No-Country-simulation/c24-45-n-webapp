package com.no_country.GivenHands.dto;

import com.no_country.GivenHands.model.enumeration.Rol;

public record UserDTO(
        String userName,
        String email,
        Rol rol
) {

}
