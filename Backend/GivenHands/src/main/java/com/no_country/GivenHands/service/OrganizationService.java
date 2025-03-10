package com.no_country.GivenHands.service;

import com.no_country.GivenHands.dto.OrganizationDTO;
import com.no_country.GivenHands.repository.OrganizationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrganizationService {

    @Autowired
    private OrganizationRepository organizationRepository;

    // Listar todas las organizaciones
    public List<OrganizationDTO> getAllOrganizations() {
        return organizationRepository.findAll()
                .stream()
                .map(OrganizationDTO::new)
                .collect(Collectors.toList());
    }

    // Buscar organizacion por id
    public Optional<OrganizationDTO> getOrganizationById(Long id) {
        return organizationRepository.findById(id)
                .map(OrganizationDTO::new);
    }



}