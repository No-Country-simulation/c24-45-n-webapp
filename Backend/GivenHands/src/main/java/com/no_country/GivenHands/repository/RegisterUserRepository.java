package com.no_country.GivenHands.repository;

import com.no_country.GivenHands.model.Project;
import com.no_country.GivenHands.model.RegisterUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RegisterUserRepository extends JpaRepository<RegisterUser, Long> {
    @Query("SELECT ru FROM RegisterUser ru WHERE ru.email = :email")
    public RegisterUser buscarPorEmail(@Param("email") String email);
}
