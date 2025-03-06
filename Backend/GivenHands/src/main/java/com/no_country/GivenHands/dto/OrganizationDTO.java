package com.no_country.GivenHands.dto;

import com.no_country.GivenHands.model.Organization;
import com.no_country.GivenHands.model.enumeration.Cause;

public record OrganizationDTO(
        String name,
        String description,
        Cause cause,
        int phone,
        String webSite,
        String socialMedia
) {


    public OrganizationDTO(Organization organization) {
        this(organization.getName(),
        organization.getDescription(),
        organization.getCause(),
        organization.getPhone(),
        organization.getWebSite(),
        organization.getSocialMedia());
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public String description() {
        return description;
    }

    @Override
    public Cause cause() {
        return cause;
    }

    @Override
    public int phone() {
        return phone;
    }

    @Override
    public String webSite() {
        return webSite;
    }

    @Override
    public String socialMedia() {
        return socialMedia;
    }
}
