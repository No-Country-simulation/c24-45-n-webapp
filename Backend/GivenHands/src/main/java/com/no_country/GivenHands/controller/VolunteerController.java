package com.no_country.GivenHands.controller;

import com.no_country.GivenHands.dto.OrganizationDTO;
import com.no_country.GivenHands.dto.ProjectDTO;
import com.no_country.GivenHands.dto.RequestVolunteerDTO;
import com.no_country.GivenHands.dto.VolunteerDTO;
import com.no_country.GivenHands.service.VolunteerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
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
    public ResponseEntity<Object> updateVolunteer(@PathVariable String id, @RequestBody RequestVolunteerDTO request) {
        try {
            VolunteerDTO updatedVolunteer = volunteerService.updateVolunteer(id, request);
            return ResponseEntity.ok(updatedVolunteer);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    // Eliminar voluntario
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProject(@PathVariable Long id) {
        volunteerService.deleteVolunteerById(id);
        return ResponseEntity.ok("Voluntario eliminado !!!");
    }

    // Listar proyectos asociados a un voluntario
    @GetMapping("/{id}/projects")
    public ResponseEntity<List<ProjectDTO>> getVolunteerProjects(@PathVariable Long id) {
        List<ProjectDTO> projects = volunteerService.getProjectsByVolunteerId(id);
        if (projects.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Collections.emptyList()); // Devuelve una lista vacía si no hay proyectos
        }
        return ResponseEntity.ok(projects);
    }

}
