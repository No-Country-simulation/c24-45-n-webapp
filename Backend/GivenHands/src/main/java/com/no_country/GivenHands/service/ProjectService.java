package com.no_country.GivenHands.service;

import com.no_country.GivenHands.dto.ProjectDTO;
import com.no_country.GivenHands.model.Organization;
import com.no_country.GivenHands.model.Project;
import com.no_country.GivenHands.model.Volunteer;
import com.no_country.GivenHands.repository.OrganizationRepository;
import com.no_country.GivenHands.repository.ProjectRepository;
import com.no_country.GivenHands.repository.VolunteerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private OrganizationRepository organizationRepository;

    @Autowired
    private VolunteerRepository volunteerRepository;

    public void createProject(ProjectDTO projectDTO) {
        Project newProject = new Project();
        newProject.setName(projectDTO.name());
        newProject.setDescription(projectDTO.description());
        newProject.setLocation(projectDTO.location());
        newProject.setTypeOfActivity(projectDTO.typeOfActivity());
        newProject.setStatus(true);
        newProject.setStartDate(projectDTO.startDate());
        newProject.setEndDate(projectDTO.endDate());
        newProject.setSkillsRequired(projectDTO.skillsRequired());

        Organization organization = organizationRepository.findById(projectDTO.organizationId())
                .orElseThrow(()-> new RuntimeException("Organización no encontrada"));
        newProject.setOrganization(organization);
        projectRepository.save(newProject);
    }

    public void addVolunteerToProject(Long projectId, Long volunteerId){
        Project project = projectRepository.findById(projectId)
                .orElseThrow(()-> new RuntimeException("Proyecto no encontrado"));

        Volunteer volunteer = volunteerRepository.findById(volunteerId)
                .orElseThrow(()-> new RuntimeException("Voluntario no encontrado"));

        project.getVolunteers().add(volunteer);
        volunteer.getProjects().add(project);

        projectRepository.save(project);
        volunteerRepository.save(volunteer);

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