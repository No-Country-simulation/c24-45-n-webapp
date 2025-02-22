package com.no_country.GivenHands.service;

import com.no_country.GivenHands.model.Project;
import com.no_country.GivenHands.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}
