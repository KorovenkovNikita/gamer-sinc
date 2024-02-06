package com.gsg.gamersync.settings;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(info = @Info(title = "gs", description = "GamerSync",
    version = "1.0", contact = @Contact(name = "nkorovenkov", email = "korovenkov.nik@mail.ru")))
public class SwaggerConfiguration {

}
