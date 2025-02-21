package com.no_country.GivenHands.model;

public record Address(
        String country,
        String state,
        String city,
        String street,
        String cp
) {
}
