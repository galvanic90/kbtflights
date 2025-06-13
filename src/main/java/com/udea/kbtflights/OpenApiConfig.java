package com.udea.kbtflights;

import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("KBT-Flights API")
                        .version("1.0.0")
                        .description("Documentación de la API KBT-Flights para la gestión de vuelos")
                );
    }
}
