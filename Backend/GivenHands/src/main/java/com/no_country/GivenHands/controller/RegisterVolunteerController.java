package com.no_country.GivenHands.controller;

import com.no_country.GivenHands.dto.RegisterVolunteerDTO;
import com.no_country.GivenHands.service.RegisterVolunteerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/volunteer")
public class RegisterVolunteerController {
    @Autowired
    private RegisterVolunteerService registerVolunteerService;

    @PostMapping("/register")
    public ResponseEntity regiterUser(@RequestBody RegisterVolunteerDTO registerVolunteerDTO) {
        try {
            registerVolunteerService.regiterUserVolunteer(registerVolunteerDTO);
            return ResponseEntity.ok("Usuario Voluntario Registrado!!");
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}

