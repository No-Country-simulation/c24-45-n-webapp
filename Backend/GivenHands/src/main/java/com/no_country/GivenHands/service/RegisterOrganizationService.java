package com.no_country.GivenHands.service;

import com.no_country.GivenHands.dto.RegisterOrganizationDto;
import com.no_country.GivenHands.dto.UserDTO;
import com.no_country.GivenHands.model.Organization;
import com.no_country.GivenHands.model.RegisterUser;
import com.no_country.GivenHands.model.enumeration.Rol;
import com.no_country.GivenHands.repository.OrganizationRepository;
import com.no_country.GivenHands.repository.RegisterUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

@Service
public class RegisterOrganizationService {

    @Autowired
    private RegisterUserRepository registerUserRepository;

    @Autowired
    private OrganizationRepository organizationRepository;

    @Transactional
    public void registerOrganization(RegisterOrganizationDto registerOrganizationDto)throws IllegalArgumentException {
        validationRegisterOrganization(registerOrganizationDto.userName(), registerOrganizationDto.email(),
                registerOrganizationDto.password(), registerOrganizationDto.password2(), registerOrganizationDto.name(),
                registerOrganizationDto.description());

        RegisterUser newRegisterUser = new RegisterUser();
        newRegisterUser.setUserName(registerOrganizationDto.userName());
        newRegisterUser.setEmail(registerOrganizationDto.email());
        newRegisterUser.setPassword(registerOrganizationDto.password());
        newRegisterUser.setRol(Rol.ORGANIZATION);
        registerUserRepository.save(newRegisterUser);

        Organization organization = new Organization();

        organization.setName(registerOrganizationDto.name());
        organization.setDescription(registerOrganizationDto.description());
        organization.setCause(registerOrganizationDto.cause());
        organization.setAddress(registerOrganizationDto.address());
        organization.setPhone(registerOrganizationDto.phone());
        organization.setWebSite(registerOrganizationDto.webSite());
        organization.setSocialMedia(registerOrganizationDto.socialMedia());
        organization.setRegisterUser(newRegisterUser);

        organizationRepository.save(organization);
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

    public Map<String, String> getUserOrganizationById(Long id) {
        RegisterUser registerUser = registerUserRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Usuario no encontrado"));

        UserDTO userDTO = new UserDTO(registerUser.getUserName(),
                registerUser.getEmail(), registerUser.getRol());

        Map<String, String> response = new HashMap<>();
        response.put("userName", userDTO.userName());
        response.put("email", userDTO.email());
        response.put("rol", userDTO.rol().toString());

        return response;
    }
}
