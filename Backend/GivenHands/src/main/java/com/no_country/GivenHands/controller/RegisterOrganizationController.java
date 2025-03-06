package com.no_country.GivenHands.controller;

import com.no_country.GivenHands.dto.RegisterOrganizationDto;
import com.no_country.GivenHands.service.RegisterOrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/organization")
public class RegisterOrganizationController {

    @Autowired
    private RegisterOrganizationService registerOrganizationService;

    @PostMapping("/register")
    public ResponseEntity registerOrganization(@RequestBody RegisterOrganizationDto registerOrganizationDto){
        try {
            registerOrganizationService.registerOrganization(registerOrganizationDto);
            return ResponseEntity.ok("Organizacion registrada");
        } catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
