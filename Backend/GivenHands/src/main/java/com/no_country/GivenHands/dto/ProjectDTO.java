package com.no_country.GivenHands.dto;

import com.no_country.GivenHands.model.Organization;
import com.no_country.GivenHands.model.Project;
import com.no_country.GivenHands.model.enumeration.Activity;
import com.no_country.GivenHands.model.enumeration.Skill;

import java.time.LocalDate;
import java.util.stream.Collectors;

public record ProjectDTO(
        String name,
        String description,
        String location,
        Activity typeOfActivity,
        LocalDate startDate,
        LocalDate endDate,
        Skill skillsRequired,
        Long organizationId,
         String organizationName,
        int organizationPhone,
        String organizationWebsite

) {
    public ProjectDTO(Project project) {
        this(
                project.getName(),
                project.getDescription(),
                project.getLocation(),
                project.getTypeOfActivity(),
                project.getStartDate(),
                project.getEndDate(),
                project.getSkillsRequired(),
                project.getOrganization().getId(),
                project.getOrganization() != null ? project.getOrganization().getName() : null,
                project.getOrganization() != null ? project.getOrganization().getPhone() : null,
                project.getOrganization() != null ? project.getOrganization().getWebSite() : null
        );
    }

}

