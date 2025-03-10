package com.no_country.GivenHands.controller;

import com.no_country.GivenHands.dto.OrganizationDTO;
import com.no_country.GivenHands.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/organization")
public class OrganizationController {
    @Autowired
    private OrganizationService organizationService;

    // Listar todas las organizaciones
    @GetMapping
    public ResponseEntity<List<OrganizationDTO>> getAllOrganizations() {
        List<OrganizationDTO> organizations = organizationService.getAllOrganizations();
        return ResponseEntity.ok(organizations);
    }

    // Buscar organizacion por id
    @GetMapping("/{id}")
    public ResponseEntity<Object> getOrganizationById(@PathVariable Long id) {
        Optional<OrganizationDTO> organization = organizationService.getOrganizationById(id);
        if (organization != null) {
            return ResponseEntity.ok(organization);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontro la organizacion del id: " + id);
        }
    }
}

