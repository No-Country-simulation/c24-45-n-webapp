package com.no_country.GivenHands.service;

import com.no_country.GivenHands.dto.LoginDTO;
import com.no_country.GivenHands.dto.LoginResponseOrganizationDTO;
import com.no_country.GivenHands.dto.LoginResponseVolunteerDTO;
import com.no_country.GivenHands.exception.MiException;
import com.no_country.GivenHands.model.Organization;
import com.no_country.GivenHands.model.RegisterUser;
import com.no_country.GivenHands.model.Volunteer;
import com.no_country.GivenHands.model.enumeration.Cause;
import com.no_country.GivenHands.model.enumeration.Rol;
import com.no_country.GivenHands.repository.RegisterUserRepository;
import com.no_country.GivenHands.infra.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LoginService {
    @Autowired
    private RegisterUserRepository registerUserRepository;

    @Autowired
    private JwtUtil jwtUtil;

//    @Transactional(readOnly = true)
//    public String loginUser(LoginDTO loginDTO) throws MiException{
//        RegisterUser registerUser = registerUserRepository.buscarPorEmail(loginDTO.email());
//        if(!(loginDTO.password().equals(registerUser.getPassword()) )){
//            throw new MiException("Credenciales incorrectas");
//        }
//        return jwtUtil.generateToken(registerUser.getId());
//    }

    @Transactional(readOnly = true)
    public Object loginUser(LoginDTO loginDTO) throws MiException{
        RegisterUser registerUser = registerUserRepository.buscarPorEmail(loginDTO.email());

        if(!(loginDTO.password().equals(registerUser.getPassword()) )){
            throw new MiException("Credenciales incorrectas");
        }
        String token = jwtUtil.generateToken(registerUser.getId());

        if(registerUser.getRol().equals(Rol.VOLUNTEER)){
            Volunteer volunteer = registerUser.getVolunteer();

            LoginResponseVolunteerDTO.UserDTO userDTO = new LoginResponseVolunteerDTO.UserDTO(
                    registerUser.getUserName(),
                    registerUser.getEmail(),
                    registerUser.getRol().toString()
            );

            return new LoginResponseVolunteerDTO(
                    token,
                    volunteer.getId(),
                    volunteer.getName(),
                    volunteer.getLastname(),
                    volunteer.getBirthday(),
                    volunteer.getAddress(),
                    volunteer.getPreference(),
                    volunteer.getPhone(),
                    volunteer.getSkills(),
                    userDTO
            );

        }else if (registerUser.getRol().equals(Rol.ORGANIZATION)){
            Organization organization = registerUser.getOrganization();

            LoginResponseOrganizationDTO.UserDTO userDTO = new LoginResponseOrganizationDTO.UserDTO(
                    registerUser.getUserName(),
                    registerUser.getEmail(),
                    registerUser.getRol().toString()
            );

            return new LoginResponseOrganizationDTO(
                    token,
                    organization.getId(),
                    organization.getName(),
                    organization.getDescription(),
                    organization.getCause(),
                    organization.getPhone(),
                    organization.getWebSite(),
                    organization.getSocialMedia(),
                    userDTO
            );
        }else{
            throw new MiException("Rol no válido.");
        }

    }

}
