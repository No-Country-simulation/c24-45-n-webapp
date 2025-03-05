package com.no_country.GivenHands.service;

import com.no_country.GivenHands.dto.RegisterVolunteerDTO;
import com.no_country.GivenHands.model.RegisterUser;
import com.no_country.GivenHands.model.Volunteer;
import com.no_country.GivenHands.model.enumeration.Rol;
import com.no_country.GivenHands.repository.RegisterUserRepository;
import com.no_country.GivenHands.repository.VolunteerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterVolunteerService {
        @Autowired
        private RegisterUserRepository registerUserRepository;

        @Autowired
        private VolunteerRepository volunteerRepository;

    public void regiterUserVolunteer(RegisterVolunteerDTO registerVolunteerDTO) throws IllegalArgumentException {
        validationRegisterUser(registerVolunteerDTO.userName(), registerVolunteerDTO.email(), registerVolunteerDTO.password(), registerVolunteerDTO.password2());
        RegisterUser newRegisterUser=new RegisterUser();
        newRegisterUser.setUserName(registerVolunteerDTO.userName());
        newRegisterUser.setEmail(registerVolunteerDTO.email());
        newRegisterUser.setPassword(registerVolunteerDTO.password());
        newRegisterUser.setRol(Rol.VOLUNTEER);
        registerUserRepository.save(newRegisterUser);

        Volunteer volunteer = new Volunteer();
        volunteer.setRegisterUser(newRegisterUser);
        volunteerRepository.save(volunteer);


    }
    public void validationRegisterUser(String userName, String email, String password, String password2)throws IllegalArgumentException{
        if (userName == null || userName.isEmpty()) {
            throw new IllegalArgumentException("El nombre de usuario no puede estar vacío.");
        }
        if (email == null || email.isEmpty() || !email.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
            throw new IllegalArgumentException("El email no es válido.");
        }
        if (password == null || password.isEmpty() || password.length() < 8) {
            throw new IllegalArgumentException("La contraseña debe tener al menos 8 caracteres.");
        }
        if (!password.equals(password2)) {
            throw new IllegalArgumentException("Las contraseñas no coinciden.");
        }
    }

}
