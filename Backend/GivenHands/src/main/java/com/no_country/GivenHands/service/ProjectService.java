package com.no_country.GivenHands.service;

import com.no_country.GivenHands.model.Project;
import com.no_country.GivenHands.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;
    public void createProject(Project project) {
        Project newProject = new Project();
        newProject.setName(project.getName());
        newProject.setDescription(project.getDescription());
        newProject.setLocation(project.getLocation());
        newProject.setTypeOfActivity(project.getTypeOfActivity());
        newProject.setStatus(project.isStatus());
        newProject.setStartDate(project.getStartDate());
        newProject.setEndDate(project.getEndDate());
        newProject.setSkillsRequired(project.getSkillsRequired());
        newProject.setOrganization(project.getOrganization());
//        newProject.setUser(project.getUser());
        projectRepository.save(newProject);
    }

    public List<Project> getAllProjects() {
        return projectRepository.findAll();//recupera todos los proyectos
    }
    public Project getProjectById(Long id) {
        return projectRepository.findById(id).orElse(null);
    }

    public Project updateProject(Long id, Project projectDetails) {
        Optional<Project> projectOptional = projectRepository.findById(id);
        if (projectOptional.isPresent()) {
            Project project = projectOptional.get();
            project.setName(projectDetails.getName());
            project.setDescription(projectDetails.getDescription());
            project.setLocation(projectDetails.getLocation());
            project.setTypeOfActivity(projectDetails.getTypeOfActivity());
            project.setStatus(projectDetails.isStatus());
            project.setSkillsRequired(projectDetails.getSkillsRequired());
            project.setOrganization(projectDetails.getOrganization());
            return projectRepository.save(project);
        }else {
            return null;
        }
    }

    public void deleteProjectById(Long id) {
        try {
            projectRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new RuntimeException("Project not found with ID: " + id);
        }
    }

}