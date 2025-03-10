package com.no_country.GivenHands.dto;

import com.no_country.GivenHands.model.RegisterUser;
import com.no_country.GivenHands.model.enumeration.Rol;

public record UserDTO(
        String userName,
        String email,
        Rol rol
) {
    public UserDTO(RegisterUser registerUser) {
        this(
                registerUser.getUserName(),
                registerUser.getEmail(),
                registerUser.getRol()
        );
    }

}
