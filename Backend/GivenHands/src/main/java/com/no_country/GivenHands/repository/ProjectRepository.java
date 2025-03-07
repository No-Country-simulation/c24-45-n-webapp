package com.no_country.GivenHands.repository;

import com.no_country.GivenHands.dto.ProjectDTO;
import com.no_country.GivenHands.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {

    @Query("SELECT p FROM Project p WHERE " +
            "(:name IS NULL OR LOWER(p.name) LIKE LOWER(CONCAT('%', :name, '%'))) AND " +
            "(:location IS NULL OR LOWER(p.location) LIKE LOWER(CONCAT('%', :location, '%'))) AND " +
            "(:type IS NULL OR LOWER(p.typeOfActivity) LIKE LOWER(CONCAT('%', :type, '%'))) AND " +
            "(:status IS NULL OR p.status = :status)")
    List<ProjectDTO> searchProjects(
            @Param("name") String name,
            @Param("location") String location,
            @Param("type") String type,
            @Param("status") Boolean status
    );
}
