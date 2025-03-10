package com.no_country.GivenHands.service;

import com.no_country.GivenHands.dto.VolunteerDTO;
import com.no_country.GivenHands.model.RegisterUser;
import com.no_country.GivenHands.model.Volunteer;
import com.no_country.GivenHands.repository.RegisterUserRepository;
import com.no_country.GivenHands.repository.VolunteerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.Optional;

@Service
public class VolunteerService {
    @Autowired
    private VolunteerRepository volunteerRepository;
    private RegisterUserRepository registerUserRepository;

    // Buscar voluntario por id
    public Optional<VolunteerDTO> getVolunteerById(Long id) {
        return volunteerRepository.findById(id)
                .map(VolunteerDTO::new);
    }

    // Editar voluntario
    public VolunteerDTO updateVolunteer(Long id, Volunteer volunteerDetails) {
        return volunteerRepository.findById(id).map(existingVolunteer -> {
            // Verifica y actualiza los campos si no son nulos
            if (volunteerDetails.getName() != null) {
                existingVolunteer.setName(volunteerDetails.getName());
            }
            if (volunteerDetails.getLastname() != null) {
                existingVolunteer.setLastname(volunteerDetails.getLastname());
            }
            if (volunteerDetails.getAge() > 0) {
                existingVolunteer.setAge(volunteerDetails.getAge());
                // Validar la edad calculada a partir de la fecha de nacimiento
                int calculatedAge = calculateAge(volunteerDetails.getBirthday());
                if (calculatedAge < 18) {
                    throw new IllegalArgumentException("El voluntario debe tener al menos 18 años.");
                }
                existingVolunteer.setAge(calculatedAge);
            }
            if (volunteerDetails.getPhone() > 0) {
                existingVolunteer.setPhone(volunteerDetails.getPhone());
            }
            if (volunteerDetails.getBirthday() != null) {
                existingVolunteer.setBirthday(volunteerDetails.getBirthday());
            }
            if (volunteerDetails.getPreference() != null) {
                existingVolunteer.setPreference(volunteerDetails.getPreference());
            }
            if (volunteerDetails.getSkills() != null) {
                existingVolunteer.setSkills(volunteerDetails.getSkills());
            }
            if (volunteerDetails.getAddress() != null) {
                existingVolunteer.setAddress(volunteerDetails.getAddress());
            }

            // Buscando el registerUser en la BD
            if (volunteerDetails.getRegisterUser() != null) {
                RegisterUser user = registerUserRepository.findById(volunteerDetails.getRegisterUser().getId())
                        .orElseThrow(() -> new RuntimeException("Registro de usuario no encontrado"));
                existingVolunteer.setRegisterUser(user);
            }

            // Guarda los cambios en la base de datos
            Volunteer updatedVolunteer = volunteerRepository.save(existingVolunteer);

            // Retorna el DTO en lugar del objeto de entidad
            return new VolunteerDTO(updatedVolunteer);
        }).orElseThrow(() -> new RuntimeException("No se encontró el voluntario con ID: " + id));
    }

    public int calculateAge(LocalDate birthday) {
        if (birthday == null) return 0;
        return Period.between(birthday, LocalDate.now()).getYears();
    }

    // Eliminar voluntario
    public void deleteVolunteerById(Long id) {
        try {
            volunteerRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new RuntimeException("Voluntario no encontrado con el id: " + id);
        }
    }
}
