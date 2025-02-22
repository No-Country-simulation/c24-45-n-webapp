package com.no_country.GivenHands.model;

import jakarta.persistence.*;
import org.springframework.stereotype.Component;

@Embeddable
public record Address(
        String country,
        String state,
        String city,
        String street,
        String cp
) {
}
