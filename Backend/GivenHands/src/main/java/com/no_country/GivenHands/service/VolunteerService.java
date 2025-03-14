package com.no_country.GivenHands.service;

import com.no_country.GivenHands.dto.ProjectDTO;
import com.no_country.GivenHands.dto.RequestVolunteerDTO;
import com.no_country.GivenHands.dto.UserDTO;
import com.no_country.GivenHands.dto.VolunteerDTO;
import com.no_country.GivenHands.model.Address;
import com.no_country.GivenHands.model.Project;
import com.no_country.GivenHands.model.RegisterUser;
import com.no_country.GivenHands.model.Volunteer;
import com.no_country.GivenHands.repository.ProjectRepository;
import com.no_country.GivenHands.repository.RegisterUserRepository;
import com.no_country.GivenHands.repository.VolunteerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VolunteerService {
    @Autowired
    private VolunteerRepository volunteerRepository;
    @Autowired
    private RegisterUserRepository registerUserRepository;
    private ProjectRepository projectRepository;

    // Buscar voluntario por id
//    public Optional<VolunteerDTO> getVolunteerById(Long id) {
//        return volunteerRepository.findById(id)
//                .map(VolunteerDTO::new);
//    }

    public Optional<VolunteerDTO> getVolunteerById(Long id) {
        return volunteerRepository.findById(id).map(volunteer -> {
            // Crear el DTO del voluntario
            VolunteerDTO volunteerDTO = new VolunteerDTO(volunteer);

            // Verificar si el voluntario tiene un usuario asociado
            if (volunteer.getRegisterUser() != null) {
                RegisterUser registerUser = volunteer.getRegisterUser();

                // Crear el DTO del usuario
                UserDTO userDTO = new UserDTO(registerUser.getUserName(),
                        registerUser.getEmail(),
                        registerUser.getRol());
            }

            return volunteerDTO;
        });
    }


    // Editar voluntario
    public VolunteerDTO updateVolunteer(String id, RequestVolunteerDTO request) {
        Long volunteerId = Long.parseLong(id);
        return volunteerRepository.findById(volunteerId).map(existingVolunteer -> {
            // Verifica y actualiza los campos si no son nulos
            if (request.name() != null) {
                existingVolunteer.setName(request.name());
            }
            if (request.lastname() != null) {
                existingVolunteer.setLastname(request.lastname());
            }
            // Validar si la fecha de nacimiento es válida y el voluntario tiene al menos 18 años
            if (request.birthday() != null) {
                int age = Period.between(request.birthday(), LocalDate.now()).getYears();
                if (age < 18) {
                    throw new IllegalArgumentException("El voluntario debe ser mayor de 18 años.");
                }
                existingVolunteer.setBirthday(request.birthday());
                existingVolunteer.setAge(age); // Se actualiza la edad
            }
            if (request.phone() != null && request.phone() > 0) {
                existingVolunteer.setPhone(request.phone());
            }
            if (request.preference() != null) {
                existingVolunteer.setPreference(request.preference());
            }
            if (request.skills() != null) {
                existingVolunteer.setSkills(request.skills());
            }
            if (request.country() != null || request.state() != null || request.city() != null ||
                    request.street() != null || request.cp() != null) {

                Address address = existingVolunteer.getAddress();
                if (address == null) {
                    address = new Address(); // Crear una nueva dirección si no existe
                }
                if (request.country() != null) {
                    address.setCountry(request.country());
                }
                if (request.state() != null) {
                    address.setState(request.state());
                }
                if (request.city() != null) {
                    address.setCity(request.city());
                }
                if (request.street() != null) {
                    address.setStreet(request.street());
                }
                if (request.cp() != null) {
                    address.setCp(request.cp());
                }
                existingVolunteer.setAddress(address);
            }

            // Guardar cambios en la BD
            Volunteer updatedVolunteer = volunteerRepository.save(existingVolunteer);

            // Devolver como VolunteerDTO
            return new VolunteerDTO(updatedVolunteer);
        }).orElseThrow(() -> new RuntimeException("No se encontró el voluntario con ID: " + volunteerId));
    }

    // Eliminar voluntario
    public void deleteVolunteerById(Long id) {
        try {
            volunteerRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new RuntimeException("Voluntario no encontrado con el id: " + id);
        }
    }

    // Listar todos los proyectos de un voluntario
    public List<ProjectDTO> getProjectsByVolunteerId(Long volunteerId) {
        return volunteerRepository.findById(volunteerId)
                .map(volunteer -> volunteer.getProjects().stream()
                        .map(ProjectDTO::new) // Convertimos cada `Project` en `ProjectDTO`
                        .collect(Collectors.toList()))
                .orElse(Collections.emptyList()); // Si no se encuentra el voluntario, devuelve lista vacía
    }

}
