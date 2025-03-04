package com.no_country.GivenHands.service;

import com.no_country.GivenHands.dto.RegisterOrganizationDto;
import com.no_country.GivenHands.model.Address;
import com.no_country.GivenHands.model.Organization;
import com.no_country.GivenHands.model.RegisterUser;
import com.no_country.GivenHands.model.enumeration.Cause;
import com.no_country.GivenHands.model.enumeration.Rol;
import com.no_country.GivenHands.repository.OrganizationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RegisterOrganizationService {

    @Autowired
    private OrganizationRepository organizationRepository;

    @Transactional
    public void registerOrganization(RegisterOrganizationDto registerOrganizationDto)throws IllegalArgumentException {
        validationRegisterOrganization(registerOrganizationDto.userName(), registerOrganizationDto.email(),
                registerOrganizationDto.password(), registerOrganizationDto.password2(), registerOrganizationDto.name(),
                registerOrganizationDto.description());
        Organization newOrganization =new Organization();
        newOrganization.setUsername(registerOrganizationDto.userName());
        newOrganization.setEmail(registerOrganizationDto.email());
        newOrganization.setPassword(registerOrganizationDto.password());
        newOrganization.setName(registerOrganizationDto.name());
        newOrganization.setDescription(registerOrganizationDto.description());
        newOrganization.setCause(registerOrganizationDto.cause());
        newOrganization.setAddress(registerOrganizationDto.address());
        newOrganization.setPhone(registerOrganizationDto.phone());
        newOrganization.setWebSite(registerOrganizationDto.webSite());
        newOrganization.setSocialMedia(registerOrganizationDto.socialMedia());
        newOrganization.setRol(Rol.ORGANIZATION);
        organizationRepository.save(newOrganization);
    }
    public void validationRegisterOrganization(String userName, String email, String password, String password2,
                                               String name, String description)throws IllegalArgumentException{
        if (userName == null || userName.isEmpty()) {
            throw new IllegalArgumentException("El nombre de usuario no puede estar vacío.");
        }
        if (email == null || email.isEmpty() || !email.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
            throw new IllegalArgumentException("El email no es válido.");
        }
        if (password == null || password.length() < 8) {
            throw new IllegalArgumentException("La contraseña debe tener al menos 8 caracteres.");
        }
        if (!password.equals(password2)) {
            throw new IllegalArgumentException("Las contraseñas no coinciden.");
        }
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("El nombre de la organizacion no puede estar vacío.");
        }
        if (description == null || description.isEmpty()) {
            throw new IllegalArgumentException("La descripcion no puede estar vacía.");
        }
    }
}
