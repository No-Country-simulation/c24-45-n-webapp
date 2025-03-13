package com.no_country.GivenHands.controller;

import com.no_country.GivenHands.dto.RegisterOrganizationDto;
import com.no_country.GivenHands.service.RegisterOrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/organization")
public class RegisterOrganizationController {

    @Autowired
    private RegisterOrganizationService registerOrganizationService;

    @PostMapping("/register")
    public ResponseEntity<Object> registerOrganization(@RequestBody RegisterOrganizationDto registerOrganizationDto) {
        try {
            registerOrganizationService.registerOrganization(registerOrganizationDto);
            String respuesta = "Organización registrada exitosamente.";
            Map<String, String> response = new HashMap<>();
            response.put("respuesta", respuesta);
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: " + e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Ocurrió un error inesperado.");
        }
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<Object> getUserOrganizationById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(registerOrganizationService.getUserOrganizationById(id));
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }
}
