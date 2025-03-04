package com.no_country.GivenHands.controller;

import com.no_country.GivenHands.model.Project;
import com.no_country.GivenHands.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/project")
public class ProjectController {
    @Autowired
    private ProjectService projectService;
    @PostMapping("/register")
    public ResponseEntity crearProject(@RequestBody Project project) {
        projectService.createProject(project);
        return ResponseEntity.ok("Proyecto Creado!!");
    }
//    getAllProjects: Recupera y devuelve todos los proyectos.
    @GetMapping
    public ResponseEntity<List<Project>> getAllProjects() {
        List<Project> projects = projectService.getAllProjects();
        return ResponseEntity.ok(projects);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getProjectById(@PathVariable Long id) {
        Project project = projectService.getProjectById(id);
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
}
