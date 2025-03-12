package com.no_country.GivenHands.service;

import com.no_country.GivenHands.dto.LoginDTO;
import com.no_country.GivenHands.dto.LoginResponseDTO;
import com.no_country.GivenHands.exception.MiException;
import com.no_country.GivenHands.model.RegisterUser;
import com.no_country.GivenHands.model.Volunteer;
import com.no_country.GivenHands.repository.RegisterUserRepository;
import com.no_country.GivenHands.infra.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

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
    public LoginResponseDTO loginUser(LoginDTO loginDTO) throws MiException{
        RegisterUser registerUser = registerUserRepository.buscarPorEmail(loginDTO.email());
        if(!(loginDTO.password().equals(registerUser.getPassword()) )){
            throw new MiException("Credenciales incorrectas");
        }
        String token = jwtUtil.generateToken(registerUser.getId());

        Volunteer volunteer = registerUser.getVolunteer();

        LoginResponseDTO.UserDTO userDTO = new LoginResponseDTO.UserDTO(
                registerUser.getUserName(),
                registerUser.getEmail(),
                registerUser.getRol().toString()
        );

        LoginResponseDTO response = new LoginResponseDTO(
                token,
                volunteer.getId(),
                volunteer.getName(),
                volunteer.getLastname(),
                volunteer.getBirthday(),
                volunteer.getAddress(),
//                volunteer.getAddress().getCountry(),
//                volunteer.getAddress().getState(),
//                volunteer.getAddress().getCity(),
                volunteer.getPreference(),
                volunteer.getPhone(),
//                volunteer.getAddress().getStreet(),
//                volunteer.getAddress().getCp(),
                volunteer.getSkills(),
                userDTO
        );

        return response;
    }

}
