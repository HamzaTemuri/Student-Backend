package com.example.studentbackend.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfig {
    @Bean
    public OpenAPI myOpenAPI() {
        Info info = new Info()
                .title("Student-Backend")
                .version("1.0")
                .description("This API exposes endpoints to manage students and their applications.");

        return new OpenAPI().info(info);
    }
}
