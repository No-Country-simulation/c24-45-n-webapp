package com.no_country.GivenHands.controller;

import com.no_country.GivenHands.dto.RegisterVolunteerDTO;
import com.no_country.GivenHands.service.RegisterVolunteerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/volunteer")
public class RegisterVolunteerController {
    @Autowired
    private RegisterVolunteerService registerVolunteerService;

    @PostMapping("/register")
    public ResponseEntity<Object> regiterUser(@RequestBody RegisterVolunteerDTO registerVolunteerDTO) {
        try {
            registerVolunteerService.regiterUserVolunteer(registerVolunteerDTO);
            String respuesta = "Usuario Voluntario Registrado!!";
            Map<String, String> response = new HashMap<>();
            response.put("respuesta", respuesta);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<Object> getUserOrganizationById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(registerVolunteerService.getUserVolunteerById(id));
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }
}

