package com.tyl.mca.cashadvanceservice.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI api() {
        return new OpenAPI().info(apiInfo());
    }

    private Info apiInfo() {
        return new Info()
                .title("Cash Advance Service")
                .description("Cash Advance Service REST API")
                .version("1.0.0")
                .termsOfService("Terms")
                .contact(new Contact().name("Tyl"));
    }
}
