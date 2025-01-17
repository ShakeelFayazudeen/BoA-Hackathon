package com.tyl.mca.cashadvanceservice.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfiguration {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI().info(new
                        Info().title("title").version("version").description("description"))
                .addSecurityItem(new SecurityRequirement().addList("my security"))
                .components(new Components().addSecuritySchemes("my security",
                        new SecurityScheme().name("my security").type(SecurityScheme.Type.HTTP).scheme("bearer")));
    }
}