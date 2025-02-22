package com.no_country.GivenHands.controller;

import com.no_country.GivenHands.model.Project;
import com.no_country.GivenHands.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

}
