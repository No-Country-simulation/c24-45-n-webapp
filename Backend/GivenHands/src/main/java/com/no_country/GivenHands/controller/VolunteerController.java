package com.no_country.GivenHands.controller;

import com.no_country.GivenHands.dto.OrganizationDTO;
import com.no_country.GivenHands.dto.VolunteerDTO;
import com.no_country.GivenHands.model.Project;
import com.no_country.GivenHands.model.Volunteer;
import com.no_country.GivenHands.service.VolunteerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/volunteer")
public class VolunteerController {

    @Autowired
    private VolunteerService volunteerService;

    // Buscar voluntario por id
    @GetMapping("/{id}")
    public ResponseEntity<Object> getVolunteerById(@PathVariable Long id) {
        Optional<VolunteerDTO> volunteer = volunteerService.getVolunteerById(id);
        if (volunteer != null) {
            return ResponseEntity.ok(volunteer);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No hay informacion sobre el voluntario con id " + id);
        }
    }

    // Editar voluntario
    @PatchMapping("/{id}")
    public ResponseEntity<Object> updateVolunteer(@PathVariable Long id, @RequestBody Volunteer volunteer) {
        VolunteerDTO updatedVolunteer = volunteerService.updateVolunteer(id, volunteer);
        if (updatedVolunteer != null) {
            return ResponseEntity.ok(updatedVolunteer);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontró el voluntario con ID: " + id);
        }
    }

    // Eliminar voluntario
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProject(@PathVariable Long id) {
        volunteerService.deleteVolunteerById(id);
        return ResponseEntity.ok("Voluntario eliminado !!!");
    }
}
