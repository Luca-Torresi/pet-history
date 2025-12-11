package com.example.pet_history.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
        @Bean
        public OpenAPI customOpenAPI() {
                return new OpenAPI()
                        .info(new Info()
                                .title("Módulo de Historial Clínico - API")
                                .version("1.0.0")
                                .description("Documentación oficial de la API para el sistema INN-PET. " +
                                        "Este microservicio gestiona el ciclo de vida de las mascotas, " +
                                        "historiales clínicos, estudios, tratamientos y control de vacunación."));
        }
}
