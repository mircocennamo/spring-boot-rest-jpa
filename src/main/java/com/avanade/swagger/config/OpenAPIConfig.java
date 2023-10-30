package com.avanade.swagger.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;


@Configuration
public class OpenAPIConfig {

  @Value("${avanade.openapi.dev-url}")
  private String devUrl;

  @Value("${avanade.openapi.prod-url}")
  private String prodUrl;

  @Bean
  public OpenAPI myOpenAPI() {
    Server devServer = new Server();
    devServer.setUrl(devUrl);
    devServer.setDescription("Server URL in Development environment");

    Server prodServer = new Server();
    prodServer.setUrl(prodUrl);
    prodServer.setDescription("Server URL in Production environment");

    Contact contact = new Contact();
    contact.setEmail("mirco.cennamo@avanade.com");
    contact.setName("Mirco Cennamo");
    contact.setUrl("https://www.linkedin.com/in/mirco-cennamo-2979463b/");

    License mitLicense = new License().name("My License").url("https://urlMyLicense/");

    Info info = new Info()
        .title("Spring Boot API Project for Avanade Courses")
        .version("1.0")
        .contact(contact)
        .description("This API exposes example to Avanade couse.").termsOfService("https://urlMyTermsOfService/")
        .license(mitLicense);

    return new OpenAPI().info(info).servers(List.of(devServer, prodServer));
  }
}
