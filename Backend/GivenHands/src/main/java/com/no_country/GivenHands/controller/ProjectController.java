package com.no_country.GivenHands.controller;

import com.no_country.GivenHands.dto.ProjectDTO;
import com.no_country.GivenHands.exception.MiException;
import com.no_country.GivenHands.model.Project;
import com.no_country.GivenHands.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/project")
public class ProjectController {
    @Autowired
    private ProjectService projectService;

    @PostMapping("/register")
    public ResponseEntity crearProject(@RequestBody ProjectDTO projectDTO) {
        projectService.createProject(projectDTO);
        return ResponseEntity.ok("Proyecto Creado!!");
    }

    @PostMapping("/{projectId}/volunteers/{volunteerId}")
    public ResponseEntity<Object> addVolunteerToProject(@PathVariable Long projectId, @PathVariable Long volunteerId){
        try {
            projectService.addVolunteerToProject(projectId, volunteerId);
            return new ResponseEntity<>("Voluntario agregado correctamente!",HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

//    getAllProjects: Recupera y devuelve todos los proyectos.
    @GetMapping
    public ResponseEntity<List<ProjectDTO>> getAllProjects() {
        List<ProjectDTO> projects = projectService.getAllProjects();
        return ResponseEntity.ok(projects);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getProjectById(@PathVariable Long id) {
        Optional <ProjectDTO> project = projectService.getProjectById(id);
        if (project != null) {
            return ResponseEntity.ok(project);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontro proyecto con el id: " + id);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateProject(@PathVariable Long id, @RequestBody Project projectDetails) {
        Project updateProject = projectService.updateProject(id, projectDetails);
        if (updateProject != null) {
            return ResponseEntity.ok(updateProject);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontro el proyecto con id: " + id + " para actualizar");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProject(@PathVariable Long id) {
        projectService.deleteProjectById(id);
        return ResponseEntity.ok("Proyecto eliminado !!!");
    }
    //EJEMPLO:
//GET http://localhost:8080/project/search?name=voluntariado&location=Buenos Aires&type=Social&status=true
    @GetMapping("/search")
    public ResponseEntity<Object> searchProjects(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String location,
            @RequestParam(required = false) String type,
            @RequestParam(required = false) Boolean status) {

        List<ProjectDTO> projects = projectService.searchProjects(name, location, type, status);

        if (projects.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Collections.singletonMap("message", "No se encontraron proyectos con los criterios especificados."));
        }

        return ResponseEntity.ok(projects);
    }
}
