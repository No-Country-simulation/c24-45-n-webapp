package com.no_country.GivenHands.service;

import com.no_country.GivenHands.dto.LoginDTO;
import com.no_country.GivenHands.exception.MiException;
import com.no_country.GivenHands.model.RegisterUser;
import com.no_country.GivenHands.repository.RegisterUserRepository;
import com.no_country.GivenHands.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LoginService {
    @Autowired
    private RegisterUserRepository registerUserRepository;

    @Autowired
    private JwtUtil jwtUtil;

    @Transactional(readOnly = true)
    public String loginUser(LoginDTO loginDTO) throws MiException{
        RegisterUser registerUser = registerUserRepository.buscarPorEmail(loginDTO.email());
        if(!(loginDTO.password().equals(registerUser.getPassword()) )){
            throw new MiException("Credenciales incorrectas");
        }
        return jwtUtil.generateToken(registerUser.getEmail());
    }

}
