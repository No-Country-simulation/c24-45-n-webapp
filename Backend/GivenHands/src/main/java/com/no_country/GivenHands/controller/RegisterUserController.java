package com.no_country.GivenHands.controller;

import com.no_country.GivenHands.dto.RegisterUserDto;
import com.no_country.GivenHands.service.RegisterUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/userregister")
public class RegisterUserController {
    @Autowired
    private RegisterUserService registerUserService;

    @PostMapping("/register")
    public ResponseEntity regiterUser(@RequestBody RegisterUserDto registerUserDto) {
        try {
            registerUserService.regitrarUsuario(registerUserDto);
            return ResponseEntity.ok("Usuario Registrado!!");
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}

