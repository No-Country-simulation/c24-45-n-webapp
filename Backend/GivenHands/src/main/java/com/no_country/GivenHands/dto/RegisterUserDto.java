package com.no_country.GivenHands.dto;

public record RegisterUserDto(
         String userName,
         String email,
         String password,
         String password2
) {
}
