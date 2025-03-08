package com.no_country.GivenHands.infra.springdoc;

import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;

public class SpringDocConfiguration {
    @Bean
    public OpenAPI customOpenAPI(){
        return new OpenAPI();
    }
}
